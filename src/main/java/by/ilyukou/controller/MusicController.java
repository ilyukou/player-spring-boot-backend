package by.ilyukou.controller;

import by.ilyukou.domain.Music;
import by.ilyukou.domain.MusicDto;
import by.ilyukou.property.FileStorageProperties;
import by.ilyukou.service.interfaces.DiskService;
import by.ilyukou.service.interfaces.MusicService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@CrossOrigin
@RestController
@RequestMapping(value = "/music")
public class MusicController {

    final MusicService musicService;
    final DiskService diskService;

    public MusicController(MusicService musicService, DiskService diskService) {
        this.musicService = musicService;
        this.diskService = diskService;
    }

    @PutMapping("/upload")
    public void uploadFile(
            @RequestBody MultipartFile file
    ) {
        musicService.saveFile(file);
        System.out.println(file.getContentType());
    }

    @GetMapping("/get")
    public ResponseEntity<Resource> get(
            @RequestParam Long id
    ) {
        Music music = musicService.getById(id);

        Resource resource = diskService.loadFileAsResource(music.getFileNameOnDisk());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(music.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/getType")
    public String getType(
            @RequestParam Long id
    ) {
        return musicService.getById(id).getType();
    }

}


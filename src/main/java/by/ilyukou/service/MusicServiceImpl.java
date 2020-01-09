package by.ilyukou.service;


import by.ilyukou.dao.MusicDao;
import by.ilyukou.domain.Music;
import by.ilyukou.service.interfaces.DiskService;
import by.ilyukou.service.interfaces.MusicService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl implements MusicService {

    final MusicDao musicDao;
    final DiskService diskService;

    public MusicServiceImpl(MusicDao musicDao, DiskService diskService) {
        this.musicDao = musicDao;
        this.diskService = diskService;
    }

    @Override
    public void save(Music music) {
        musicDao.save(music);
    }

    @Override
    public List<Music> findAll() {
        return musicDao.findAll();
    }

    @Override
    public void saveFile(MultipartFile file) {
        try {
            long idNextFile = musicDao.count();
            diskService.save(file.getInputStream(),idNextFile+"_"+file.getOriginalFilename());
            Music music = new Music(
                    file.getOriginalFilename(),
                    idNextFile+"_"+file.getOriginalFilename(),
                    file.getContentType()
            );
            save(music);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Music> findByName(String name) {
        return findAll().parallelStream()
                .filter(music -> music.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Override
    public Music getById(Long id) {
        return musicDao.getById(id);
    }
}

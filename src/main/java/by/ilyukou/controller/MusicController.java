package by.ilyukou.controller;

import by.ilyukou.domain.Music;
import by.ilyukou.service.interfaces.ElasticService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/music")
public class MusicController {

    final ElasticService elasticService;

    public MusicController(ElasticService elasticService) {
        this.elasticService = elasticService;
    }

    @GetMapping("/getAll")
    public List<Music> getAll(

    ){
        return elasticService.getAll();
    }

    @PutMapping("/add")
    public void add(
            @RequestParam String name
    ){
        Music music = new Music();
        music.setName(name);
        elasticService.add(music);
    }
}


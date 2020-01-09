package by.ilyukou.service;

import by.ilyukou.dao.MusicDao;
import by.ilyukou.domain.Music;
import by.ilyukou.service.interfaces.MusicService;
import by.ilyukou.service.interfaces.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ElasticSearchServiceImpl implements SearchService {


    final MusicService musicService;

    public ElasticSearchServiceImpl(MusicService musicService) {
        this.musicService = musicService;
    }

    @Transactional
    @Override
    public List<Music> get(String q) {
        Music music = new Music();
        music.setName(q);
        musicService.save(music);

        return musicService.findAll();
    }

    @Override
    public List<Music> search(String query) {
        return musicService.findByName(query);
    }
}

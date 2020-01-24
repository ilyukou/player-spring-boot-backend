package by.ilyukou.service;

import by.ilyukou.dao.MusicElasticRepository;
import by.ilyukou.domain.Music;
import by.ilyukou.service.interfaces.ElasticService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElasticServiceImpl implements ElasticService {

    final MusicElasticRepository musicElasticRepository;

    public ElasticServiceImpl(MusicElasticRepository musicElasticRepository) {
        this.musicElasticRepository = musicElasticRepository;
    }

    @Override
    public boolean save(MultipartFile file) {
        return false;
    }

    @Override
    public List<Music> getAll() {
        List<Music> result = new ArrayList<Music>();
        musicElasticRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Music> get(String query) {
        return null;
    }

    @Override
    public void add(Music music) {
        musicElasticRepository.save(music);
    }

    @Override
    public List<Music> findByName(String name) {
        return musicElasticRepository.findByName(name);
    }
}

package by.ilyukou.service.interfaces;

import by.ilyukou.domain.Music;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MusicService {
    void save(Music music);

    List<Music> findAll();

    void saveFile(MultipartFile file);

    List<Music> findByName(String name);

    Music getById(Long id);
}

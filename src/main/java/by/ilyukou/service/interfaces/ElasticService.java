package by.ilyukou.service.interfaces;

import by.ilyukou.domain.Music;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ElasticService {
    boolean save(MultipartFile file);

    List<Music> getAll();
    List<Music> get(String query);
    void add(Music music);

    List<Music> findByName(String name);
}

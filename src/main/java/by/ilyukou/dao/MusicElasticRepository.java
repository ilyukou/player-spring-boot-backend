package by.ilyukou.dao;

import by.ilyukou.domain.Music;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface MusicElasticRepository extends ElasticsearchRepository<Music,Long> {
    List<Music> findByName(String name);
}

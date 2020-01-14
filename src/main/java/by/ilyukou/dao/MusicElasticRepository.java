package by.ilyukou.dao;

import by.ilyukou.domain.Music;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MusicElasticRepository extends ElasticsearchRepository<Music,Long> {

}

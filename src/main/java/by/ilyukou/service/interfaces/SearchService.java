package by.ilyukou.service.interfaces;

import by.ilyukou.domain.Music;

import java.util.List;

public interface SearchService {

    List<Music> search(String query);

    List<Music> elasticSearch(String query);
}

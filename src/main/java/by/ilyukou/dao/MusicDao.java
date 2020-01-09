package by.ilyukou.dao;


import by.ilyukou.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicDao extends JpaRepository<Music,Long> {
    List<Music> findByName(String name);
    Music getById(Long id);
}

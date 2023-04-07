package fr.ipme.devops.service;


import fr.ipme.devops.entity.Song;
import fr.ipme.devops.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAll() {
        return this.songRepository.findAll();
    }

    public Optional<Song> getById(Long id) {
        return this.songRepository.findById(id);
    }
}

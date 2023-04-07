package fr.ipme.devops.service;

import fr.ipme.devops.entity.Album;
import fr.ipme.devops.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAll() {
        return this.albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(Long id) {
        return this.albumRepository.findById(id);
    }
}

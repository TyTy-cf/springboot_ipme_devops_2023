package fr.ipme.devops.rest_controller;

import fr.ipme.devops.entity.Song;
import fr.ipme.devops.repository.SongRepository;
import fr.ipme.devops.runtime_exception.SongNotFoundException;
import fr.ipme.devops.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/song")
public class SongRestController {

    private final SongService songService;

    @Autowired
    public SongRestController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getSongList() {
        return this.songService.getAll();
    }

    @GetMapping(path = "{id}")
    public Optional<Song> getSong(@PathVariable Long id) {
        Optional<Song> song = this.songService.getById(id);
        if (song.isEmpty()) {
            throw new SongNotFoundException(id);
        }
        return song;
    }

}

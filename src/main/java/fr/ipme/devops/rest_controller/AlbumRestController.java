package fr.ipme.devops.rest_controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ipme.devops.entity.Album;
import fr.ipme.devops.service.AlbumService;
import fr.ipme.devops.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/album")
public class AlbumRestController {

    private final AlbumService albumService;

    @Autowired
    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    @JsonView(Views.AlbumResponseView.class)
    public List<Album> getAlbumList() {
        return this.albumService.getAll();
    }
}

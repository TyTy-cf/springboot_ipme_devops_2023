package fr.ipme.devops.controller;

import fr.ipme.devops.entity.Song;
import fr.ipme.devops.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        List<Song> songs = songService.getAll();
        modelAndView.addObject("songs", songs);
        modelAndView.setViewName("songs.html");
        return modelAndView;
    }

}

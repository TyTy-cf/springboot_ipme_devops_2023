package fr.ipme.devops.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ipme.devops.views.Views;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.AlbumResponseView.class)
    private Long id;

    @JsonView(Views.AlbumResponseView.class)
    private String name;

    @JsonView(Views.AlbumResponseView.class)
    private Date publishedAt;

    @ManyToOne(targetEntity = Artist.class)
    @JsonView(Views.AlbumResponseView.class)
    private Artist artist;

    @ManyToMany(targetEntity = Song.class)
    @JoinTable(
            name = "album_song",
            joinColumns = @JoinColumn(
                    name = "album_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "song_id",
                    referencedColumnName = "id"
            )
    )
    private List<Song> songs = new ArrayList<>();

}

package fr.ipme.devops.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.ipme.devops.views.Views;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue
    @JsonView(Views.AlbumResponseView.class)
    private Long id;

    @JsonView(Views.AlbumResponseView.class)
    private String name;

    @OneToMany(targetEntity = Album.class, mappedBy = "artist")
    private List<Album> albums = new ArrayList<>();
}

package com.alexaportfolio.AlexaPortfolio.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * This class represents the Album entity
 * @author crodf
 */

@Data
@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int albumId;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = true, unique = false)
    private String description;

    @OneToMany(mappedBy = "album")
    private Set<AlbumPhoto> albumPhotos;
}

package com.alexaportfolio.AlexaPortfolio.models;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;

/**
 * This class represent the Photo entity
 * @author crodf
 */

@Data
@Entity
@Table(name = "album_photos")
public class AlbumPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int albumPhotoId;

    @Column(nullable = true, unique = false)
    private String name;

    @Column(nullable = true, unique = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "albumId")
    private Album album;
}

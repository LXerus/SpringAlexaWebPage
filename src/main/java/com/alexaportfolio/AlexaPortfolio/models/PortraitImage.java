package com.alexaportfolio.AlexaPortfolio.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity class for the images that will be rotated in the home view
 * @author crodf
 */

@Data
@Entity
@Table(name = "portrait_images")
public class PortraitImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int portraitImageId;

    @Column(nullable = false, unique = false)
    private String name;

    @Column (nullable = false, unique = false)
    private String imagePath;
}

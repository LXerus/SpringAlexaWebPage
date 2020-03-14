package com.alexaportfolio.AlexaPortfolio.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * This class represents the Photo entity
 * @author crodf
 */

@Data
@Entity
@Table(name = "project_photos")
public class ProjectPhoto {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int photoId;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private String path;

    @Column(nullable = true, unique = false)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;
}

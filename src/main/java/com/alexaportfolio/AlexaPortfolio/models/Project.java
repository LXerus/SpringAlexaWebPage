package com.alexaportfolio.AlexaPortfolio.models;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;

/**
 * This class represents the project entity, which will be used in the Portfolio Controller
 * @author crodf
 */
@Data
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;

    @Column(nullable = true, unique = false)
    private String title;

    @Column(nullable = true, unique = false)
    private String description;

}

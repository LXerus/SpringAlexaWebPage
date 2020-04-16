package com.alexaportfolio.AlexaPortfolio.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "project")
    private List<ProjectPhoto> projectPhotos = new ArrayList<>();

    /*@ManyToMany
    @JoinTable(
            name = "project_skill",
            joinColumns = {@JoinColumn(name = "projectId")},
            inverseJoinColumns = {@JoinColumn(name = "skillId")})
    private List<Skill> projectSkills = new ArrayList<>();*/

}

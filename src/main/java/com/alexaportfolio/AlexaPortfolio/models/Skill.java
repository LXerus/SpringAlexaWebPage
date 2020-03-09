package com.alexaportfolio.AlexaPortfolio.models;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;

/**
 * This class contains the information which will be used in the cards on the Home Controller
 * @author crodf
 */

@Data
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int skillId;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = false)
    private String description;

}

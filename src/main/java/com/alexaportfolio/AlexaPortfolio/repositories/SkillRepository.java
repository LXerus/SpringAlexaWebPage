package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.Album;
import com.alexaportfolio.AlexaPortfolio.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Holds a repository of Skills
 * @author crodf
 */

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
    public List<Skill> findByName(String name);
}

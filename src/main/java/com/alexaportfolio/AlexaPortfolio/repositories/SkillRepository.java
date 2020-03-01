package com.alexaportfolio.AlexaPortfolio.repositories;

import com.alexaportfolio.AlexaPortfolio.models.Skill;
import org.springframework.data.repository.CrudRepository;

/**
 * Holds a repository of Skills
 * @author crodf
 */
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}

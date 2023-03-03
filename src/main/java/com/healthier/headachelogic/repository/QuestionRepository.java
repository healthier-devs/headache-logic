package com.healthier.headachelogic.repository;

import com.healthier.headachelogic.domain.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    Optional<Question> findById(@Param("id") int id);
    Optional<Question> findByType(@Param("type") String type);
    Optional<Question> findByPainSiteContaining(@Param("pain_site") String painSite);
}

package es.happ.server.repositoy;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.QuestionEntity;

@Repository("questionRepository")
public interface QuestionRepository extends JpaRepository<QuestionEntity, Serializable>{

}

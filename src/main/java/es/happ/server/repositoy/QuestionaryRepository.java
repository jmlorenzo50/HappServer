package es.happ.server.repositoy;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.happ.server.entity.QuestionaryEntity;

@Repository("questionaryRepository")
public interface QuestionaryRepository extends JpaRepository<QuestionaryEntity, Serializable>{

}

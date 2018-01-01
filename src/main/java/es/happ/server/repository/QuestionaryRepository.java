package es.happ.server.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.happ.server.entity.QuestionaryEntity;

/**
 * The Interface QuestionaryRepository.
 */
@Repository("questionaryRepository")
public interface QuestionaryRepository extends JpaRepository<QuestionaryEntity, Serializable>{

	/**
	 * Find allscheduled pre is not null.
	 *
	 * @return the list
	 */
	public List<QuestionaryEntity> findByScheduledPreIsNotNull();

	/**
	 * Find allscheduled post is not null.
	 *
	 * @return the list
	 */
	public List<QuestionaryEntity> findByScheduledPostIsNotNull();
	
	
	/**
	 * Find questionary by questionaryId
	 * @param questionaryId  Cuestionary's identification
	 * @return Questionary
	 */
	public QuestionaryEntity findByQuestionaryId(Long questionaryId);

}

package es.happ.server.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.AnswerEntity;

/**
 * The Interface AnswerRepository.
 */
@Repository("answerRepository")
public interface AnswerRepository extends JpaRepository<AnswerEntity, Serializable>{

	/**
	 * Find by answer id.
	 *
	 * @param answerId the answer id
	 * @return the answer entity
	 */
	public abstract AnswerEntity findByAnswerId(Long answerId);

}

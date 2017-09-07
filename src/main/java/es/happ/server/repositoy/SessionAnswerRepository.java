package es.happ.server.repositoy;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.happ.server.entity.SessionAnswerEntity;

/**
 * The Interface SessionAnswerRepository.
 */
@Repository("sessionAnswerRepository")
public interface SessionAnswerRepository extends JpaRepository<SessionAnswerEntity, Serializable>{
	
	/**
	 * Find by session answer id.
	 *
	 * @param SessionAnswerId the session answer id
	 * @return the session answer entity
	 */
	public abstract SessionAnswerEntity findBySessionAnswerId(Long sessionAnswerId);

}

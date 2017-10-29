package es.happ.server.repositoy;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.SessionQuestionaryEntity;

/**
 * The Interface SessionQuestionaryRepository.
 */
@Repository("sessionQuestionaryRepository")
public interface SessionQuestionaryRepository extends JpaRepository<SessionQuestionaryEntity, Serializable>{
	
	/**
	 * Find by android id and finished.
	 *
	 * @param androidId the android id
	 * @param finished the finished
	 * @return the session questionary entity
	 */
	public abstract SessionQuestionaryEntity findByAndroidIdAndFinished(String androidId, Boolean finished);
	
	/**
	 * Find by session id.
	 *
	 * @param SessionId the session id
	 * @return the session questionary entity
	 */
	public abstract SessionQuestionaryEntity findBySessionId(Long sessionId);

	/**
	 * 
	 * @param androidIdId
	 * @return
	 */
	public abstract List<SessionQuestionaryEntity> findByAndroidIdOrderByDateSessionAsc(String androidId);

}

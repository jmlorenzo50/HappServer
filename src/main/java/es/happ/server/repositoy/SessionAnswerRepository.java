package es.happ.server.repositoy;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	/**
	 * Find by sessionId
	 * @param sessionId Session's Identification
	 * @return List of answers
	 */
    @Query("SELECT s FROM SessionAnswerEntity s WHERE s.sessionCuestionary.sessionId = :sessionId")
	public List<SessionAnswerEntity> findBySessionId(@Param("sessionId") Long sessionId);
    
	/**
	 * Count by sessionId
	 * @param sessionId Session's Identification
	 * @return Number of answers
	 */
    @Query("SELECT count(s) FROM SessionAnswerEntity s WHERE s.sessionCuestionary.sessionId = :sessionId")
    public Long countBySessionId(@Param("sessionId") Long sessionId);
    
    
	

}

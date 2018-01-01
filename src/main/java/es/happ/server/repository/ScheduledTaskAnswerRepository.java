package es.happ.server.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import es.happ.server.entity.ScheduledTaskAnswerEntity;

/**
 * The Interface ScheduledTaskAnswerRepository.
 */
@Repository("scheduledTaskAnswerRepository")
public interface ScheduledTaskAnswerRepository extends JpaRepository<ScheduledTaskAnswerEntity, Serializable>{
	
	/**
	 * Find by session answer id.
	 *
	 * @param SessionAnswerId the session answer id
	 * @return the session answer entity
	 */
	public abstract ScheduledTaskAnswerEntity findByScheduledTaskAnswerId(Long scheduledTaskAnswerId);
	
	/**
	 * Find by sessionId
	 * @param sessionId Session's Identification
	 * @return List of answers
	 */
    @Query("SELECT s FROM ScheduledTaskAnswerEntity s WHERE s.scheduledTaskQuestionary.scheduledTaskQuestionaryId = :scheduledTaskQuestionaryId")
	public List<ScheduledTaskAnswerEntity> findByScheduledTaskQuestionaryId(@Param("scheduledTaskQuestionaryId") Long scheduledTaskQuestionaryId);
    
	/**
	 * Count by sessionId
	 * @param sessionId Session's Identification
	 * @return Number of answers
	 */
    @Query("SELECT count(s) FROM ScheduledTaskAnswerEntity s WHERE s.scheduledTaskQuestionary.scheduledTaskQuestionaryId = :scheduledTaskQuestionaryId")
    public Long countByScheduledTaskQuestionaryId(@Param("scheduledTaskQuestionaryId") Long scheduledTaskQuestionaryId);
    
    
	

}

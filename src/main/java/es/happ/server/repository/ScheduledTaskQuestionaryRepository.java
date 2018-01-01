package es.happ.server.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.ScheduledTaskEntity;
import es.happ.server.entity.ScheduledTaskQuestionaryEntity;

/**
 * The Interface ScheduledTaskQuestionaryRepository.
 */
@Repository("scheduledTaskQuestionaryRepository")
public interface ScheduledTaskQuestionaryRepository extends JpaRepository<ScheduledTaskQuestionaryEntity, Serializable>{

	/**
	 * Find by scheduled task questionary id.
	 *
	 * @param scheduledTaskQuestionaryId the scheduled task questionary id
	 * @return the scheduled task questionary entity
	 */
	public abstract ScheduledTaskQuestionaryEntity findByScheduledTaskQuestionaryId(Long scheduledTaskQuestionaryId);
	
	/**
	 * 
	 * @param scheduledTask
	 * @return
	 */
	public abstract List<ScheduledTaskQuestionaryEntity> findByScheduledTaskOrderByScheduledTaskQuestionaryIdAsc(ScheduledTaskEntity scheduledTask);
	
	
}

package es.happ.server.repositoy;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.ScheduledTaskQuestionaryEntity;

@Repository("scheduledTaskQuestionaryRepository")
public interface ScheduledTaskQuestionaryRepository extends JpaRepository<ScheduledTaskQuestionaryEntity, Serializable>{


}

package es.happ.server.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.ScheduledTaskEntity;

@Repository("scheduledTaskRepository")
public interface ScheduledTaskRepository extends JpaRepository<ScheduledTaskEntity, Serializable>{

	public abstract List<ScheduledTaskEntity> findByDeviceAndFinishedDateIsNull(DeviceEntity device);

	public abstract List<ScheduledTaskEntity> findByDeviceOrderByScheduledDateAsc(DeviceEntity device);

	@Query("select count(a) > 0 from ScheduledTaskQuestionaryEntity a where a.scheduledTask = ?1 and a.finishedDate is null")
	public abstract boolean isAllQuestionaryFinish(ScheduledTaskEntity scheduledTask);

}

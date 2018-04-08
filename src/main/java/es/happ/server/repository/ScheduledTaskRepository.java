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

	@Query("select count(a) = 0 "
			+ "from ScheduledTaskQuestionaryEntity a, ScheduledTaskEntity b "
			+ "where b.device.androidId = ?1 "
			+ "and a.scheduledTask.scheduledTaskId = b.scheduledTaskId "
			+ "and a.scheduledTask.scheduledTaskId = ?2 "
			+ "and a.finishedDate is null")
	public abstract boolean isAllQuestionaryFinish(String androidId, Long scheduledTaskId);

}

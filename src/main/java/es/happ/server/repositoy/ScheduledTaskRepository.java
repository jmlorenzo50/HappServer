package es.happ.server.repositoy;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.ScheduledTaskEntity;

@Repository("scheduledTaskRepository")
public interface ScheduledTaskRepository extends JpaRepository<ScheduledTaskEntity, Serializable>{

	public abstract List<ScheduledTaskEntity> findByDeviceAndFinishedDateIsNull(DeviceEntity device);

}

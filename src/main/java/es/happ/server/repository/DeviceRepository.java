package es.happ.server.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.DeviceEntity;
import es.happ.server.model.GroupModel;

@Repository("deviceRepository")
public interface DeviceRepository extends JpaRepository<DeviceEntity, Serializable> {
	
	public abstract DeviceEntity findByandroidId(String androidId);
	
	
	@Query("select new es.happ.server.model.GroupModel (d.group, count(d)) from DeviceEntity d group by d.group")
	public abstract List<GroupModel> listGroups();


}

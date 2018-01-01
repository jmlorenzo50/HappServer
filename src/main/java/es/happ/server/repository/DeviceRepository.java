package es.happ.server.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.DeviceEntity;

@Repository("deviceRepository")
public interface DeviceRepository extends JpaRepository<DeviceEntity, Serializable> {
	
	public abstract DeviceEntity findByandroidId(String androidId);

}

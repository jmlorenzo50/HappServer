package es.happ.server.repository;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.ValuationEntity;

@Repository("valuationRepository")
public interface ValuationRepository extends JpaRepository<ValuationEntity, Serializable>{

	@Query("select v from ValuationEntity v where v.valuationDate > ?2 and v.valuationDate <= ?3 and v.device.androidId =?1 order by v.valuationId desc")
	public abstract List<ValuationEntity> listValuation(String androidId, Timestamp valuationDateBegin, Timestamp valuationDateEnd);

	
}

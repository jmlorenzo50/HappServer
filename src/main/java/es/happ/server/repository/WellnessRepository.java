package es.happ.server.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.happ.server.entity.WellnessEntity;

@Repository("wellnessRepository")
public interface WellnessRepository extends JpaRepository<WellnessEntity, Serializable>{

}

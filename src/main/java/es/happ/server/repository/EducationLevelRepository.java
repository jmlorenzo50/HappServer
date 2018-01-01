package es.happ.server.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.happ.server.entity.EducationLevelEntity;

/**
 * The Interface EducationLevelRepository.
 */
@Repository("educationLevelRepository")
public interface EducationLevelRepository extends JpaRepository<EducationLevelEntity, Serializable>{


	/**
	 * Find by code.
	 *
	 * @param code the code
	 * @return the education level entity
	 */
	public abstract EducationLevelEntity findByCode(String code);
	
	
	/**
	 * Find all order by ordered.
	 *
	 * @return the list
	 */
	public abstract List<EducationLevelEntity> findAllByOrderByOrderedAsc();
}

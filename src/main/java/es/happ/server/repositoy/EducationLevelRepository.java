package es.happ.server.repositoy;

import java.io.Serializable;

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

}

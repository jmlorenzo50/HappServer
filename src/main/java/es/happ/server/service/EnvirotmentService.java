package es.happ.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.EducationLevelConverter;
import es.happ.server.entity.EducationLevelEntity;
import es.happ.server.model.EducationLevelModel;
import es.happ.server.repositoy.EducationLevelRepository;

/**
 * The Class QuestionayService.
 */
@Service("envirotmentService")
public class EnvirotmentService {
	
	@Autowired
	@Qualifier("educationLevelRepository")
	private EducationLevelRepository educationLevelRepository;
	
	@Autowired
	@Qualifier("educationLevelConverter")
	private EducationLevelConverter educationLevelConverter;
	
	/**
	 * Gets the all questionaries.
	 *
	 * @return the all questionaries
	 */
	public List<EducationLevelModel> getAllEducationLevel() {
		List<EducationLevelModel> data = new ArrayList<>();
		List<EducationLevelEntity> le = educationLevelRepository.findAllByOrderByOrderedAsc();
		for (EducationLevelEntity educationLevelEntity : le) {
			EducationLevelModel model = (EducationLevelModel) educationLevelConverter.toModel(educationLevelEntity);
			data.add(model);
		}
		return data;
	}
	
	
}

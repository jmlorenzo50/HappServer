package es.happ.server.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.DeviceConverter;
import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.QuestionaryEntity;
import es.happ.server.entity.ScheduledTaskEntity;
import es.happ.server.entity.ScheduledTaskQuestionaryEntity;
import es.happ.server.model.DeviceModel;
import es.happ.server.repositoy.DeviceRepository;
import es.happ.server.repositoy.QuestionaryRepository;
import es.happ.server.repositoy.ScheduledTaskQuestionaryRepository;
import es.happ.server.repositoy.ScheduledTaskRepository;
import es.happ.server.types.Gender;
import es.happ.server.types.TypeTask;
import es.happ.server.util.DateUtil;

/**
 * The Class DeviceService.
 */
@Service("deviceService")
public class DeviceService {
	
	@Autowired
	@Qualifier("dateUtil")
	private DateUtil dateUtil;

	
	/** The device repository. */
	@Autowired
	@Qualifier("deviceRepository")
	private DeviceRepository deviceRepository;
	
	/** The device converter. */
	@Autowired
	@Qualifier("deviceConverter")
	private DeviceConverter deviceConverter;
	
	
	/** The questionary repository. */
	@Autowired
	@Qualifier("questionaryRepository")
	private QuestionaryRepository questionaryRepository;
	
	/** The scheduled task repository. */
	@Autowired
	@Qualifier("scheduledTaskRepository")
	private ScheduledTaskRepository scheduledTaskRepository;
	
	@Autowired
	@Qualifier("scheduledTaskQuestionaryRepository")
	private ScheduledTaskQuestionaryRepository scheduledTaskQuestionaryRepository;

	
	/**
	 * Search device.
	 *
	 * @param androidId the android id
	 * @return the device model
	 */
	public DeviceModel searchDevice(String androidId) {
		DeviceModel deviceModel = null;
		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);
		if (deviceEntity != null) {
			deviceModel = (DeviceModel) deviceConverter.toModel(deviceEntity);
		}
		return deviceModel;
	}

	/**
	 * Adds the device.
	 *
	 * @param id the id
	 * @return the device model
	 */
	public DeviceModel addDevice(String id) {
		DeviceEntity deviceEntity = new DeviceEntity();
		deviceEntity.setAndroidId(id);
		deviceEntity.setGender(Gender.NONE.name());
		deviceEntity.setAge(-1);
		deviceEntity.setDateInsert(new Timestamp(new Date().getTime()));
		deviceRepository.save(deviceEntity);
		
		
		// Programa tareas PRE
		Timestamp datePre = dateUtil.now();
		List<QuestionaryEntity> listQuestionaryPre = questionaryRepository.findByScheduledPreIsNotNull();
		if (listQuestionaryPre != null && !listQuestionaryPre.isEmpty()) {					
			ScheduledTaskEntity scheduledTaskEntity = new ScheduledTaskEntity();
			scheduledTaskEntity.setTypeTask(TypeTask.PRE_TEST.name());
			scheduledTaskEntity.setDevice(deviceEntity);
			scheduledTaskEntity.setScheduledDate(datePre);
			scheduledTaskRepository.save(scheduledTaskEntity);

			for (QuestionaryEntity questionaryEntity : listQuestionaryPre) {
				ScheduledTaskQuestionaryEntity scheduledTaskQuestionaryEntity = new ScheduledTaskQuestionaryEntity();
				scheduledTaskQuestionaryEntity.setQuestionary(questionaryEntity);
				scheduledTaskQuestionaryEntity.setScheduledTask(scheduledTaskEntity);
				scheduledTaskQuestionaryRepository.save(scheduledTaskQuestionaryEntity);
			}
		}
		
		// Programa tareas POST
		Timestamp datePost = dateUtil.nowAddMonth(1);
		List<QuestionaryEntity> listQuestionaryPost = questionaryRepository.findByScheduledPostIsNotNull();
		if (listQuestionaryPost != null && !listQuestionaryPost.isEmpty()) {
			ScheduledTaskEntity scheduledTaskEntity = new ScheduledTaskEntity();
			scheduledTaskEntity.setTypeTask(TypeTask.POST_TEST.name());
			scheduledTaskEntity.setDevice(deviceEntity);
			scheduledTaskEntity.setScheduledDate(datePost);
			scheduledTaskRepository.save(scheduledTaskEntity);

			for (QuestionaryEntity questionaryEntity : listQuestionaryPost) {
				ScheduledTaskQuestionaryEntity scheduledTaskQuestionaryEntity = new ScheduledTaskQuestionaryEntity();
				scheduledTaskQuestionaryEntity.setQuestionary(questionaryEntity);
				scheduledTaskQuestionaryEntity.setScheduledTask(scheduledTaskEntity);
				scheduledTaskQuestionaryRepository.save(scheduledTaskQuestionaryEntity);
			}
		}
		
		
		DeviceModel deviceModel = (DeviceModel) deviceConverter.toModel(deviceEntity);
		return deviceModel;
	}
	
	/**
	 * Update device.
	 *
	 * @param androidId the android id
	 * @param age the age
	 * @param gender the gender
	 * @return the device model
	 */
	public DeviceModel updateDevice(String androidId, int age, Gender gender) {
		DeviceModel deviceModel = searchDevice(androidId);
		if (deviceModel != null) {
			DeviceEntity deviceEntity = (DeviceEntity) deviceConverter.toEntity(deviceModel);
			deviceEntity.setGender(gender.name());
			deviceEntity.setAge(age);
			deviceEntity = deviceRepository.save(deviceEntity);
			deviceModel = (DeviceModel) deviceConverter.toModel(deviceEntity);
		}
		return deviceModel;
	}
	
	
	/**
	 * Checks for scheduled task.
	 *
	 * @param androidId the android id
	 * @return true, if successful
	 */
	public boolean hasScheduledTask(String androidId) {
		boolean hasScheduledTask = false;
		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);
		if (deviceEntity != null) {
			List<ScheduledTaskEntity> listTask = scheduledTaskRepository.findByDeviceAndFinishedDateIsNull(deviceEntity);
			if (listTask != null && !listTask.isEmpty()) {
				hasScheduledTask = true;
			}
		}
		return hasScheduledTask;
	}
	

}

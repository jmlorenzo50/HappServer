package es.happ.server.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.happ.server.converter.DeviceConverter;
import es.happ.server.entity.DeviceEntity;
import es.happ.server.entity.EducationLevelEntity;
import es.happ.server.entity.QuestionaryEntity;
import es.happ.server.entity.ScheduledTaskEntity;
import es.happ.server.entity.ScheduledTaskQuestionaryEntity;
import es.happ.server.model.DeviceModel;
import es.happ.server.model.GroupModel;
import es.happ.server.repository.DeviceRepository;
import es.happ.server.repository.EducationLevelRepository;
import es.happ.server.repository.QuestionaryRepository;
import es.happ.server.repository.ScheduledTaskQuestionaryRepository;
import es.happ.server.repository.ScheduledTaskRepository;
import es.happ.server.types.Gender;
import es.happ.server.types.MaritalStatus;
import es.happ.server.types.SystemConstans;
import es.happ.server.types.TypeGroup;
import es.happ.server.types.TypeTask;
import es.happ.server.util.DateUtil;

/**
 * The Class DeviceService.
 * @version 1.2
 */
@Service("deviceService")
public class DeviceService {
	
	/** The date util. */
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
	
	/** The scheduled task questionary repository. */
	@Autowired
	@Qualifier("scheduledTaskQuestionaryRepository")
	private ScheduledTaskQuestionaryRepository scheduledTaskQuestionaryRepository;
	
	/** The education level repository. */
	@Autowired
	@Qualifier("educationLevelRepository")
	private EducationLevelRepository educationLevelRepository;

	
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
		if (searchDevice(id) != null) {
			return null;
		}
		
		DeviceEntity deviceEntity = new DeviceEntity();
		deviceEntity.setAndroidId(id);
		deviceEntity.setGender(Gender.NONE.name());
		deviceEntity.setAge(-1);
		deviceEntity.setDateInsert(new Timestamp(new Date().getTime()));
		deviceEntity.setGroup(this.nextGroup());
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
		
		return (DeviceModel) deviceConverter.toModel(deviceEntity);
	}
	
	/**
	 * Update device.
	 *
	 * @param androidId the android id
	 * @param age the age
	 * @param gender the gender
	 * @param maritalStatus the maritalStatus 
	 * @param codeEducationLevel the codeEducationLevel
	 * @return the device model
	 */
	public DeviceModel updateDevice(String androidId, int age, Gender gender, MaritalStatus maritalStatus, String codeEducationLevel) {
		DeviceModel deviceModel = searchDevice(androidId);
		if (deviceModel != null) {
			EducationLevelEntity educationLevelEntity=educationLevelRepository.findByCode(codeEducationLevel);
			if (educationLevelEntity != null) {
				
				DeviceEntity deviceEntity = (DeviceEntity) deviceConverter.toEntity(deviceModel);
				deviceEntity.setGender(gender.name());
				deviceEntity.setAge(age);
				deviceEntity.setMaritalStatus(maritalStatus.name());
				deviceEntity.setEducationLevel(educationLevelEntity);
				
				deviceEntity = deviceRepository.save(deviceEntity);
				deviceModel = (DeviceModel) deviceConverter.toModel(deviceEntity);
			}
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
	
	/**
	 * Get the next code group.
	 *
	 * @return the next code group
	 */
	public String nextGroup() {
		HashMap<String, Long> allGroups = new HashMap<>(); 
		TypeGroup[] value = TypeGroup.values();
		for (TypeGroup typeGroup : value) {
			allGroups.put(typeGroup.name(), new Long(0));
		}
		
		String exitGroup = null;
		List<GroupModel> groups = deviceRepository.listGroups();
		for (GroupModel group : groups) {
			if (group.getCodeGroup() != null && group.getCodeGroup().trim().length() > 0) {
				allGroups.put(group.getCodeGroup(), group.getCountGroup());
			}
		}
	
		Set<String> setGroups = allGroups.keySet();
		GroupModel memGroup = null;
		for (String key : setGroups) {
			if (memGroup == null) {
				memGroup = new GroupModel();;
				memGroup.setCodeGroup(key);
				memGroup.setCountGroup(allGroups.get(key));
			} else {
				if (memGroup.getCountGroup() > allGroups.get(key)) {
					memGroup = new GroupModel();;
					memGroup.setCodeGroup(key);
					memGroup.setCountGroup(allGroups.get(key));
				}
			}
		}
		
		if (memGroup != null) {
			exitGroup = memGroup.getCodeGroup();
		}
		
		return exitGroup;
	}
	
	
	
	/**
	 * Change show video.
	 */
	public void changeShowVideo(String androidId, String videoAnswer, Long videoValue) {
		DeviceEntity deviceEntity = deviceRepository.findByandroidId(androidId);
		if (deviceEntity != null) {
			String codeGroup = deviceEntity.getGroup();
			if (TypeGroup.showVideo(codeGroup) && !SystemConstans.YES.equals(deviceEntity.getVideoView())) {
				deviceEntity.setVideoView(SystemConstans.YES);
				deviceEntity.setVideoAnswer(videoAnswer);
				deviceEntity.setVideoValue(videoValue);
				deviceRepository.save(deviceEntity);
			}
		}

	}
	

}

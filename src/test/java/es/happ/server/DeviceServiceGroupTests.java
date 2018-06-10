package es.happ.server;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import es.happ.server.model.GroupModel;
import es.happ.server.repository.DeviceRepository;
import es.happ.server.service.DeviceService;
import es.happ.server.types.TypeGroup;

/**
 * DeviceServiceTests
 * @version 1.0
 * @author jorge
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceGroupTests {

	@Mock
	@Qualifier("deviceRepository")
	private DeviceRepository deviceRepository;
	
	
	/** The device service. */
	@InjectMocks
	@Qualifier("deviceService")
	private DeviceService deviceService;
	
	@Test
	@Transactional
	public void nextGroupEmpty() {
		// GIVE
		List<GroupModel> groups = new ArrayList<>(); 
		Mockito.when(deviceRepository.listGroups()).thenReturn(groups);
		
		// WHEN
		String group = deviceService.nextGroup();
		
		// THEN
		Assert.isTrue(TypeGroup.A.name().equals(group) , "The group is incorrect ");
	}


	@Test
	@Transactional
	public void nextGroupA() {
		// GIVE
		List<GroupModel> groups = new ArrayList<>(); 
		Mockito.when(deviceRepository.listGroups()).thenReturn(groups);
		groups.add(new GroupModel(TypeGroup.A.name(), 1));
		groups.add(new GroupModel(TypeGroup.B.name(), 2));
		groups.add(new GroupModel(TypeGroup.C.name(), 2));
		groups.add(new GroupModel(TypeGroup.D.name(), 2));
		
		// WHEN
		String group = deviceService.nextGroup();
		
		// THEN
		Assert.isTrue(TypeGroup.A.name().equals(group) , "The group is incorrect ");
	}


	@Test
	@Transactional
	public void nextGroupB() {
		// GIVE
		List<GroupModel> groups = new ArrayList<>(); 
		groups.add(new GroupModel(TypeGroup.A.name(), 2));
		groups.add(new GroupModel(TypeGroup.B.name(), 1));
		groups.add(new GroupModel(TypeGroup.C.name(), 2));
		groups.add(new GroupModel(TypeGroup.D.name(), 2));

		Mockito.when(deviceRepository.listGroups()).thenReturn(groups);
		
		// WHEN
		String group = deviceService.nextGroup();
		
		// THEN
		Assert.isTrue(TypeGroup.B.name().equals(group) , "The group is incorrect ");
	}


	@Test
	@Transactional
	public void nextGroupC() {
		// GIVE
		List<GroupModel> groups = new ArrayList<>(); 
		groups.add(new GroupModel(TypeGroup.A.name(), 1));
		groups.add(new GroupModel(TypeGroup.B.name(), 1));
		groups.add(new GroupModel(TypeGroup.C.name(), 0));
		groups.add(new GroupModel(TypeGroup.D.name(), 1));

		Mockito.when(deviceRepository.listGroups()).thenReturn(groups);
		
		// WHEN
		String group = deviceService.nextGroup();
		
		// THEN
		Assert.isTrue(TypeGroup.C.name().equals(group) , "The group is incorrect ");
	}


	@Test
	@Transactional
	public void nextGroupD() {
		// GIVE
		List<GroupModel> groups = new ArrayList<>(); 
		groups.add(new GroupModel(TypeGroup.A.name(), 4));
		groups.add(new GroupModel(TypeGroup.B.name(), 5));
		groups.add(new GroupModel(TypeGroup.C.name(), 3));
		groups.add(new GroupModel(TypeGroup.D.name(), 1));

		Mockito.when(deviceRepository.listGroups()).thenReturn(groups);
		
		// WHEN
		String group = deviceService.nextGroup();
		
		// THEN
		Assert.isTrue(TypeGroup.D.name().equals(group) , "The group is incorrect ");
	}

}

package es.happ.server.rest.response;

import es.happ.server.model.DeviceModel;

/**
 * The Class HappDeviceAdd.
 */
public class HappDevice extends HappResponse {

	/** The device. */
	private DeviceModel device;
	
	/** The has scheduled task. */
	private Boolean hasScheduledTask;

	/**
	 * Gets the device.
	 *
	 * @return the device
	 */
	public DeviceModel getDevice() {
		return device;
	}

	/**
	 * Sets the device.
	 *
	 * @param device the new device
	 */
	public void setDevice(DeviceModel device) {
		this.device = device;
	}

	/**
	 * Gets the checks for scheduled task.
	 *
	 * @return the checks for scheduled task
	 */
	public Boolean getHasScheduledTask() {
		return hasScheduledTask;
	}

	/**
	 * Sets the checks for scheduled task.
	 *
	 * @param hasScheduledTask the new checks for scheduled task
	 */
	public void setHasScheduledTask(Boolean hasScheduledTask) {
		this.hasScheduledTask = hasScheduledTask;
	}

	
	
}

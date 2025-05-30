package semaphore.light;

import semaphore.util.TurnOnOff;

public class AbstractLight implements TurnOnOff {
	
	private OnOff state = OnOff.OFF;
	
	@Override
	public void turnOn() {
		this.state = OnOff.ON;
	}
	@Override
	public void turnOff() {
	this.state = OnOff.OFF;
	}
	@Override
	public boolean isOn() {
	return this.state == OnOff.ON;
	}
	@Override
	public boolean isOff() {
	return this.state == OnOff.OFF;
	}
	}
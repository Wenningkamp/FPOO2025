package semaphore.trafficLight.control;

public interface TrafficLightControl {

	
	void turnAlert();
	void turnGreen();
	void turnYellow();
	void turnRed();
	void turnOff();

public static enum State {
	GREEN, YELLOW, RED, ALERT, OFF
};
}


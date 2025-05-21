package semaphore.app;

import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import semaphore.control.simple.OneWaySemaphoreControl;
import semaphore.control.simple.SemaphoreControl;
import semaphore.trafficLight.control.SimpleTrafficLightControl;
import semaphore.trafficLight.control.TrafficLightControl;
import semaphore.trafficLight.simple.SimpleTrafficLight;
import semaphore.util.gui.MyWindow;

public class AppOneWayTwoSemaphoreControlTest {

	private MyWindow window = new MyWindow();
	private SemaphoreControl semaphoreControl;
	
	private TrafficLightControl createTrafficLight(Point position,
													Dimension dimension) throws IOException
	{
		SimpleTrafficLight trafficLight = new SimpleTrafficLight(position, dimension);
		window.add(trafficLight);
		
		return ( new SimpleTrafficLightControl(trafficLight));
		
	}
	
	private void create() throws IOException
	{
		List<TrafficLightControl> list = new ArrayList<>();
		list.add(createTrafficLight(new Point(100,100), new Dimension(70,180)));
		list.add(createTrafficLight(new Point(300,100), new Dimension(70,180)));
		
		semaphoreControl = new OneWaySemaphoreControl(list);
	} 
	
	
	public AppOneWayTwoSemaphoreControlTest() throws IOException {
		
		this.create();
		semaphoreControl.setAlertPeriod(LocalTime.now(),
										LocalTime.now().plusSeconds(30));
		semaphoreControl.turnOn();								
	}
	
	public static void main(String[] args) throws IOException {
		
		new AppOneWayTwoSemaphoreControlTest();
	}
}

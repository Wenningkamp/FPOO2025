package semaphore.spot;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import semaphore.light.e27.E27LightBulb;
import semaphore.light.e27.AbstractLightE27;

class SpotLightTest {


	@Test
	void shouldTurnOn() {
		//given
		AbstractLightE27 light = new E27LightBulb();
		SpotLight spot = new SpotLight(null, null);
		spot.setLight(light);
		
		
		//do action
		light.turnOff();
		spot.turnOn();
		
		//check
		assertTrue(light.isOn());
		assertTrue(spot.isOn());
	}

	@Test
	void shouldTurnOff()
	{
		//given
		AbstractLightE27 light = new E27LightBulb();
		SpotLight spot = new SpotLight(null, null);
		spot.setLight(light);
				
				
		//do action
		light.turnOn();
		spot.turnOff();
				
		//check
		assertTrue(light.isOff());
		assertTrue(spot.isOff());
		
		
	}
	/*@Test
	void shouldReturnCloneOfDimension()
	{
		//given
		SpotLight spot = new SpotLight(null);
		spot.setLight(new E27LightBulb());
		final int xLeft = 20;
		final int yTop = 50;
		spot.setPosition(xLeft, yTop);
		//do action
		Point position = spot.getPosition();
		position.setLocation(new Point(30,30));
		//check
		assertEquals(xLeft, spot.getPosition().getX());
		assertEquals(yTop , spot.getPosition().getY());
	}
	
	*/
	
	@Test
	void shouldReturnCloneOfDimension()
	{
	//given
	SpotLight spot = new SpotLight(null, null);
	spot.setLight(new E27LightBulb());
	spot.setDimension(new Dimension(50,60));
	
	//do action
	Dimension clone = spot.getDimension();
	clone.setSize(100, 120);
	// check
	int originalwidth = 50;
	int originalHeight = 60;
	int actualwidth = (int) spot.getDimension().getWidth();
	int actualHeight = (int) spot.getDimension().getHeight();
	
	assertEquals(originalwidth, actualwidth);
	assertEquals(originalHeight, actualHeight);
	
	}
}

	
package semaphore.light.e27;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import semaphore.light.Light;
import semaphore.light.e27.E27LightBulb;
class E27LightBulbTest {

	@Test
	void shouldTurnOn() {
		Light light = new E27LightBulb();

		light.turnOff();
		light.turnOn();
		
		assertTrue(light.isOn());

		}
	void shouldTurnOff() {
		Light light = new E27LightBulb();

		light.turnOn();
		light.turnOff();
		
		assertTrue(light.isOff());

}
}
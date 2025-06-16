package ticTacToe.component.button;

import java.awt.event.MouseEvent;

public class ButtonClickEvent {

	public static enum MouseButton{LEFT, MIDLE, RIGHT};
	
	public final Button source;
	public final MouseButton mouseButton;
	
	public ButtonClickEvent(Button source, MouseButton mouseButton) {
		
		this.source = source;
		this.mouseButton = mouseButton;
	}
	
	
}

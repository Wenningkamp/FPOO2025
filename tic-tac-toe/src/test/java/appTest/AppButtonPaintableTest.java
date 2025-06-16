package appTest;

import ticTacToe.component.button.Button;
import ticTacToe.gui.MainWindow;

public class AppButtonPaintableTest {

	public static void main(String[] args) {
		MainWindow window = new MainWindow();
		Button button = new Button();
		window.add(button);
		
		button = new Button(100,150);
		window.add(button);
		
		button = new Button(200,200,50,50);
		window.add(button);
		
	}
}

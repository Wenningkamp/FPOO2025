package appTest;

import java.awt.event.MouseEvent;

import ticTacToe.component.button.Button;
import ticTacToe.gui.MainWindow;

public class AppButtonClickTest {

	public static void main(String[] args) {
		
		MainWindow window = new MainWindow();
		Button blogin = new Button(100,100, 50, 50);
		window.add(blogin);
		window.addMouseListener(blogin.mouseListener());
		window.addMouseMotionListener(blogin.mouseMotionListener());
		window.addMouseMotionListener(blogin.mouseMotionListener());
		
		Button bCancel = new Button(160, 168, 50, 50);
		window.add(bCancel); 
		window.addMouseListener(bCancel.mouseListener()); 
		window.addMouseMotionListener(bCancel.mouseMotionListener());
		
		blogin.addButtonClickListener(event-> {
				System.out.println("você clicou LOGIN");
		});
			
		bCancel.addButtonClickListener(event ->{
				System.out.println("você clicou CANCEL");
		});
	}
}










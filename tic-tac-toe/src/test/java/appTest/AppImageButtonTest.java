package appTest;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ticTacToe.component.button.ImageButton;
import ticTacToe.gui.MainWindow;
import ticTacToe.component.button.ButtonClickEvent;
import ticTacToe.component.button.ButtonClickListener;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;


public class AppImageButtonTest {

	public static void main(String[] args) {
		
		final String path = "../ticTacToe/images/";
		URL url = AppImageButtonTest.class.getResource(path+ "buttonTest.png");
		ImageIcon icon = new ImageIcon(url);
		
		ImageButton button = new ImageButton(100,100,50,50, icon);
		
		MainWindow window = new MainWindow();
		window.add(button);
		window.addMouseListener(button.mouseListener());
		window.addMouseMotionListener(button.mouseMotionListener());
		}
		}
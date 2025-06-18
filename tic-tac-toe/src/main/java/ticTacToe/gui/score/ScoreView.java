package ticTacToe.gui.score;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.TextButton;
import ticTacToe.model.score.ReadOnlyScoreModel;

public class ScoreView extends AbstractComponent {

	    private ReadOnlyScoreModel scoreModel;
	    private TextButton scoreX;
	    private TextButton scoreO;
	    private ImageIcon background;

	    public ScoreView(int x, int y, int width, int height, ReadOnlyScoreModel scoreModel) {
	        super(x, y, width, height);
	        this.scoreModel = scoreModel;

	     
	        int buttonWidth = width / 2;
	        int buttonHeight = height;

	        scoreX = new TextButton(x, y, buttonWidth, buttonHeight);
	        scoreO = new TextButton(x + buttonWidth, y, buttonWidth, buttonHeight);
	    }

	    public void setBackground(ImageIcon background) {
	        this.background = background;
	    }

	
	@Override
	public void paint(Graphics g) {


        if (background != null) {
            Image img = background.getImage();
            g.drawImage(img, position.x, position.y, width(), height(), null);
        }
        scoreX.setText("X: " + scoreModel.scoreX());
        scoreO.setText("O: " + scoreModel.scoreO());

        scoreX.paint(g);
        scoreO.paint(g);
	}
}

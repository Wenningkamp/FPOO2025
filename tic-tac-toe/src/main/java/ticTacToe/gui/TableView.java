package ticTacToe.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import ticTacToe.component.AbstractComponent;
import ticTacToe.component.button.ImageButton;
import ticTacToe.model.Mark;
import ticTacToe.model.table.ReadOnlyTableModel;

public class TableView extends AbstractComponent {
	
	private ImageIcon icon = null;
	private ImageIcon iconX, iconO;
	private ImageButton[][] table = new ImageButton[3][3];
	private ReadOnlyTableModel tableModel;
	
	public TableView() {
		super();
		super.dimension = new Dimension(100,100);
		fillTable();
	}
	
	public TableView(ImageIcon icon) {
		super();
		this.icon = icon;
	}
	
	
	
	public TableView(int x, int y, int width, int height, ImageIcon icon) {
		super(x, y, width, height);
		this.icon = icon;
		fillTable();
	}
	
	private void fillTable() {
		
		int cellWidth = (width()-20)/3;
		int cellheight = (height()-20)/3;
		
		for(int lin = 0; lin<table.length; lin++) {
			for(int col = 0; col<table[lin].length; col++) {
				
				int x = 5 + (lin * (cellheight + 5));
				int y = 5 + (col * (cellWidth + 5));
				
				table[lin][col] = new ImageButton(x,y,cellWidth,cellheight,null);
			}
		}
	}
	
	public void setIconX(ImageIcon icon) {
		this.iconX = icon;
	}
	
	public void setIconO(ImageIcon icon) {
		this.iconO = icon;
	}
	
	public  ImageIcon iconOf(Mark mark) {
		return ((mark == Mark.O) ? iconO :
			((mark == Mark.X) ? iconX : null));
	}
	
	public void setTableModel(ReadOnlyTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	//--interface Paintable-----------------------------------------------------------
	private void paintChildren(Graphics g) {
		
		if(tableModel == null)
			throw new RuntimeException("Erro: TableModel is null at TableView!");
		
		for(int lin = 0; lin<table.length; lin++) {
			for(int col = 0; col<table[lin].length; col++) {
				Mark mark = tableModel.getMark(lin, col);
				table[lin][col].setImage(iconOf(mark));
				table[lin][col].paint(g);
			}
		}
	}

	
	
	@Override
	public void paint(Graphics g) {
		
		if(icon == null)
			throw new RuntimeException("Erro: TableModel is null at TableView!");
		
		int xLeft = position.x;
		int yTop = position.y;
		
		g.drawImage(icon.getImage(), xLeft, yTop, width(), height(), null);
		
		paintChildren(g);
	}
	
	@Override
	protected void onMouseMove(MouseEvent me) {
		
		for(int lin=0; lin<table.length; lin++) {
			for(int col=0; col<table[lin].length; col++) {
				
				table[lin][col].mouseMotionListener().mouseMoved(me);
			}
		}
	}
	
	
			
	
	List<CellClickListener> cellClickListeners = new ArrayList<>();
	
	public void addCellClickListener(CellClickListener listener) {
		cellClickListeners.add(listener);	
	}
	
	public void removeCellClickListener(CellClickListener listener) {
		cellClickListeners.remove(listener);	
	}
	
	private void dispatchCellClickEvent(int lin, int col) {
		CellClickEvent event = new CellClickEvent(lin, col);
		cellClickListeners.forEach(listener-> listener.onClick(event));
	}
	
	@Override 
	protected void onMouseClick(MouseEvent me) {
		
		for(int lin=0; lin<table.length; lin++) {
			for(int col=0; col<table[lin].length; col++) {
				if(table[lin][col].isOver(me.getPoint()))
					dispatchCellClickEvent(lin, col);
			}
		}
	}
}
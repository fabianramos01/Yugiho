package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import controller.ConstantList;

public class PanelPoints extends JPanel {

	private static final long serialVersionUID = 1L;

	private int points;
	
	public PanelPoints(int points) {
		this.points = points;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, calculatePixel(), ConstantList.POINT_HEIGTH);
		g.setColor(Color.BLACK);
		g.setFont(ConstantList.WORD_FONT);
		g.drawString(String.valueOf(points), 40, 40);
		g.drawRect(0, 0, ConstantList.POINT_WIDTH, ConstantList.POINT_HEIGTH);
	}
	
	private int calculatePixel() {
		return ConstantList.POINT_WIDTH*points/ConstantList.INITIAL_POINTS;
	}
}
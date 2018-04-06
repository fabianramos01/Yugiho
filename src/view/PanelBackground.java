package view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.ConstantList;

public class PanelBackground extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelBackground() {
		setLayout(new BorderLayout());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(
				new ImageIcon(getClass().getResource(ConstantList.IMG_CAMP))
						.getImage(), 0, 0, getSize().width, getSize().height,
				null);
	}

}
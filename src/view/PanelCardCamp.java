package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelCardCamp extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelCardCamp(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setOpaque(false);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
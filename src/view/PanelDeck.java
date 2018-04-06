package view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantList;

public class PanelDeck extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelDeck() {
	}

	public void loadDeck(int cards) {
		removeAll();
		updateUI();
		setLayout(new GridLayout(cards/2, 2));
		setOpaque(false);
		ImageIcon img = UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.BACK_CARD)), 40, 70);
		for (int i = 0; i < cards; i++) {
			add(new JLabel(img));
		}
	}
}
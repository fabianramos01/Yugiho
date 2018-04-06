package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantList;
import controller.Controller;
import model.Card;

public class PanelCamp extends JPanel {

	private static final long serialVersionUID = 1L;

	private Controller controller;

	public PanelCamp(Controller controller) {
		this.controller = controller;
	}

	public void loadCamp(Card[] playerOne, Card[] playerTwo, int player1Point, int player2Point) {
		removeAll();
		updateUI();
		setOpaque(false);
		add(panelPlayerCamp(playerOne, 0, player1Point ));
		add(new JLabel(UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.VS_ICON)),
				ConstantList.VS_SIZE, ConstantList.VS_SIZE)));
		add(panelPlayerCamp(playerTwo, 1, player2Point));
	}
	
	private JPanel panelPlayerCamp(Card[] player, int playerId, int playerPoints) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		JPanel panelBack = new JPanel(new BorderLayout());
		panelBack.setOpaque(false);
		panelBack.add(new PanelPoints(playerPoints), BorderLayout.NORTH);
		panelBack.add(panel, BorderLayout.CENTER);
		panel.setOpaque(false);
		for (int i = 0; i < player.length; i++) {
			if (player[i] != null) {
				panel.add(new LabelCard(controller, playerId, player[i]));
			} else {
				panel.add(new PanelCardCamp(ConstantList.WIDTH_CAMP_CARD, ConstantList.HEIGTH_CAMP_CARD));
			}
		}
		return panelBack;
	}
}
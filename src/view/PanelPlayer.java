package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ConstantList;
import controller.Controller;
import model.Card;
import model.Player;
import model.State;

public class PanelPlayer extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controller controller;

	public PanelPlayer(Controller controller) {
		this.controller = controller;
		setLayout(new BorderLayout());
	}

	public void loadCards(Player player) {
		this.removeAll();
		this.updateUI();
		setOpaque(false);
		JPanel jPanel = new JPanel(new GridLayout(1, 3));
		jPanel.setOpaque(false);
		for (Card card : player.getCards()) {
			jPanel.add(cardButton(player.getId(), card));
		}
		add(jPanel, BorderLayout.CENTER);
	}

	public JButton cardButton(int player, Card card) {
		JButton button = new JButton(String.valueOf(card.getId()));
		button.setFont(ConstantList.CARD_FONT);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.addActionListener(controller);
		button.setActionCommand(player + ConstantList.SEPARATOR + card.getId() + ConstantList.SEPARATOR + State.NONE);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setIcon(UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.CARD_ICON)),
				ConstantList.WIDTH_CARD, ConstantList.HEIGTH_CARD));
		button.setForeground(ConstantList.APP_COLOR);
		return button;
	}
}
package view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantList;
import controller.Controller;
import model.Card;
import model.State;

public class LabelCard extends JLabel {

	private static final long serialVersionUID = 1L;
	private Controller controller;

	public LabelCard(Controller controller, int id, Card card) {
		this.controller = controller;
		setSize(ConstantList.WIDTH_CAMP_CARD, ConstantList.HEIGTH_CAMP_CARD);
		setLayout(new GridLayout(2, 1));
		setIcon(UtilityList.scaledImage(new ImageIcon(getClass().getResource(ConstantList.CARD_ICON)), getWidth(),
				getHeight()));
		loadCard(id + ConstantList.SEPARATOR + card.getId() + ConstantList.SEPARATOR, String.valueOf(card.getId()),
				card);
	}

	private void loadCard(String command, String text, Card card) {
		JLabel jLabel = new JLabel(text);
		jLabel.setFont(ConstantList.CARD_FONT);
		jLabel.setHorizontalAlignment(JLabel.CENTER);
		jLabel.setVerticalAlignment(JLabel.CENTER);
		add(jLabel);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		if (card.getState().equals(State.NONE) || !card.getState().equals(State.RESURRECTION)) {
			panel.setLayout(new GridLayout(2, 2));
			panel.add(createLabel(String.valueOf(card.getAttack_value())));
			panel.add(createLabel(String.valueOf(card.getDefence_value())));
			panel.add(cardButton(command + State.ATTACK, State.ATTACK.toString()));
			panel.add(cardButton(command + State.DEFENCE, State.DEFENCE.toString()));
		} else {
			panel.add(cardButton(command + State.RESURRECTION, State.RESURRECTION.toString()));
		}
		add(panel);
	}

	private JLabel createLabel(String txt) {
		JLabel label = new JLabel(txt);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(ConstantList.WORD_FONT);
		return label;
	}

	public JButton cardButton(String command, String text) {
		JButton jButton = new JButton(text);
		jButton.setFont(ConstantList.WORD_FONT);
		jButton.setForeground(ConstantList.APP_COLOR);
		jButton.setActionCommand(command);
		jButton.setBorderPainted(false);
		jButton.setContentAreaFilled(false);
		jButton.addActionListener(controller);
		jButton.setHorizontalTextPosition(JButton.CENTER);
		jButton.setVerticalTextPosition(JButton.CENTER);
		return jButton;
	}
}
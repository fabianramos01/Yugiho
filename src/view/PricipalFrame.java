package view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ConstantList;
import controller.Controller;
import model.Card;
import model.Player;

public class PricipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private PanelPlayer panelPlayerOne;
	private PanelPlayer panelPlayerTwo;
	private PanelBackground panelBackground;
	private PanelDeck panelDeckOne;
	private PanelDeck panelDeckTwo;
	private PanelCamp panelCamp;

	public PricipalFrame(Controller controller) throws HeadlessException {
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.APP_ICON)).getImage());
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setTitle(ConstantList.APP_NAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		panelPlayerOne = new PanelPlayer(controller);
		panelPlayerTwo = new PanelPlayer(controller);
		panelBackground = new PanelBackground();
		panelDeckOne = new PanelDeck();
		panelBackground.add(panelDeckOne, BorderLayout.WEST);
		panelDeckTwo = new PanelDeck();
		panelBackground.add(panelDeckTwo, BorderLayout.EAST);
		panelCamp = new PanelCamp(controller);
		panelBackground.add(panelCamp, BorderLayout.CENTER);
		add(panelBackground);
	}

	public void loadCards(Player playerOne, Player playerTwo) {
		panelPlayerOne.loadCards(playerOne);
		panelPlayerTwo.loadCards(playerTwo);
		panelBackground.add(panelPlayerOne, BorderLayout.NORTH);
		panelBackground.add(panelPlayerTwo, BorderLayout.SOUTH);
	}
	
	public void loadDeck(int cardsPlayer1, int cardsPlayer2) {
		panelDeckOne.loadDeck(cardsPlayer1);
		panelDeckTwo.loadDeck(cardsPlayer2);
		setVisible(true);
	}

	public void loadCamp(Card[] listOne, Card[] listTwo, int player1Point, int player2Point) {
		panelCamp.loadCamp(listOne, listTwo, player1Point, player2Point);
	}
}
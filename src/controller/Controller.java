package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import model.GameManager;
import model.State;
import view.PricipalFrame;

public class Controller implements ActionListener {

	private PricipalFrame principalFrame;
	private GameManager gameManager;

	public Controller() {
		principalFrame = new PricipalFrame(this);
		gameManager = new GameManager();
		loadGame();
	}

	private void loadGame() {
		principalFrame.loadCards(gameManager.getPlayerOne(), gameManager.getPlayerTwo());
		principalFrame.loadCamp(gameManager.getPlayerOne().getCardCamp(), gameManager.getPlayerTwo().getCardCamp(),
				gameManager.getPlayerOne().getPoints(), gameManager.getPlayerTwo().getPoints());
		principalFrame.loadDeck(gameManager.getPlayerOne().getCardDeck().size(),
				gameManager.getPlayerTwo().getCardDeck().size());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StringTokenizer st = new StringTokenizer(e.getActionCommand(), ConstantList.SEPARATOR);
		int id = Integer.parseInt(st.nextToken());
		int idCard = Integer.parseInt(st.nextToken());
		String state = st.nextToken();
		if (state.equals(State.ATTACK.toString()) || state.equals(State.DEFENCE.toString())) {
			gameManager.setState(id, idCard, state.equals(State.ATTACK.toString()) ? State.ATTACK : State.DEFENCE);
			gameManager.validateGame();
			gameOver();
		} else if (state.equals(State.RESURRECTION.toString())) {
			System.out.println(id);
			gameManager.resurrect(id);
			loadGame();
		} else {
			gameManager.addCardCamp(id, idCard);
			loadGame();
		}
	}

	private void gameOver() {
		if (gameManager.getPlayerOne().getPoints() <= 0 || gameManager.getPlayerOne().getCards().isEmpty()) {
			gameOverMessage(gameManager.getPlayerOne().getId());
			principalFrame.dispose();
		} else if (gameManager.getPlayerTwo().getPoints() <= 0 || gameManager.getPlayerTwo().getCards().isEmpty()) {
			gameOverMessage(gameManager.getPlayerTwo().getId());
			principalFrame.dispose();
		} else {
			loadGame();
		}
	}

	private void gameOverMessage(int id) {
		JOptionPane.showMessageDialog(null, "EL jugador N." + (id + 1) + " ha perdido");
	}
}
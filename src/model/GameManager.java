package model;

public class GameManager {

	private Player playerOne;
	private Player playerTwo;

	public GameManager() {
		playerOne = new Player();
		playerTwo = new Player();
	}

	public void validateGame() {
		Card cardOne = playerOne.getCardGame();
		Card cardTwo = playerTwo.getCardGame();
		if (cardOne != null && cardTwo != null) {
			calculateGame(cardOne, cardTwo);
		}
	}

	private void calculateGame(Card cardOne, Card cardTwo) {
		if (cardOne.getState().equals(State.ATTACK) && cardTwo.getState().equals(State.DEFENCE)) {
			if (cardOne.getAttack_value() > cardTwo.getDefence_value()) {
				playerTwo.addToCementery(cardTwo);
			} else {
				playerOne.subtractPoints(cardTwo.getDefence_value() - cardOne.getAttack_value());
			}
			resetStates();
		} else if (cardOne.getState().equals(State.DEFENCE) && cardTwo.getState().equals(State.ATTACK)) {
			if (cardTwo.getAttack_value() > cardOne.getDefence_value()) {
				playerOne.addToCementery(cardOne);
			} else {
				playerTwo.subtractPoints(cardOne.getDefence_value() - cardTwo.getAttack_value());
			}
			resetStates();
		} else if (cardOne.getState().equals(State.ATTACK) && cardTwo.getState().equals(State.ATTACK)) {
			if (cardOne.getAttack_value() > cardTwo.getAttack_value()) {
				playerTwo.addToCementery(cardTwo);
			} else {
				playerOne.addToCementery(cardOne);
			}
			resetStates();
		}
	}

	public void resetStates() {
		for (int i = 0; i < playerOne.getCardCamp().length; i++) {
			if (playerOne.getCardCamp()[i] != null) {
				playerOne.getCardCamp()[i].setState(State.NONE);
			}
		}
		for (int i = 0; i < playerTwo.getCardCamp().length; i++) {
			if (playerTwo.getCardCamp()[i] != null) {
				playerTwo.getCardCamp()[i].setState(State.NONE);
			}
		}
	}

	public void addCardCamp(int idPlayer, int idCard) {
		if (idPlayer == playerOne.getId()) {
			playerOne.addToCamp(idCard);
		} else {
			playerTwo.addToCamp(idCard);
		}
	}

	public void setState(int idPlayer, int idCard, State state) {
		if (idPlayer == playerOne.getId()) {
			playerOne.setState(idCard, state);
		} else {
			playerTwo.setState(idCard, state);
		}
	}

	public void resurrect(int playerId) {
		if (playerId == playerOne.getId()) {
			playerOne.resurrection();
		} else {
			playerTwo.resurrection();
		}
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}
}
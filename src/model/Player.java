package model;

import java.util.ArrayList;
import java.util.Random;

import controller.ConstantList;

public class Player {

	private static int count;
	private int id;
	private int points;
	private MyStack<Card> cardDeck;
	private MyQueue<Card> cementery;
	private ArrayList<Card> hand;
	private Card[] cardsCamp;

	public Player() {
		id = count++;
		points = ConstantList.INITIAL_POINTS;
		cardDeck = new MyStack<>();
		cementery = new MyQueue<>();
		hand = new ArrayList<Card>();
		cardsCamp = new Card[2];
		loadDeck();
	}

	private void loadDeck() {
		int resCard = 0;
		Random random = new Random();
		for (int i = 0; i < ConstantList.DECK_SIZE; i++) {
			if (random.nextBoolean() && resCard < 3) {
				cardDeck.push(new Node<Card>(new Card(State.RESURRECTION)));
				resCard++;
			} else {
				cardDeck.push(new Node<Card>(new Card()));
			}
		}
		for (int i = 0; i < 3; i++) {
			hand.add(cardDeck.pop().getInfo());
		}
	}

	public void resurrection() {
		for (int i = 0; i < cardsCamp.length; i++) {
			if (cardsCamp[i].getState().equals(State.RESURRECTION)) {
				cardsCamp[i] = cementery.dequeue().getInfo();
			}
		}
	}

	public void addToCamp(int id) {
		Card cardCamp = null;
		for (Card card : hand) {
			if (id == card.getId()) {
				cardCamp = card;
			}
		}
		fullCardCamp(cardCamp);
	}

	public void fullCardCamp(Card newCard) {
		for (int i = 0; i < cardsCamp.length; i++) {
			if (cardsCamp[i] == null) {
				cardsCamp[i] = newCard;
				hand.remove(newCard);
				loadCard();
				break;
			}
		}
	}

	public void addToCementery(Card cardDestroy) {
		for (int i = 0; i < cardsCamp.length; i++) {
			if (cardDestroy.getId() == cardsCamp[i].getId()) {
				cementery.enqueue(new Node<Card>(cardsCamp[i]));
				cardsCamp[i] = null;
				break;
			}
		}
	}

	public void setState(int id, State state) {
		for (int i = 0; i < cardsCamp.length; i++) {
			if (cardsCamp[i] != null) {
				if (id == cardsCamp[i].getId()) {
					cardsCamp[i].setState(state);
				}
			}
		}
	}

	public void loadCard() {
		hand.add(cardDeck.pop().getInfo());
	}

	public Card getCardGame() {
		for (int i = 0; i < cardsCamp.length; i++) {
			if (cardsCamp[i] != null) {
				if (cardsCamp[i].getState().equals(State.ATTACK) || cardsCamp[i].getState().equals(State.DEFENCE)) {
					return cardsCamp[i];
				}
			}
		}
		return null;
	}

	public int getPoints() {
		return points;
	}

	public void subtractPoints(int lessPoint) {
		points -= lessPoint;
	}

	public MyStack<Card> getCardDeck() {
		return cardDeck;
	}

	public MyQueue<Card> getCementery() {
		return cementery;
	}

	public ArrayList<Card> getCards() {
		return hand;
	}

	public Card[] getCardCamp() {
		return cardsCamp;
	}

	public int getId() {
		return id;
	}
}
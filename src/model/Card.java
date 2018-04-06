package model;

import java.util.Random;

import controller.ConstantList;

public class Card {

	private int id;
	private State state;
	private int attack_value;
	private int defence_value;

	public Card() {
		Random random = new Random();
		id = random.nextInt(ConstantList.LIM_MAX_ID) * 1;
		state = State.NONE;
		attack_value = random.nextInt(ConstantList.LIM_MAX_CARD) * ConstantList.LIM_MIN_CARD;
		defence_value = random.nextInt(ConstantList.LIM_MAX_CARD) * ConstantList.LIM_MIN_CARD;
	}
	
	public Card(State state) {
		Random random = new Random();
		id = random.nextInt(ConstantList.LIM_MAX_ID) * 1;
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public int getAttack_value() {
		return attack_value;
	}

	public int getDefence_value() {
		return defence_value;
	}
}
/*
 * Shuffler.java 1/10/2012
 */
package solitaire.spider.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Shuffles the different suits of cards
 * @author Jake Bauer
 *
 */
public class Shuffler {
	/**
	 * ArrayList of unshuffled cards
	 */
	private List<Card> unshuffledCards = new ArrayList<Card>();
	
	/**
	 * ArrayList of shuffled cards
	 */
	private List<Card> shuffledCards = new ArrayList<Card>();
	
	/**
	 * Actual card object
	 */
	private Card card;
	
	/**
	 * Randomly selects a card
	 */
	private Random randomCardSelector = new Random();
	
	/**
	 * Value of the selected Card
	 */
	private int selectedCard = 0;


	/**
	 * Shuffles the given list of cards
	 * @param cards
	 * 		the list of cards
	 * @return
	 */
	public List<Card> shuffleCards(List<Card> cards) {
		this.unshuffledCards = cards;
		while(!unshuffledCards.isEmpty()){
			selectedCard = randomCardSelector.nextInt(unshuffledCards.size());
			card = unshuffledCards.get(selectedCard);
			unshuffledCards.remove(selectedCard);
			shuffledCards.add(card);
			System.out.println("Card Selected: " + card.getSuit() + " "
					+ card.getValue() + " " + card.getDeckNumber());
		}
		return shuffledCards;
	}
	
}

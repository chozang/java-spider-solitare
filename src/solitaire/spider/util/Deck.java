package solitaire.spider.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Card> hearts = new ArrayList<Card>();
	private List<Card> spades = new ArrayList<Card>();
	private List<Card> diamonds = new ArrayList<Card>();
	private List<Card> clubs = new ArrayList<Card>();
	private List<Card> deckOne = new ArrayList<Card>();
	private List<Card> deckTwo = new ArrayList<Card>();
	private List<Card> shuffledDeck = new ArrayList<Card>();
	private Card card;
	private Shuffler shuffler = new Shuffler();
	private Random randomCardSelector = new Random();
	int totalCardCount=104;
	int selected= 0;
	
	public Deck() {
		createCards();
		sortCards();
		shuffledDeck = shuffler.shuffleCards(hearts);
		hearts.clear();
		hearts.addAll(shuffledDeck);
		shuffledDeck.clear();
		shuffledDeck = shuffler.shuffleCards(spades);
		spades.clear();
		spades.addAll(shuffledDeck);
		shuffledDeck.clear();
		shuffledDeck = shuffler.shuffleCards(diamonds);
		diamonds.clear();
		diamonds.addAll(shuffledDeck);
		shuffledDeck.clear();
		shuffledDeck = shuffler.shuffleCards(clubs);
		clubs.clear();
		clubs.addAll(shuffledDeck);
		selected = randomCardSelector.nextInt(4);
		shuffleDeck();
		printDeck();
	}

	private void createCards() {
		Cards[] e = Cards.values();
		Suit[] suit = Suit.values();
		for (Suit theSuit : suit) {
			for (Cards theCard : e) {
				card = new Card(theSuit, theCard, null,0);
				deckOne.add(card);
				card = new Card(theSuit, theCard, null,1);
				deckTwo.add(card);
			}
		}
	}
	
	public void cardOut(){
		deckOne.addAll(deckTwo);
		for(Card theCard : deckOne){
			System.out.println(theCard.getValue().toString()+" of " + theCard.getSuit().toString()+ " Deck Number: " + theCard.getDeckNumber());
			System.out.println();
		}
	}
	
	private void sortCards(){
		deckOne.addAll(deckTwo);
		for(Card theCard : deckOne){
			if(theCard.getSuit().compareTo(Suit.HEART)==0){
				hearts.add(theCard);
			}else if(theCard.getSuit().compareTo(Suit.DIAMONDS)==0){
				diamonds.add(theCard);
			}else if(theCard.getSuit().compareTo(Suit.CLUBS)==0){
				clubs.add(theCard);
			}else{
				spades.add(theCard);
			}
		}
		System.out.println(hearts.size() + " number of hearts");
		System.out.println(diamonds.size() + " number of diamonds");
		System.out.println(clubs.size() + " number of clubs");
		System.out.println(spades.size() + " number of spades");
	}
	
	private void printDeck(){
		for(Card theCard : shuffledDeck){
			System.out.println(theCard.getValue() + " of " + theCard.getSuit());
		}
	}
	
	private void shuffleDeck(){
		shuffledDeck.clear();
		System.out.println(hearts.size() + " hearts");
		while(!hearts.isEmpty() || !spades.isEmpty() || !clubs.isEmpty() || !diamonds.isEmpty()){
			selected = randomCardSelector.nextInt(4);
			System.out.println("");
			System.out.println("Hearts " + hearts.isEmpty());
			System.out.println("Spades " + spades.isEmpty());
			System.out.println("Clubs " + clubs.isEmpty());
			System.out.println("Diamonds " + diamonds.isEmpty());
			if(selected == 3 && !hearts.isEmpty()){
				card = hearts.get(0);
				hearts.remove(0);
				shuffledDeck.add(card);
				totalCardCount--;
			}else if(selected == 2 && !clubs.isEmpty()){
				card = clubs.get(0);
				clubs.remove(0);
				shuffledDeck.add(card);
				totalCardCount--;
			}else if(selected == 1 && !spades.isEmpty()){
				card = spades.get(0);
				spades.remove(0);
				System.out.println(spades.size());
				shuffledDeck.add(card);
				totalCardCount--;
			}else if(selected == 0 && !diamonds.isEmpty()){
				card = diamonds.get(0);
				diamonds.remove(0);
				shuffledDeck.add(card);
				totalCardCount--;
			}else{
				System.out.println("System Error");
			}
		}
	}
}

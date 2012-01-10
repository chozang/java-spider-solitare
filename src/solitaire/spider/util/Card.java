package solitaire.spider.util;


/**
 * Creates and controls the individual card items
 * @author Jacob Bauer
 *
 */
public class Card {
	private Suit suit;
	private Cards value;
	private String imageLocation;
	private boolean topCard;
	private Integer deckNumber;
	
	public Card(Suit suit, Cards value, String imageLocation, Integer deckNumber){
		this.suit = suit;
		this.value = value;
		this.imageLocation = imageLocation;
		this.topCard = false;
		this.deckNumber = deckNumber;
	}
	
	public Suit getSuit(){
		return this.suit;
	}
	
	public String getImage(){
		return this.imageLocation;
	}
	
	public Cards getValue(){
		return this.value;
	}
	
	public void setTopCard(boolean status){
		this.topCard = status;
	}
	
	public Integer getDeckNumber(){
		return this.deckNumber;
	}
}

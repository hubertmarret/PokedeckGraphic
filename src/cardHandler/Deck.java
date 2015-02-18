package cardHandler;

import java.io.Serializable;
import java.util.ArrayList;

public class Deck implements Serializable {
	private static final long serialVersionUID = 99L;
	
	private ArrayList<Card> deck;
	
	public Deck()
	{
		deck = new ArrayList<Card>();
	}
	
	public int findCard(String name)
	{
		int index = -1;
		int cpt = 0;
		for(Card c : deck)
		{
			if(c.name.equals(name))
			{
				index = cpt;
				break;
			}
			cpt++;
		}
		return index;
	}
	
	public Card getCard(int index)
	{
		return deck.get(index);
	}
	
	private ArrayList<Card> findCardsByType(CardType cardType)
	{
		ArrayList<Card> cards = new ArrayList<>();
		for(Card c : deck)
		{
			if(c.cardType == cardType)
			{
				cards.add(c);
			}
		}
		return cards;
	}
	
	private ArrayList<Card> findCardsByCollection(String collection)
	{
		ArrayList<Card> cards = new ArrayList<>();
		for(Card c : deck)
		{
			if(c.collection.equals(collection))
			{
				cards.add(c);
			}
		}
		return cards;
	}
	
	public void addCard(Card c)
	{
		deck.add(c);
	}
	
	public void delCard(int index)
	{
		deck.remove(deck.get(index));
	}
	
	public String displayCard(int index)
	{
		return deck.get(index).toString();
	}
	
	public String displayDeck()
	{
		String str = "";
		for(Card c : deck)
		{
			str += c.toString()+"\n";
		}
		return str;
	}
	
	public String displayByType(CardType cardType)
	{
		String str = "";
		for(Card c : findCardsByType(cardType))
		{
			str += c.toString()+"\n";
		}
		return str;
	}
	
	public String displayByCollection(String collection)
	{
		String str = "";
		for(Card c : findCardsByCollection(collection))
		{
			str += c.toString()+"\n";
		}
		return str;
	}
}

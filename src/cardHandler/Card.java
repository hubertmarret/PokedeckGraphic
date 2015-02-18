package cardHandler;

import java.io.Serializable;

import descriptor.CardDescriptor;
import descriptor.PokemonDescriptor;
import descriptor.TrainerDescriptor;


public class Card implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String name;
	public CardType cardType;
	public String collection;
	
	public Card()
	{
		name = "noName";
		cardType = CardType.POKEMONCARD;
		collection = "unknown";
	}
	public Card(String name, CardType cardType, String collection)
	{
		this.name = name;
		this.cardType = cardType;
		this.collection = collection;
	}
	public Card(CardDescriptor cardDesc)
	{
		name = cardDesc.name;
		cardType = cardDesc.cardType;
		collection = cardDesc.collection;
	}
	
	public void setCard(String name, CardType cardType, String collection)
	{
		this.name = name;
		this.collection = collection;
	}
	public void setCard(CardDescriptor cardDesc)
	{
		name = cardDesc.name;
		collection = cardDesc.collection;
	}
	public void setCard(CardDescriptor cardDesc, PokemonDescriptor pokeDesc)
	{
		name = cardDesc.name;
		collection = cardDesc.collection;
	}
	public void setCard(CardDescriptor cardDesc, TrainerDescriptor trDesc)
	{
		name = cardDesc.name;
		collection = cardDesc.collection;
	}
	public void setCard(CardDescriptor cardDesc, PokemonType pokemonType)
	{
		name = cardDesc.name;
		collection = cardDesc.collection;
	}
	
	public void display()
	{
		System.out.println("Name : "+name);
		System.out.println("CardType : "+cardType);
		System.out.println("Collection : "+collection);
	}
	
	public String toString()
	{
		return "Name : "+name+"\nCardType : "+cardType+"\nCollection : "+collection+"\n";
	}
}

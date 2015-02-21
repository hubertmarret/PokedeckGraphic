package cardHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ui.UserChoice;
import ui.UserInterface;
import descriptor.CardDescriptor;
import descriptor.PokemonDescriptor;
import descriptor.TrainerDescriptor;

@SuppressWarnings("unused")
public class Game {
	
	private UserInterface ui;
	private Deck deck;
	
	public Game()
	{
		ui = new UserInterface();
		createDeck();
	}
	
	private static class GameHolder
	{
		private final static Game instance = new Game();
	}
	
	public static Game getInstance()
	{
		return GameHolder.instance;
	}
	
	private void createDeck()
	{
		deck = null;
		try {
			FileInputStream fis = new FileInputStream("deck.serial");
			ObjectInputStream ois= new ObjectInputStream(fis);
			try {	
				deck = (Deck) ois.readObject(); 
			} finally {
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		if(deck == null) {
			deck = new Deck();
		}
	}
	
	
	private PokemonDescriptor setPokemon(int health, PokemonType type)
	{
		PokemonDescriptor pokeDesc = new PokemonDescriptor();
		pokeDesc.health = health;
		pokeDesc.pokemonType = type;
		pokeDesc.description = "a default description";
		return pokeDesc;
	}
	
	private CardDescriptor setCard(String name, String collection)
	{
		CardDescriptor cardDesc = new CardDescriptor();
		cardDesc.name = name;
		cardDesc.cardType = CardType.POKEMONCARD;
		cardDesc.collection = collection;
		return cardDesc;
	}
	
	public boolean addCard(String name, String collection, int health, PokemonType type)
	{
		boolean exists = true;
		int index = findCard(name);
		if(index < 0)
		{
			exists = false;
			Card c = new Pokemon(setCard(name, collection), setPokemon(health, type));
			deck.addCard(c);
		}
		return exists;
	}
	
	private int findCard(String name)
	{
		int index = -1;
		index = deck.findCard(name);
		return index;
	}
	
	public boolean modifyCard(String name, String collection, int health, PokemonType type)
	{
		boolean exists = false;
		int index = findCard(name);
		if(index >= 0)
		{
			exists = true;
			Card c = deck.getCard(index);
			c.setCard(setCard(name,  collection), setPokemon(health, type));
		}
		return exists;
	}
	
	public int delCard(String name)
	{
		int index = findCard(name);
		if(index >= 0)
			deck.delCard(index);
		return index;
	}
	
	public Card displayCard(String name)
	{
		int index = findCard(name);
		Card card;
		if(index >= 0)
			card = deck.getCard(index);
		else
			card = null;
		return card;
	}
	
	public void displayPokedeck()
	{
		ui.displayCard(deck.displayDeck());
	}
	
	public void findCardsByType()
	{
		CardType cardType = ui.cardTypeChoice();
		ui.displayCard(deck.displayByType(cardType));
	}

	public void findCardsByCollection()
	{
		String collection = ui.scanString("collection");
		ui.displayCard(deck.displayByCollection(collection));
	}
	
	
	public void saveDeck()
	{
		try {
			FileOutputStream fos = new FileOutputStream("deck.serial");

			ObjectOutputStream oos= new ObjectOutputStream(fos);
			try {
				oos.writeObject(deck); 
				oos.flush();
			} finally {
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

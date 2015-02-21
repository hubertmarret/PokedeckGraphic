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
	
	private CardDescriptor setCard()
	{
		CardDescriptor cardDesc = new CardDescriptor();
		cardDesc.name = ui.scanString("name");
		cardDesc.collection = ui.scanString("collection");
		return cardDesc;
	}
	
	public void addCard(String name, String collection, int health, PokemonType type)
	{
		CardDescriptor cardDesc = new CardDescriptor();
		cardDesc.name = name;
		cardDesc.cardType = CardType.POKEMONCARD;
		cardDesc.collection = collection;
		
		Card c = new Pokemon(cardDesc, setPokemon(health, type));
		
		deck.addCard(c);
	}
	
	private int findCard(String name)
	{
		int index = -1;
		index = deck.findCard(name);
		return index;
	}
	
	public void modifyCard(String name)
	{
		int index = findCard(name);
		Card c = deck.getCard(index);
		
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
	
	
	private void saveDeck()
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

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

public class Game {
	
	private UserInterface ui;
	private Deck deck;
	
	public Game()
	{
		ui = new UserInterface();
		createDeck();
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
	
	private PokemonDescriptor setPokemon()
	{
		PokemonDescriptor pokeDesc = new PokemonDescriptor();
		pokeDesc.health = ui.scanInt("health");
		pokeDesc.pokemonType = ui.pokemonTypeChoice();
		pokeDesc.description = ui.scanString("description");
		return pokeDesc;
	}
	
	private TrainerDescriptor setTrainer()
	{
		TrainerDescriptor trDesc = new TrainerDescriptor();
		trDesc.role = ui.scanString("role");
		trDesc.description = ui.scanString("description");
		return trDesc;
	}
	
	private CardDescriptor setCard()
	{
		CardDescriptor cardDesc = new CardDescriptor();
		cardDesc.name = ui.scanString("name");
		cardDesc.collection = ui.scanString("collection");
		return cardDesc;
	}
	
	private Card createCard()
	{
		CardDescriptor cardDesc = new CardDescriptor();
		cardDesc.name = ui.scanString("name");
		cardDesc.cardType = ui.cardTypeChoice();
		cardDesc.collection = ui.scanString("collection");
		
		Card c;
		switch(cardDesc.cardType)
		{
			case POKEMONCARD:
				c = new Pokemon(cardDesc, setPokemon());
				break;
			case TRAINERCARD:
				c = new Trainer(cardDesc, setTrainer());
				break;
			case ENERGYCARD:
				c = new Energy(cardDesc, ui.pokemonTypeChoice());
				break;
			default: c = new Card(cardDesc);
		}
		return c;
	}
	
	private void addCard()
	{
		deck.addCard(createCard());
	}
	
	private int findCard()
	{
		int index = -1;
		do
		{
			String name = ui.scanString("name");
			index = deck.findCard(name);
			if(index < 0)
				ui.wrongAnswer();
		}
		while(index < 0);
		return index;
	}
	
	private void modifyCard()
	{
		int index = findCard();
		Card c = deck.getCard(index);
		switch(c.cardType)
		{
			case POKEMONCARD:
				c.setCard(setCard(), setPokemon());
				break;
			case TRAINERCARD:
				c.setCard(setCard(), setTrainer());
				break;
			case ENERGYCARD:
				c.setCard(setCard(), ui.pokemonTypeChoice());
				break;
			default: 
		}
	}
	
	private void delCard()
	{
		int index = findCard();
		deck.delCard(index);
		ui.delCard();
	}
	
	private void displayCard()
	{
		int index = findCard();
		ui.displayCard(deck.displayCard(index));
	}
	
	private void displayPokedeck()
	{
		ui.displayCard(deck.displayDeck());
	}
	
	private void findCardsByType()
	{
		CardType cardType = ui.cardTypeChoice();
		ui.displayCard(deck.displayByType(cardType));
	}

	private void findCardsByCollection()
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
	
	public void infinteLoop()
	{
		boolean quit = false;
		ui.hello();
		do
		{	
			UserChoice userChoice = ui.userChoiceMenu();
			switch(userChoice)
			{
				case ADDCARD: addCard(); break;
				case MODIFYCARD: modifyCard(); break;
				case DELCARD: delCard(); break;
				case DISPLAYCARD: displayCard(); break;
				case DISPLAYPOKEDECK: displayPokedeck(); break;
				case FINDCARDSBYTYPE: findCardsByType(); break;
				case FINDCARDSBYCOLLECTION: findCardsByCollection(); break;
				case QUIT: quit = true; saveDeck(); break;
				default: quit = true; saveDeck();
			}
		}
		while(!quit);
		ui.quit();
	}
}

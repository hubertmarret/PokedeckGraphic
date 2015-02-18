package ui;

import java.util.Scanner;

import cardHandler.CardType;
import cardHandler.PokemonType;


public class UserInterface {
	
	public static Scanner scan;
	
	public UserInterface()
	{
		scan = new Scanner(System.in);
	}
	
	
	public void hello()
	{
		System.out.println("Welcome on our Pokemon card handler !!\n\n");
	}
	
	public void wrongAnswer()
	{
		System.out.println("wrong answer, try again !");
	}
	
	public void delCard()
	{
		System.out.println("The card has been deleted");
	}
	
	public void displayCard(String cardInfo)
	{
		System.out.println(cardInfo);
	}
	
	public void quit()
	{
		scan.close();
		System.out.println("Thank you for playing !!");
	}
	
	
	public String scanString(String s)
	{
		System.out.println("Enter the "+s+" of the card");
		String str = scan.nextLine();
		return str;
	}
	
	public int scanInt(String s)
	{
		System.out.println("Enter the "+s+" of the card");
		int i = scan.nextInt();
		scan.nextLine();
		return i;
	}
	
	public CardType cardTypeChoice()
	{		
		int cardType;
		boolean goodAnswer=false;
		do
		{
			System.out.println("Enter the type of the card");
			System.out.println("_ pokemon (type '0')");
			System.out.println("_ trainer (type '1')");
			System.out.println("_ energy (type '2')");
			cardType = scan.nextInt();
			scan.nextLine();
			if(cardType >= 0 && cardType < CardType.values().length)
			{
				goodAnswer = true;
			}
			else
			{
				System.out.println("wrong answer, try again");
			}
		}
		while(!goodAnswer);
				
		return CardType.values()[cardType];
	}
	
	public PokemonType pokemonTypeChoice()
	{
		int pokemonType;
		boolean goodAnswer=false;
		do
		{
			System.out.println("Enter the type of the pokemon\n");
			System.out.println("normal('0'), fire('1'), water('2'), grass('3'), lightning('4'), psychic('5')");
			System.out.println("fighting('6'), darkness('7'), metal('8'), fairy('9'), dragon('10')");
			pokemonType = scan.nextInt();
			scan.nextLine();
			if(pokemonType >= 0 && pokemonType < PokemonType.values().length)
			{
				goodAnswer = true;
			}
			else
			{
				System.out.println("wrong answer, try again");
			}
		}
		while(!goodAnswer);
				
		return PokemonType.values()[pokemonType];
	}
	
	public UserChoice userChoiceMenu()
	{
		int userChoice;
		boolean goodAnswer=false;
		do
		{
			System.out.println("\nWhat do you want to do ?");
			System.out.println("_ add a card (type '1')");
			System.out.println("_ modify a card (type '2')");
			System.out.println("_ delete a card (type '3')");
			System.out.println("_ display a card (type '4')");
			System.out.println("_ display the pokedeck (type '5')");
			System.out.println("_ display the cards of a chosen type (type '6')");
			System.out.println("_ display the cards of a chosen collection (type '7')");
			System.out.println("_ quit this program (type '0')");
			userChoice = scan.nextInt();
			scan.nextLine();
			if(userChoice >= 0 && userChoice < UserChoice.values().length)
			{
				goodAnswer = true;
			}
			else
			{
				System.out.println("wrong answer, try again");
			}
		}
		while(!goodAnswer);
		
		return UserChoice.values()[userChoice];
	}
	
	/*public void modifyCard()
	{
		String name;
		boolean goodAnswer=false;
		do
		{
			System.out.println("Enter the name of the card you want to modify");
			name = scan.nextLine();
			if(deck.modifyCard(name))
			{
				goodAnswer = true;
				System.out.println("The card "+name+" has been modified");
			}
			else
			{
				System.out.println("No card have this name, try another one");
			}
		}
		while(!goodAnswer);
	}*/
	
	
}

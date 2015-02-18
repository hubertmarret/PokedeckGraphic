package cardHandler;

import descriptor.CardDescriptor;
import descriptor.PokemonDescriptor;

public class Pokemon extends Card {
	private static final long serialVersionUID = 2L;
	
	private int health;
	private PokemonType pokemonType;
	private String description;
	
	public Pokemon()
	{
		super();
		health = 0;
		pokemonType = PokemonType.NORMAL;
		description = "default";
	}
	public Pokemon(int health, PokemonType pokemonType, String description)
	{
		super();
		this.health = health;
		this.pokemonType = pokemonType;
		this.description = description;
	}
	public Pokemon(CardDescriptor cardDesc, PokemonDescriptor pokeDesc)
	{
		super(cardDesc);
		health = pokeDesc.health;
		pokemonType = pokeDesc.pokemonType;
		description = pokeDesc.description;
	}
	
	public void setCard(String name, CardType cardType, String collection, int health, PokemonType pokemonType, String description)
	{
		super.setCard(name, cardType, collection);
		this.health = health;
		this.pokemonType = pokemonType;
		this.description = description;
	}
	public void setCard(CardDescriptor cardDesc, PokemonDescriptor pokeDesc)
	{
		super.setCard(cardDesc);
		health = pokeDesc.health;
		pokemonType = pokeDesc.pokemonType;
		description = pokeDesc.description;
	}

	public void display()
	{
		super.display();
		System.out.println("Health : "+health+" hp");
		System.out.println("Type : "+pokemonType);
		System.out.println("Description : "+description+"\n");
	}
	
	public String toString()
	{
		return super.toString()+"Health : "+health+" hp\nType : "+pokemonType+"\nDescription : "+description+"\n";
	}
}

package cardHandler;

import descriptor.CardDescriptor;

public class Energy extends Card {
	private static final long serialVersionUID = 4L;
	
	public PokemonType pokemonType;
	
	public Energy()
	{
		super();
		pokemonType = PokemonType.NORMAL;
	}
	
	public Energy(PokemonType pokemonType)
	{
		this.pokemonType = pokemonType;
	}
	public Energy(CardDescriptor cardDesc, PokemonType pokemonType)
	{
		super(cardDesc);
		this.pokemonType = pokemonType;
	}
	
	public void setCard(String name, CardType cardType, String collection, PokemonType pokemonType)
	{
		super.setCard(name, cardType, collection);
		this.pokemonType = pokemonType;
	}
	public void serCard(CardDescriptor cardDesc, PokemonType pokemonType)
	{
		super.setCard(cardDesc);
		this.pokemonType = pokemonType;
	}
	
	public void display()
	{
		super.display();
		System.out.println("Type : "+pokemonType);
	}
	
	public String toString()
	{
		return super.toString()+"Type : "+pokemonType+"\n";
	}
}

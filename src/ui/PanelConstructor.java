package ui;

import java.awt.*;
import javax.swing.*;

import cardHandler.PokemonType;

public class PanelConstructor {
	private JPanel pan;
	private Color col;
	private Color colTransparent;
	private Color colText;
	private Font textFont;
	
	public PanelConstructor()
	{
		col = new Color(49, 78, 183);
		colTransparent = new Color(46, 75, 180, 5);
		colText = new Color(255, 207, 0);
		textFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	}
	
	public JPanel createMenu(CardLayout cl, JPanel content)
	{
		pan = new JPanel();
		pan.setBackground(col);
		
		JLabel title = new JLabel("Pokedeck");
		Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		title.setFont(titleFont);
		title.setForeground(colText);
		
		Button addBtn = new Button("Add a card", "addPage");
		addBtn.setToChangePage(cl, content);
		
		Button modifyBtn = new Button("Modify a card");
		
		Button delBtn = new Button("Delete a card");
		
		Button displayCardBtn = new Button("Display a card");
		
		Button displayDeckBtn = new Button("Display the deck");
		
		
		JPanel header = new JPanel();
		header.setBackground(colTransparent);
		header.add(title);
		
		JPanel section = new JPanel();
		section.setBackground(colTransparent);
		
		JPanel actionBtns = new JPanel();
		actionBtns.setBackground(colTransparent);
		actionBtns.setLayout(new BoxLayout(actionBtns, BoxLayout.LINE_AXIS));
		actionBtns.add(addBtn);
		actionBtns.add(modifyBtn);
		actionBtns.add(delBtn);
		
		JPanel displayBtns = new JPanel();
		displayBtns.setBackground(colTransparent);
		displayBtns.setLayout(new BoxLayout(displayBtns, BoxLayout.LINE_AXIS));
		displayBtns.add(displayCardBtn);
		displayBtns.add(displayDeckBtn);
		
		section.setLayout(new BoxLayout(section, BoxLayout.PAGE_AXIS));
		section.add(actionBtns);
		section.add(displayBtns);
		
		pan.setLayout(new GridLayout(2, 1));
		pan.setPreferredSize(new Dimension(900, 450));
		pan.add(header);
		pan.add(section);
		
		return pan;
	}
	
	public JPanel createAddPage(CardLayout cl, JPanel content)
	{
		pan = new JPanel();
		pan.setBackground(col);
		
		/* Initialize elements */
		JLabel title = new JLabel("Add a card");
		Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
		title.setFont(titleFont);
		title.setForeground(colText);
		
		JTextField cardName = new JTextField("unknown");
		cardName.setPreferredSize(new Dimension(200,30));
		JLabel cardNameLabel = new JLabel("Name  ");
		cardNameLabel.setFont(textFont);
		cardNameLabel.setForeground(colText);
		
		JTextField collection = new JTextField("unknown");
		collection.setPreferredSize(new Dimension(200,30));
		JLabel collectionLabel = new JLabel("Collection  ");
		collectionLabel.setFont(textFont);
		collectionLabel.setForeground(colText);
		
		JTextField health = new JTextField("unknown");
		health.setPreferredSize(new Dimension(200,30));
		JLabel healthLabel = new JLabel("Health  ");
		healthLabel.setFont(textFont);
		healthLabel.setForeground(colText);
		
		JComboBox<PokemonType> typeList = new JComboBox<PokemonType>(PokemonType.values());
		typeList.setPreferredSize(new Dimension(200,30));
		JLabel typeListLabel = new JLabel("PokemonType  ");
		typeListLabel.setFont(textFont);
		typeListLabel.setForeground(colText);
		
		JTextField description = new JTextField("unknown");
		description.setPreferredSize(new Dimension(200,30));
		JLabel descriptionLabel = new JLabel("Description  ");
		descriptionLabel.setFont(textFont);
		descriptionLabel.setForeground(colText);
		
		Button validate = new Button("Validate", "addPage");
		
		Button homeBtn = new Button("Home", "menu");
	    homeBtn.setToChangePage(cl, content);
	    
	    
	    /* Initialize the panels */
	    pan.setPreferredSize(new Dimension(900, 450));
	    pan.setLayout(null);
		
		
		/* Set elements position */
		Insets insets = pan.getInsets();
		Dimension size = title.getPreferredSize();
		title.setBounds(350 + insets.left, 5 + insets.top, size.width, size.height);
		size = cardNameLabel.getPreferredSize();
		cardNameLabel.setBounds(25 + insets.left, 80 + insets.top, size.width, size.height);
		size = cardName.getPreferredSize();
		cardName.setBounds(200 + insets.left, 80 + insets.top, size.width, size.height);
		size = collectionLabel.getPreferredSize();
		collectionLabel.setBounds(25 + insets.left, 120 + insets.top, size.width, size.height);
		size = collection.getPreferredSize();
		collection.setBounds(200 + insets.left, 120 + insets.top, size.width, size.height);
		size = healthLabel.getPreferredSize();
		healthLabel.setBounds(25 + insets.left, 160 + insets.top, size.width, size.height);
		size = health.getPreferredSize();
		health.setBounds(200 + insets.left, 160 + insets.top, size.width, size.height);
		size = typeListLabel.getPreferredSize();
		typeListLabel.setBounds(25 + insets.left, 200 + insets.top, size.width, size.height);
		size = typeList.getPreferredSize();
		typeList.setBounds(200 + insets.left, 200 + insets.top, size.width, size.height);
		size = descriptionLabel.getPreferredSize();
		descriptionLabel.setBounds(25 + insets.left, 240 + insets.top, size.width, size.height);
		size = description.getPreferredSize();
		description.setBounds(200 + insets.left, 240 + insets.top, size.width, size.height);
		size = validate.getPreferredSize();
		validate.setBounds(350 + insets.left, 280 + insets.top, size.width, size.height);
		size = homeBtn.getPreferredSize();
		homeBtn.setBounds(350 + insets.left, 320 + insets.top, size.width, size.height);

		
		/* Add elements to the panels */
		pan.add(title);
		pan.add(cardNameLabel);
		pan.add(cardName);
		pan.add(collectionLabel);
		pan.add(collection);
		pan.add(healthLabel);
		pan.add(health);
		pan.add(typeListLabel);
		pan.add(typeList);
		pan.add(descriptionLabel);
		pan.add(description);
		pan.add(validate);
		pan.add(homeBtn);
		

		return pan;
	}
	
	
}

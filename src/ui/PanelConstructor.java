package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cardHandler.Card;
import cardHandler.Game;
import cardHandler.Pokemon;
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
		
		Button addBtn = new Button("Add a card", "addCardPage");
		addBtn.setToChangePage(cl, content);
		
		Button modifyBtn = new Button("Modify a card", "modifyCardPage");
		modifyBtn.setToChangePage(cl, content);
		
		Button delBtn = new Button("Delete a card", "deleteCardPage");
		delBtn.setToChangePage(cl, content);
		
		Button displayCardBtn = new Button("Display a card", "displayCardPage");
		displayCardBtn.setToChangePage(cl, content);
		
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
		
		JTextField cardName = new JTextField("");
		cardName.setPreferredSize(new Dimension(200,30));
		JLabel cardNameLabel = label("Name  ");
		
		JTextField collection = new JTextField("");
		collection.setPreferredSize(new Dimension(200,30));
		JLabel collectionLabel = label("Collection  ");
		
		JTextField health = new JTextField("");
		health.setPreferredSize(new Dimension(200,30));
		JLabel healthLabel = label("Health  ");
		
		JComboBox<PokemonType> typeList = new JComboBox<PokemonType>(PokemonType.values());
		typeList.setPreferredSize(new Dimension(200,30));
		JLabel typeListLabel = label("PokemonType  ");
		
		JLabel btnMsg = new JLabel("undefined");
		btnMsg.setVisible(false);
		
		Button addBtn = new Button("Add card");
		addBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String sCardName = cardName.getText();
				int iHealth = Integer.parseInt(health.getText());
				if(iHealth > 9 && iHealth < 151)
				{
					boolean exists = Game.getInstance().addCard(sCardName, collection.getText(), iHealth, PokemonType.values()[typeList.getSelectedIndex()]);
					if(!exists)
					{
						Game.getInstance().saveDeck();
						btnMsg.setText("the card " + sCardName + " has been added");
					}
					else
						btnMsg.setText("the card " + sCardName + " already exists");
				}
				else
				{
					btnMsg.setText("the health must be an number between 10 and 150 included");
				}
				btnMsg.setVisible(true);
			}
		});
		
		Button homeBtn = new Button("Home", "menu");
	    homeBtn.setToChangePage(cl, content);
	    homeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				cardName.setText("");
				collection.setText("");
				health.setText("");
				typeList.setSelectedIndex(0);
				btnMsg.setVisible(false);
			}
		});
	    
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
		size = btnMsg.getPreferredSize();
		btnMsg.setBounds(100 + insets.left, 230 + insets.top, 600, size.height);
		size = addBtn.getPreferredSize();
		addBtn.setBounds(350 + insets.left, 260 + insets.top, size.width, size.height);
		size = homeBtn.getPreferredSize();
		homeBtn.setBounds(350 + insets.left, 300 + insets.top, size.width, size.height);
		
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
		pan.add(btnMsg);
		pan.add(addBtn);
		pan.add(homeBtn);
		
		return pan;
	}
	
	public JPanel createModifyPage(CardLayout cl, JPanel content)
	{
		/* Initialize elements */
		JLabel title = new JLabel("Modify a card");
		Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
		title.setFont(titleFont);
		title.setForeground(colText);
		
		JTextField cardName = new JTextField("");
		cardName.setPreferredSize(new Dimension(200,30));
		JLabel cardNameLabel = label("Name  ");
		
		JTextField collection = new JTextField("");
		collection.setPreferredSize(new Dimension(200,30));
		JLabel collectionLabel = label("Collection  ");
		
		JTextField health = new JTextField("");
		health.setPreferredSize(new Dimension(200,30));
		JLabel healthLabel = label("Health  ");
		
		JComboBox<PokemonType> typeList = new JComboBox<PokemonType>(PokemonType.values());
		typeList.setPreferredSize(new Dimension(200,30));
		JLabel typeListLabel = label("PokemonType  ");
		
		JTextField cardNameField = new JTextField("");
		cardNameField.setPreferredSize(new Dimension(200,30));
		JLabel cardNameFieldLabel = label("Name");
		
		JLabel btnMsg = new JLabel("undefined");
		btnMsg.setVisible(false);
		
		Button validate = new Button("Validate");
		validate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String sCardName = cardNameField.getText();
				
				Card card = new Pokemon();
				card = Game.getInstance().displayCard(sCardName);
				
				if(card != null)
				{
					cardName.setText(card.name);
					collection.setText(card.collection);
					health.setText("" + card.getCard().health);
					typeList.setSelectedIndex(card.getCard().pokemonType.ordinal());
					
					cardName.setVisible(true);
					collection.setVisible(true);
					health.setVisible(true);
					typeList.setVisible(true);
					btnMsg.setText("see you card info above");
				}
				else
				{
					cardName.setVisible(false);
					collection.setVisible(false);
					health.setVisible(false);
					typeList.setVisible(false);
					btnMsg.setText("the card " + sCardName + " doesn't exits");
				}
				btnMsg.setVisible(true);
			}
		});
		
		Button modifyBtn = new Button("Add card");
		modifyBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String sCardName = cardName.getText();
				int iHealth = Integer.parseInt(health.getText());
				if(iHealth > 9 && iHealth < 151)
				{
					boolean exists = Game.getInstance().modifyCard(sCardName, collection.getText(), iHealth, PokemonType.values()[typeList.getSelectedIndex()]);
					if(exists)
					{
						Game.getInstance().saveDeck();
						btnMsg.setText("the card " + sCardName + " has been modified");
					}
					else
						btnMsg.setText("the card " + sCardName + " doesn't exist");
				}
				else
				{
					btnMsg.setText("the health must be an number between 10 and 150 included");
				}
				btnMsg.setVisible(true);
			}
		});
		
		Button homeBtn = new Button("Home", "menu");
	    homeBtn.setToChangePage(cl, content);
	    homeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				cardName.setText("unknown");
				collection.setText("unknown");
				health.setText("unknown");
				typeList.setSelectedIndex(0);
				
				cardName.setVisible(false);
				collection.setVisible(false);
				health.setVisible(false);
				typeList.setVisible(false);
			}
		});
		
	    /* Initialize the panels */
	    pan = new JPanel();
		pan.setBackground(col);
	    pan.setPreferredSize(new Dimension(900, 450));
	    pan.setLayout(null);
	    
	    /* Set elements position */
		Insets insets = pan.getInsets();
		Dimension size = title.getPreferredSize();
		title.setBounds(330 + insets.left, 5 + insets.top, size.width, size.height);
		size = cardNameLabel.getPreferredSize();
		cardNameLabel.setBounds(25 + insets.left, 80 + insets.top, size.width, size.height);
		size = cardName.getPreferredSize();
		cardName.setBounds(220 + insets.left, 80 + insets.top, size.width, size.height);
		size = collectionLabel.getPreferredSize();
		collectionLabel.setBounds(25 + insets.left, 120 + insets.top, size.width, size.height);
		size = collection.getPreferredSize();
		collection.setBounds(220 + insets.left, 120 + insets.top, size.width, size.height);
		size = healthLabel.getPreferredSize();
		healthLabel.setBounds(25 + insets.left, 160 + insets.top, size.width, size.height);
		size = health.getPreferredSize();
		health.setBounds(220 + insets.left, 160 + insets.top, size.width, size.height);
		size = typeListLabel.getPreferredSize();
		typeListLabel.setBounds(25 + insets.left, 200 + insets.top, size.width, size.height);
		size = typeList.getPreferredSize();
		typeList.setBounds(220 + insets.left, 200 + insets.top, size.width, size.height);
		size = cardNameFieldLabel.getPreferredSize();
		cardNameFieldLabel.setBounds(500 + insets.left, 80 + insets.top, size.width, size.height);
		size = cardNameField.getPreferredSize();
		cardNameField.setBounds(620 + insets.left, 80 + insets.top, size.width, size.height);
		size = btnMsg.getPreferredSize();
		btnMsg.setBounds(100 + insets.left, 240 + insets.top, 600, size.height);
		size = validate.getPreferredSize();
		validate.setBounds(620 + insets.left, 120 + insets.top, size.width, size.height);
		size = modifyBtn.getPreferredSize();
		modifyBtn.setBounds(350 + insets.left, 280 + insets.top, size.width, size.height);
		size = homeBtn.getPreferredSize();
		homeBtn.setBounds(350 + insets.left, 320 + insets.top, size.width, size.height);
	    
		pan.add(title);
		pan.add(cardNameLabel);
		pan.add(cardName);
		pan.add(collectionLabel);
		pan.add(collection);
		pan.add(healthLabel);
		pan.add(health);
		pan.add(typeListLabel);
		pan.add(typeList);
		pan.add(cardNameFieldLabel);
		pan.add(cardNameField);
		pan.add(btnMsg);
		pan.add(validate);
		pan.add(modifyBtn);
		pan.add(homeBtn);
		
		return pan;
	}
	
	public JPanel createDeletePage(CardLayout cl, JPanel content)
	{
		/* Initialize elements */
		JLabel title = new JLabel("Delete a card");
		Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
		title.setFont(titleFont);
		title.setForeground(colText);
		
		JTextField cardNameField = new JTextField("");
		cardNameField.setPreferredSize(new Dimension(200,30));
		JLabel cardNameFieldLabel = label("Name");
		
		JLabel btnMsg = new JLabel("undefined");
		btnMsg.setVisible(false);
		
		Button validate = new Button("Validate");
		validate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String cardName = cardNameField.getText();
				int index = Game.getInstance().delCard(cardName);
				if(index >= 0)
				{
					btnMsg.setText("the card " + cardName + " has been deleted");
					Game.getInstance().saveDeck();
				}
				else
					btnMsg.setText("the card " + cardName + " doesn't exits");
				btnMsg.setVisible(true);
			}
		});
		
		Button homeBtn = new Button("Home", "menu");
	    homeBtn.setToChangePage(cl, content);
		
		
		/* Initialize the panels */
	    pan = new JPanel();
		pan.setBackground(col);
	    pan.setPreferredSize(new Dimension(900, 450));
	    pan.setLayout(null);
		
	    /* Set elements position */
		Insets insets = pan.getInsets();
		Dimension size = title.getPreferredSize();
		title.setBounds(330 + insets.left, 5 + insets.top, size.width, size.height);
		size = cardNameFieldLabel.getPreferredSize();
		cardNameFieldLabel.setBounds(100 + insets.left, 80 + insets.top, size.width, size.height);
		size = cardNameField.getPreferredSize();
		cardNameField.setBounds(220 + insets.left, 80 + insets.top, size.width, size.height);
		size = btnMsg.getPreferredSize();
		btnMsg.setBounds(100 + insets.left, 200 + insets.top, 600, size.height);
		size = validate.getPreferredSize();
		validate.setBounds(150 + insets.left, 120 + insets.top, size.width, size.height);
		size = homeBtn.getPreferredSize();
		homeBtn.setBounds(350 + insets.left, 280 + insets.top, size.width, size.height);
	    
		pan.add(title);
		pan.add(cardNameFieldLabel);
		pan.add(cardNameField);
		pan.add(btnMsg);
		pan.add(validate);
		pan.add(homeBtn);
		
		return pan;
	}
	
	public JPanel createDisplayPage(CardLayout cl, JPanel content)
	{
		/* Initialize elements */
		JLabel title = new JLabel("Display a card");
		Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
		title.setFont(titleFont);
		title.setForeground(colText);
		
		JLabel cardNameLabel = label("Name :");
		JLabel cardName = label("unknown");
		cardName.setVisible(false);
		
		JLabel collectionLabel = label("Collection :");
		JLabel collection = label("unknown");
		collection.setVisible(false);
		
		JLabel healthLabel = label("Health :");
		JLabel health = label("unknown");
		health.setVisible(false);
		
		JLabel typeLabel = label("PokemonType :");
		JLabel type = label("unknown");
		type.setVisible(false);
		
		JTextField cardNameField = new JTextField("");
		cardNameField.setPreferredSize(new Dimension(200,30));
		JLabel cardNameFieldLabel = label("Name");
		
		JLabel btnMsg = new JLabel("undefined");
		btnMsg.setVisible(false);
		
		Button validate = new Button("Validate");
		validate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String sCardName = cardNameField.getText();
				
				Card card = new Pokemon();
				card = Game.getInstance().displayCard(sCardName);
				
				if(card != null)
				{
					cardName.setText(card.name);
					collection.setText(card.collection);
					health.setText("" + card.getCard().health + " HP");
					type.setText(card.getCard().pokemonType.toString());
					
					cardName.setVisible(true);
					collection.setVisible(true);
					health.setVisible(true);
					type.setVisible(true);
					btnMsg.setText("see you card info above");
				}
				else
				{
					cardName.setVisible(false);
					collection.setVisible(false);
					health.setVisible(false);
					type.setVisible(false);
					btnMsg.setText("the card " + sCardName + " doesn't exits");
				}
				btnMsg.setVisible(true);
			}
		});
		
		Button homeBtn = new Button("Home", "menu");
	    homeBtn.setToChangePage(cl, content);
	    homeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				cardName.setText("unknown");
				collection.setText("unknown");
				health.setText("unknown");
				type.setText("unknown");
				
				cardName.setVisible(false);
				collection.setVisible(false);
				health.setVisible(false);
				type.setVisible(false);
				btnMsg.setVisible(false);
			}
		});
		
	    /* Initialize the panels */
	    pan = new JPanel();
		pan.setBackground(col);
	    pan.setPreferredSize(new Dimension(900, 450));
	    pan.setLayout(null);
	    
	    /* Set elements position */
		Insets insets = pan.getInsets();
		Dimension size = title.getPreferredSize();
		title.setBounds(330 + insets.left, 5 + insets.top, size.width, size.height);
		size = cardNameLabel.getPreferredSize();
		cardNameLabel.setBounds(25 + insets.left, 80 + insets.top, size.width, size.height);
		size = cardName.getPreferredSize();
		cardName.setBounds(220 + insets.left, 80 + insets.top, size.width, size.height);
		size = collectionLabel.getPreferredSize();
		collectionLabel.setBounds(25 + insets.left, 120 + insets.top, size.width, size.height);
		size = collection.getPreferredSize();
		collection.setBounds(220 + insets.left, 120 + insets.top, size.width, size.height);
		size = healthLabel.getPreferredSize();
		healthLabel.setBounds(25 + insets.left, 160 + insets.top, size.width, size.height);
		size = health.getPreferredSize();
		health.setBounds(220 + insets.left, 160 + insets.top, size.width, size.height);
		size = typeLabel.getPreferredSize();
		typeLabel.setBounds(25 + insets.left, 200 + insets.top, size.width, size.height);
		size = type.getPreferredSize();
		type.setBounds(220 + insets.left, 200 + insets.top, size.width, size.height);
		size = cardNameFieldLabel.getPreferredSize();
		cardNameFieldLabel.setBounds(500 + insets.left, 80 + insets.top, size.width, size.height);
		size = cardNameField.getPreferredSize();
		cardNameField.setBounds(620 + insets.left, 80 + insets.top, size.width, size.height);
		size = btnMsg.getPreferredSize();
		btnMsg.setBounds(100 + insets.left, 240 + insets.top, 600, size.height);
		size = validate.getPreferredSize();
		validate.setBounds(620 + insets.left, 120 + insets.top, size.width, size.height);
		size = homeBtn.getPreferredSize();
		homeBtn.setBounds(350 + insets.left, 280 + insets.top, size.width, size.height);
	    
		pan.add(title);
		pan.add(cardNameLabel);
		pan.add(cardName);
		pan.add(collectionLabel);
		pan.add(collection);
		pan.add(healthLabel);
		pan.add(health);
		pan.add(typeLabel);
		pan.add(type);
		pan.add(cardNameFieldLabel);
		pan.add(cardNameField);
		pan.add(btnMsg);
		pan.add(validate);
		pan.add(homeBtn);
		
		return pan;
	}
	
	private JLabel label(String text)
	{
		JLabel l = new JLabel(text);
		l.setFont(textFont);
		l.setForeground(colText);
		l.setPreferredSize(new Dimension(175,30));
		return l;
	}
}

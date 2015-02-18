package ui;

import java.awt.*;
import javax.swing.*;

import cardHandler.CardType;

public class PanelConstructor {
	private JPanel pan;
	private Color col;
	private Color colTransparent;
	private Color colText;
	Font textFont;
	
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
		addBtn.setMargin(new Insets(20,20,20,20));
		addBtn.setToChangePage(cl, content);
		
		Button modifyBtn = new Button("Modify a card");
		modifyBtn.setMargin(new Insets(20,20,20,20));
		
		Button delBtn = new Button("Delete a card");
		delBtn.setMargin(new Insets(20,20,20,20));
		
		Button displayCardBtn = new Button("Display a card");
		displayCardBtn.setMargin(new Insets(20,20,20,20));
		
		Button displayDeckBtn = new Button("Display the deck");
		displayDeckBtn.setMargin(new Insets(20,20,20,20));
		
		Button typeFinder = new Button("Find cards by cardType");
		typeFinder.setMargin(new Insets(20,20,20,20));
		
		Button collectionFinder = new Button("Find cards by collection");
		collectionFinder.setMargin(new Insets(20,20,20,20));
		
		
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
		
		JPanel findBtns = new JPanel();
		findBtns.setBackground(colTransparent);
		findBtns.setLayout(new BoxLayout(findBtns, BoxLayout.LINE_AXIS));
		findBtns.add(typeFinder);
		findBtns.add(collectionFinder);
		
		section.setLayout(new BoxLayout(section, BoxLayout.PAGE_AXIS));
		section.add(actionBtns);
		section.add(displayBtns);
		section.add(findBtns);
		
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
		
		JLabel title = new JLabel("Add a card");
		Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 35);
		title.setFont(titleFont);
		title.setForeground(colText);
		
		JTextField cardName = new JTextField("unknown");
		cardName.setPreferredSize(new Dimension(100,30));
		JLabel cardNameLabel = new JLabel("Name  ");
		cardNameLabel.setFont(textFont);
		cardNameLabel.setForeground(colText);
		
		JComboBox<CardType> typeList = new JComboBox<CardType>(CardType.values());
		typeList.setPreferredSize(new Dimension(100,30));
		JLabel typeListLabel = new JLabel("CardType  ");
		typeListLabel.setFont(textFont);
		typeListLabel.setForeground(colText);
		
		JTextField collection = new JTextField("unknown");
		collection.setPreferredSize(new Dimension(100,30));
		JLabel collectionLabel = new JLabel("Collection  ");
		collectionLabel.setFont(textFont);
		collectionLabel.setForeground(colText);
		
		Button validate = new Button("Validate", "addPage");
		
		Button homeBtn = new Button("Home", "menu");
	    homeBtn.setToChangePage(cl, content);
	    
	    
	    JPanel header = new JPanel();
		header.setBackground(colTransparent);
		header.add(title);
	    
	    JPanel section = new JPanel();
		section.setBackground(colTransparent);
		section.setPreferredSize(new Dimension(300, 300));
	    
		JPanel cardNamePanel = new JPanel();
		cardNamePanel.setBackground(colTransparent);
		cardNamePanel.setLayout(new BoxLayout(cardNamePanel, BoxLayout.LINE_AXIS));
		cardNamePanel.add(cardNameLabel);
		cardNamePanel.add(cardName);
		
		JPanel typeListPanel = new JPanel();
		typeListPanel.setBackground(colTransparent);
		typeListPanel.setLayout(new BoxLayout(typeListPanel, BoxLayout.LINE_AXIS));
		typeListPanel.add(typeListLabel);
		typeListPanel.add(typeList);
		
		JPanel collectionPanel = new JPanel();
		collectionPanel.setBackground(colTransparent);
		collectionPanel.setLayout(new BoxLayout(collectionPanel, BoxLayout.LINE_AXIS));
		collectionPanel.add(collectionLabel);
		collectionPanel.add(collection);
		
		JPanel validatePanel = new JPanel();
		validatePanel.setBackground(colTransparent);
		validatePanel.setLayout(new BoxLayout(validatePanel, BoxLayout.LINE_AXIS));
		validatePanel.add(validate);
		
		JPanel homePanel = new JPanel();
		homePanel.setBackground(colTransparent);
		homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.LINE_AXIS));
		homePanel.add(homeBtn);
		
		section.setLayout(new BoxLayout(section, BoxLayout.PAGE_AXIS));
		section.add(cardNamePanel);
		section.add(typeListPanel);
		section.add(collectionPanel);
		section.add(validatePanel);
		
		JPanel footer = new JPanel();
		footer.setBackground(colTransparent);
		footer.add(homePanel);
		
		pan.setLayout(new GridLayout(3, 1));
		pan.setPreferredSize(new Dimension(900, 450));
		pan.add(header);
		pan.add(section);
		pan.add(footer);
		
		return pan;
	}
	
	
}

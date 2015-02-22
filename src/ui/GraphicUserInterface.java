package ui;

import java.awt.*;

import javax.swing.*;

public class GraphicUserInterface extends JFrame {

	private static final long serialVersionUID = 25L;
		
	private CardLayout cardLayout = new CardLayout();
	private JPanel content = new JPanel();
	
	private PanelConstructor panConstructor = new PanelConstructor();
	private JPanel menu;
	private JPanel addCardPage;
	private JPanel displayCardPage;
	private JPanel deleteCardPage;
	private JPanel modifyCardPage;
	private JPanel displayDeckPage;
	
	public GraphicUserInterface()
	{		
		this.setTitle("Pokedeck");
	    this.setSize(900, 450);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	}
	
	public void start()
	{		
		menu = panConstructor.createMenu(cardLayout, content);
	    addCardPage = panConstructor.createAddPage(cardLayout, content);
	    displayCardPage = panConstructor.createDisplayPage(cardLayout, content);
	    deleteCardPage = panConstructor.createDeletePage(cardLayout, content);
	    modifyCardPage = panConstructor.createModifyPage(cardLayout, content);
	    displayDeckPage = panConstructor.createDisplayDeckPage(cardLayout, content);
	    
	    content.setBackground(new Color(49, 78, 183));
	    content.setPreferredSize(new Dimension(800, 430));
	    content.setLayout(cardLayout);
	    content.add(menu, "menu");
	    content.add(addCardPage, "addCardPage");
	    content.add(displayCardPage, "displayCardPage");
	    content.add(deleteCardPage, "deleteCardPage");
	    content.add(modifyCardPage, "modifyCardPage");
	    content.add(displayDeckPage, "displayDeckPage");
	    
	    this.setContentPane(content);
	    this.setVisible(true);
	}
	
	
}

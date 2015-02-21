package ui;

import java.awt.*;

import javax.swing.*;

public class GraphicUserInterface extends JFrame {

	private static final long serialVersionUID = 25L;
		
	private CardLayout cardLayout = new CardLayout();
	private JPanel content = new JPanel();
	
	private PanelConstructor panConstructor = new PanelConstructor();
	private JPanel menu;
	private JPanel addPage;
	private JPanel displayCardPage;
	private JPanel deleteCardPage;
		
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
	    addPage = panConstructor.createAddPage(cardLayout, content);
	    displayCardPage = panConstructor.createDisplayPage(cardLayout, content);
	    deleteCardPage = panConstructor.createDeletePage(cardLayout, content);
	    
	    content.setBackground(new Color(49, 78, 183));
	    content.setPreferredSize(new Dimension(800, 430));
	    content.setLayout(cardLayout);
	    content.add(menu, "menu");
	    content.add(addPage, "addPage");
	    content.add(displayCardPage, "displayCardPage");
	    content.add(deleteCardPage, "deleteCardPage");
	    
	    this.setContentPane(content);
	    this.setVisible(true);
	}
	
	
}

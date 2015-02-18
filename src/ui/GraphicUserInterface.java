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
	
	
	public GraphicUserInterface()
	{
		this.setTitle("Pokedeck");
	    this.setSize(900, 450);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    menu = panConstructor.createMenu(cardLayout, content);
	    addPage = panConstructor.createAddPage(cardLayout, content);
	    
	    content.setBackground(new Color(49, 78, 183));
	    content.setPreferredSize(new Dimension(800, 430));
	    content.setLayout(cardLayout);
	    content.add(menu, "menu");
	    content.add(addPage, "addPage");
	    
	    this.setContentPane(content);
	    this.setVisible(true);
	}
	
	
}

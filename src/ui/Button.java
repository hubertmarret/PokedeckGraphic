package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Button extends JButton{

	private static final long serialVersionUID = 27L;
	
	public String pageToOpen;
	
	public Button(String text)
	{
		super(text);
	}
	
	public Button(String text, String page)
	{
		super(text);
		pageToOpen = page;
	}
	
	public void setToChangePage(CardLayout cl, JPanel content)
	{
		this.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event){
	    		cl.show(content, pageToOpen);
	    	}
	    });
	}
	
}

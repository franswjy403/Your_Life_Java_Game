package project.fin;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JTextPane{
	JTextPane potion;

	public QuestionPanel() {
		// TODO Auto-generated constructor stub
		this.setEditable(false);
		potion = new JTextPane();
		
		potion.setEditable(false);
		potion.setContentType("text/html");
		potion.setText("<html><h3 style=\"color:white;\">· Name : "+ "frams" +"<br>"
				+"· Price : "+"james"+ "</h3> </html>");
		potion.setPreferredSize(new Dimension(313,20));
	}
}

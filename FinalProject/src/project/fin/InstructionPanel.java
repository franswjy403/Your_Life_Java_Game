package project.fin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class InstructionPanel extends JPanel {

  private Image img;
  Image rectangle;
  Font Buttons;
  JTextArea A;
  String test = "This is the game of choice, you need to select from the 2 option. Each option has a consqequence as it will"
  		+ " drop or rise the life bar on the left. If either one of the bar is too much or too few, you will lose the game. So, Choose wisely.";
  
  JTextArea B;
  String testb = "INSTRUCTION";
  
  public InstructionPanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public InstructionPanel(Image img) {
	  try {
			Buttons = Font.createFont(Font.TRUETYPE_FONT, new File("text/OSD Mono.ttf")).deriveFont(25f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/OSD Mono.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
	rectangle = new ImageIcon("instructionPanel/Rect Fix.png").getImage();
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
    
    A = new JTextArea(test, 20, 40);
    A.setEditable(false);
    A.setBounds(350, 110, 450, 300 );
    A.setOpaque(false);
    A.setLineWrap(true);
    A.setWrapStyleWord(true);
    A.setCaretPosition(test.length());
    A.setFont(Buttons.deriveFont(24f));
    A.setForeground(Color.BLACK);
    this.add(A); 
    
    B = new JTextArea(testb, 1, 1);
    B.setEditable(false);
    B.setBounds(413, 50, 400, 300);
    B.setOpaque(false);
    B.setLineWrap(true);
    B.setWrapStyleWord(true);
    B.setCaretPosition(testb.length());
    B.setFont(Buttons.deriveFont(53f));
    B.setForeground(Color.WHITE);
    this.add(B); 
    
    
    JButton Panel = new JGradientButtonSimple("Start", new Color (229, 134, 116),new Color(208, 147, 144));
	Panel.setFocusable(false);
	Panel.setFocusPainted(false);
	Panel.setForeground(Color.BLACK);
	Panel.setFont(Buttons);
	Panel.setBounds(496, 400, 200, 31);
	Panel.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Main.frame.setContentPane(new GamePlayPanel("background/night_city.jpg", PanelPool.MainMenu.getCurrentRole()));
		}
		
	});
	this.add(Panel);
  }

  public void paintComponent(Graphics g) {
	  g.drawImage(img, 0, 0, null);
	  g.drawImage(rectangle, 340, 50, null);
  }

}
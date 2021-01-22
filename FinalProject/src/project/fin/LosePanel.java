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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LosePanel extends JPanel implements ActionListener{
	private Font title;
	private Font Buttons;
	private Font Button1;
	private Image img;
	public musicPlay loseMusic;
	private Image blast, grave, chara;
	private int yBlast, yGrave, yChar;
	public LosePanel(String img) {
		loseMusic = new musicPlay();
		this.img = new ImageIcon(img).getImage();
		Dimension size = new Dimension(1200, 500);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setSize(size);
		this.setLayout(null);
		try {
			title = Font.createFont(Font.TRUETYPE_FONT, new File("text/Button.ttf")).deriveFont(80f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/Button.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		try {
			Buttons = Font.createFont(Font.TRUETYPE_FONT, new File("text/Button.ttf")).deriveFont(25f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/Button.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		this.blast = new ImageIcon("losePanel/explosion200.png").getImage();
		this.grave = new ImageIcon("losePanel/grave150.png").getImage();
		this.yBlast = 700;
		this.yGrave = 700;
		this.yChar = 390;
		
		Button1 = Buttons.deriveFont(Font.BOLD);
		
		//Button1
		JButton button = new JButton();
		button.setText("RETRY");
		button.setFont(Button1);
		button.setFocusable(true);
		button.setBounds(350, 250, 180, 31);
		button.setBackground(new Color(255, 238, 88));
		button.setForeground(Color.BLACK);
		button.addActionListener(this);
		this.add(button);
		
		//Button2
		JButton button2 = new JButton();
		button2.setText("QUIT");
		button2.setFont(Button1);
		button2.setFocusable(true);
		button2.setBounds(670, 250, 180, 31);
		button2.setBackground(new Color(255, 238, 88));
		button2.setForeground(Color.BLACK);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loseMusic.stopMusic();
				Main.frame.setVisible(false);
				Main.frame.dispose();
			}
			
		});
		this.add(button2);
		
		this.setSize(1200, 500);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(this, "Action Event telah diaktifkan!");
		loseMusic.stopMusic();
		Main.frame.setContentPane(PanelPool.MainMenu);
	}
	
	public int count=0;
	public void animateDeath(Image img) {
		this.chara = img;
		Thread animate = new Thread() {
			public void run() {
				while(count<3) {
					if (count==1) {
						yChar = 700;
						yBlast = 350;
					}
					else if (count==2) {
						yBlast = 700;
						yGrave = 350;
					}
					count++;
					repaint();
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		animate.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.img, 0, 0, null);
		g.drawImage(this.blast, 500, this.yBlast, null);
		g.drawImage(this.chara, 600, this.yChar, null);
		g.drawImage(this.grave, 500, this.yGrave, null);
	}
}

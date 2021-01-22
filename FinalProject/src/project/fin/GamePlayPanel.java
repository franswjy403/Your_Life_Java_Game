    package project.fin;
    
    import java.awt.*;
    import java.io.*;
import java.util.List;
import java.util.*;
    import java.awt.event.*;
    import javax.swing.*;
import javax.swing.Timer;
  
    
    public class GamePlayPanel extends JPanel{
    	private Image img;
    	
    	private int countQuestion;
    	
    	private boolean started;
    	
    	private Font Buttons;
    	private Font Minecraftory;
    	
    	private Image att1, att2, att3;
    	private Image current;
    	
    	private Character myCharacter;
    	
    	private Image box;
    	
    	private JProgressBar bar1;
    	private JProgressBar bar2;
    	private JProgressBar bar3;
    	
    	private JTextArea Q, A, B;
    	
    	private List <objectSpawned> obj;
    	private int countobjectSpawned, ind;
    	
    	private QuestionPackage a;
    	
    	private JButton frameLeft, frameRight;
    	
    	private JLabel status;
    	private JTextArea labelAtt1, labelAtt2, labelAtt3;
    	
    	public musicPlay playMusic, baloonSound, blinkSound;
    	public GamePlayPanel(String img, String role) {
    		this.isOver=false;
    		this.started=false;
    		countobjectSpawned=0;
    		obj = new ArrayList<objectSpawned>();
    		
    		playMusic = new musicPlay();
    		baloonSound = new musicPlay();
    		blinkSound = new musicPlay();
    		
    		this.img = new ImageIcon(img).getImage();
    		Dimension size = new Dimension(1200, 500);
    		this.setPreferredSize(size);
    		this.setMaximumSize(size);
    		this.setMinimumSize(size);
    		this.setSize(size);
    		this.setLayout(null);
    		
    		try {
    			Minecraftory = Font.createFont(Font.TRUETYPE_FONT, new File("text/Early Gameboy.ttf")).deriveFont(50f);
    			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/Early Gameboy.ttf")));
    		}
    		catch(IOException | FontFormatException e) {
    			
    		}
    		
    		try {
    			Buttons = Font.createFont(Font.TRUETYPE_FONT, new File("text/OSD Mono.ttf")).deriveFont(20f);
    			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("text/OSD Mono.ttf")));
    		}
    		catch(IOException | FontFormatException e) {
    			
    		}
    		
    		box = new ImageIcon("gamePlayItem/statusBox_200.png").getImage();
    		
    		
    		if (role.equals("Human")) myCharacter = new Baby(100, 420, 10, 135, 55, 20);
    		else if (role.equals("God")) myCharacter = new God(100, 390, 10, 135, 55, 20);
    		else if (role.equals("Dog")) myCharacter = new Dog(100, 420, 10, 135, 55, 20);
    		else if (role.equals("Devil")) myCharacter = new Devil(100, 390, 10, 135, 55, 20);;
    		setAttribute();
    		
    		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0), "moveRight");
    		getActionMap().put("moveRight", new Move_it(1));
    		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0), "moveLeft");
    		getActionMap().put("moveLeft", new Move_it(2));
    		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0), "moveUp");
    		getActionMap().put("moveUp", new Move_it(3));
    		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0), "spawnObject");
    		getActionMap().put("spawnObject", new spawnObject());
    		
    		status = new JLabel();
    		status.setText("STATUS:"+myCharacter.getStatus());
    		status.setHorizontalAlignment(JLabel.CENTER);
    		status.setFont(Minecraftory.deriveFont(15f));
    		status.setBounds(38, 130, 400, 190);
    		status.setForeground(Color.ORANGE);
    		this.add(status);
    		
    		String test ="";
    		labelAtt1 = new JTextArea();
    		labelAtt1.setText(myCharacter.getAtt1()+" : "+myCharacter.getBarsLength(0));
    		labelAtt1.setEditable(false);
    		labelAtt1.setOpaque(false);
    		labelAtt1.setLineWrap(true);
    		labelAtt1.setWrapStyleWord(true);
    		labelAtt1.setCaretPosition(test.length());
    		labelAtt1.setFont(Buttons.deriveFont(18f));
    		labelAtt1.setForeground(Color.WHITE);
    		labelAtt1.setBounds(130, 30, 500, 30);
    		this.add(labelAtt1);
    		
    		labelAtt2 = new JTextArea();
    		labelAtt2.setText(myCharacter.getAtt2()+" : "+myCharacter.getBarsLength(1));
    		labelAtt2.setEditable(false);
    		labelAtt2.setOpaque(false);
    		labelAtt2.setLineWrap(true);
    		labelAtt2.setWrapStyleWord(true);
    		labelAtt2.setCaretPosition(test.length());
    		labelAtt2.setFont(Buttons.deriveFont(18f));
    		labelAtt2.setForeground(Color.WHITE);
    		labelAtt2.setBounds(130, 90, 500, 30);
    		this.add(labelAtt2);
    		
    		labelAtt3 = new JTextArea();
    		labelAtt3.setText(myCharacter.getAtt3()+" : "+myCharacter.getBarsLength(2));
    		labelAtt3.setEditable(false);
    		labelAtt3.setOpaque(false);
    		labelAtt3.setLineWrap(true);
    		labelAtt3.setWrapStyleWord(true);
    		labelAtt3.setCaretPosition(test.length());
    		labelAtt3.setFont(Buttons.deriveFont(18f));
    		labelAtt3.setForeground(Color.WHITE);
    		labelAtt3.setBounds(130, 150, 500, 30);
    		this.add(labelAtt3);
    		
    		Q = new JTextArea(test, 20, 40);
    		Q.setEditable(false);
    		Q.setBounds(620, 55, 420, 85);
    		Q.setOpaque(false);
    		Q.setLineWrap(true);
    		Q.setWrapStyleWord(true);
    		Q.setCaretPosition(test.length());
    		Q.setFont(Buttons.deriveFont(18f));
    		Q.setForeground(Color.BLACK);
    		this.add(Q);
    		
    		JButton buttonQuestion = new JGradientButtonSimple("", new Color (229, 134, 116),new Color(132, 56, 58));
    		buttonQuestion.setForeground(Color.BLACK);
    		buttonQuestion.setBounds(600, 40, 450, 100);
    		buttonQuestion.setFont(Buttons.deriveFont(30f));
    		buttonQuestion.setText("QUESTION");
    		this.add(buttonQuestion);

    		A = new JTextArea(test, 20, 40);
    		A.setEditable(false);
    		A.setBounds(620, 175, 165, 85);
    		A.setOpaque(false);
    		A.setLineWrap(true);
    		A.setWrapStyleWord(true);
    		A.setCaretPosition(test.length());
    		A.setFont(Buttons.deriveFont(16f));
    		A.setForeground(Color.BLACK);
    		this.add(A);
    		
    		JButton buttonLeft = new JGradientButtonSimple("", new Color (229, 134, 116),new Color(132, 56, 58));
    		buttonLeft.setForeground(Color.BLACK);
    		buttonLeft.setBounds(600, 160, 200, 100);
    		buttonLeft.setFont(Buttons.deriveFont(30f));
    		buttonLeft.setText("ANSWER A");
    		this.add(buttonLeft);
    		
    		frameLeft = new JGradientButtonSimple("", new Color (255, 0, 0),new Color(255, 77, 77));
    		frameLeft.setBounds(590, 150, 220, 120);
    		frameLeft.setVisible(false);
    		this.add(frameLeft);
    		
    		B = new JTextArea(test, 20, 40);
    		B.setEditable(false);
    		B.setBounds(870, 175, 165, 85);
    		B.setOpaque(false);
    		B.setLineWrap(true);
    		B.setWrapStyleWord(true);
    		B.setCaretPosition(test.length());
    		B.setFont(Buttons.deriveFont(16f));
    		B.setForeground(Color.BLACK);
    		this.add(B);
    		
    		JButton buttonRight = new JGradientButtonSimple("", new Color (229, 134, 116),new Color(132, 56, 58));
    		buttonRight.setForeground(Color.BLACK);
    		buttonRight.setBounds(850, 160, 200, 100);
    		buttonRight.setFont(Buttons.deriveFont(30f));
    		buttonRight.setText("ANSWER B");
    		this.add(buttonRight);
    		
    		frameRight = new JGradientButtonSimple("", new Color (255, 0, 0),new Color(255, 0, 0));
    		frameRight.setBounds(840, 150, 220, 120);
    		frameRight.setVisible(false);
    		this.add(frameRight);
    		
    		JButton PlayButt = new JGradientButtonSimple("START?", new Color (255, 153, 0), new Color(255, 255, 0));
    		PlayButt.setForeground(Color.BLACK);
    		PlayButt.setFont(Buttons);
    		PlayButt.setBounds(550, 300, 150, 31);
    		PlayButt.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					playMusic.playMusic("music/Play.wav");
		    		playMusic.musicLoop();
					countQuestion = 0;
					PlayButt.setVisible(false);
					buttonQuestion.setText("");
					buttonLeft.setText("");
					buttonRight.setText("");
					generateQuestion();
					started = true;
				}
    			
    		});
    		this.add(PlayButt);
   
    	}
    	
    	public void setAttribute(){
    		att1 = myCharacter.iconPool.get(myCharacter.getCurrentStateAtt());
    		att2 = myCharacter.iconPool.get(myCharacter.getCurrentStateAtt()+1);
    		att3 = myCharacter.iconPool.get(myCharacter.getCurrentStateAtt()+2);
    		if (myCharacter.getState()>1) {
    			this.status.setText("STATUS: "+myCharacter.getStatus());
    			
    		}
    		
    	}
    	
    	public void blinkFrame(int code) {
    		if (code==1) {
    			frameLeft.setVisible(true);
    			try {
    				Thread.sleep(100);
    			} catch (InterruptedException ex) {}
    			frameLeft.setVisible(false);
    		}
    		else {
    			frameRight.setVisible(true);
    			try {
    				Thread.sleep(100);
    			} catch (InterruptedException ex) {}
    			frameRight.setVisible(false);
    		}
    	}
    	
    	public void flyObject() {
    		Thread fly = new Thread() {
    			public void run() {
    				while (obj.size()>0 && !isOver) {
    					for (int i =0; i<obj.size();i++) {
    						obj.get(i).fly();
    						if (obj.get(i).getX()>560 && obj.get(i).getX()<800 && obj.get(i).getY()<=250 ) {
    							blinkSound.playMusic("music/Ding.wav");
    							obj.remove(i);
    							i--;
    							blinkFrame(1);
    							if (started) {
	    							if (!check(1)) {
		    							myCharacter.updateBars(a.getA());
		    							generateQuestion();
	    							}
	    							else {
	    								gameOver(2);
	    							}
    							}
    						}
    						else if (obj.get(i).getX()>810 && obj.get(i).getX()<1050 && obj.get(i).getY()<=250 ) {
    							blinkSound.playMusic("music/Ding.wav");
    							obj.remove(i);
    							i--;
    							blinkFrame(2);
    							if (started) {
    								if (!check(2)) {
		    							myCharacter.updateBars(a.getB());
		    							generateQuestion();
	    							}
    								else {
    									gameOver(2);
    								}
    							}
    						}
    						else if (obj.get(i).isOutside()) {
    							obj.remove(i);
    							i--;
    						}
    					}
    					repaint();
    					try {
    					Thread.sleep(50);
    					} catch (InterruptedException ex) {}
    				}
    			}
    		};
    		fly.start();
    	}
    	
    	public boolean isOver;
    	public void gameOver(int ind) {
    		
    		if(started) playMusic.stopMusic();
    		
    		if (ind==1 && !isOver) {
    			isOver=true;
    			PanelPool.OverPage.overMusic.playMusic("music/RickRoll.wav");
    			PanelPool.RolePage.unlock();
    			Main.frame.setContentPane(PanelPool.OverPage);
    		}
    		else if (ind==2 && !isOver){
    			isOver=true;
    			PanelPool.LosePage = new LosePanel("background/gameover new.png");
    			PanelPool.LosePage.loseMusic.playMusic("music/Titanic.wav");
    			PanelPool.LosePage.animateDeath(myCharacter.current);
    			Main.frame.setContentPane(PanelPool.LosePage);;
    		}
    	}
    	
    	public boolean check(int ind) {
    		if (ind==1) {
    			if (myCharacter.getBarsLength(0)+a.getA().getPointA().getPoint()>160 || myCharacter.getBarsLength(0)+a.getA().getPointA().getPoint()<40)return true;
        		else if (myCharacter.getBarsLength(1)+a.getA().getPointB().getPoint()>160 || myCharacter.getBarsLength(1)+a.getA().getPointB().getPoint()<40)return true;
        		else if (myCharacter.getBarsLength(2)+a.getA().getPointC().getPoint()>160 || myCharacter.getBarsLength(2)+a.getA().getPointC().getPoint()<40)return true;
    		}
    		else {
    			if (myCharacter.getBarsLength(0)+a.getB().getPointA().getPoint()>160 || myCharacter.getBarsLength(0)+a.getB().getPointA().getPoint()<40)return true;
        		else if (myCharacter.getBarsLength(1)+a.getB().getPointB().getPoint()>160 || myCharacter.getBarsLength(1)+a.getB().getPointB().getPoint()<40)return true;
        		else if (myCharacter.getBarsLength(2)+a.getB().getPointC().getPoint()>160 || myCharacter.getBarsLength(2)+a.getB().getPointC().getPoint()<40)return true;
    		}
    		
			return false;
    	}
    	
    	@Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		
    		g.drawImage(this.img, 0, 0, null);
    		
    		g.drawImage(this.att1, 350, 50, null);
    		g.drawImage(this.att2, 350, 110, null);
    		g.drawImage(this.att3, 350, 170, null);
    		g.drawImage(this.box, 130, 50, null);
    		g.drawImage(this.box, 130, 110, null);
    		g.drawImage(this.box, 130, 170, null);
    		myCharacter.draw(g);
    		if (obj.size()>0) {
    			for (objectSpawned a : obj) {
    				a.draw(g);
    			}
    		}
    	}
    	
    	private class Move_it extends AbstractAction{
    		int code;
    		public Move_it(int code) {
    			this.code=code;
    		}
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			if (this.code==1) {
    				myCharacter.MoveRight();
    				myCharacter.setDirection(1);
    			}
    			else if (this.code==2) {
    				myCharacter.MoveLeft();
    				myCharacter.setDirection(2);
    			}
    			repaint();
    		}
    	}
    	
    	private class spawnObject extends AbstractAction{
    		public spawnObject() {
				// TODO Auto-generated constructor stub
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				baloonSound.playMusic("music/Plop.wav");
				if (obj.size()==0) {
					obj.add(new objectSpawned((int)myCharacter.x, (int)myCharacter.y, 5, myCharacter.getObj()));
					flyObject();
				}
				else obj.add(new objectSpawned((int)myCharacter.x, (int)myCharacter.y, 5, myCharacter.getObj()));
			}
    		
    	}
    	
    	public void generateQuestion() {
    		int max = 9, min=0;
    		countQuestion++;
    		if (this.countQuestion==10) {
    			if (myCharacter.getState()==3) {
    				gameOver(1);
    			}
    			else {
    				myCharacter.LevelUp();
    				setAttribute();
    			}
    			this.countQuestion=0;
    			repaint();
    		}
    		ind = (int) (Math.random()*(max-min+1)+min);
    		while (myCharacter.check(ind)) {
    			ind = (int) (Math.random()*(max-min+1)+min);
    		}
    		
    		a = null;
    		switch(myCharacter.getState()-1) {
    		case 0:
    			a = myCharacter.pack.QuestionPool1.get(ind);
    			break;
    		case 1:
    			a = myCharacter.pack.QuestionPool2.get(ind);
    			break;
    		case 2:
    			a = myCharacter.pack.QuestionPool3.get(ind);
    			break;
    		}
    		Q.setText(a.getQuestion()); Q.setCaretPosition(a.getQuestion().length());
    		A.setText(a.getA().getAnswer()); A.setCaretPosition(a.getA().getAnswer().length());
    		B.setText(a.getB().getAnswer()); B.setCaretPosition(a.getB().getAnswer().length());
    		a.setAlready(true);
    		
			labelAtt1.setText(myCharacter.getAtt1()+" : "+myCharacter.getBarsLength(0));
			labelAtt2.setText(myCharacter.getAtt2()+" : "+myCharacter.getBarsLength(1));
			labelAtt3.setText(myCharacter.getAtt3()+" : "+myCharacter.getBarsLength(2));
    	}
    }
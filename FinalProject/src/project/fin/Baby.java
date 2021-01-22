package project.fin;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import project.fin.QuestionPackage.answer;

import java.awt.event.*;
public class Baby extends Character{
	
	public Baby(float x, float y, int speed, int barX, int barY, int height) {
		// TODO Auto-generated constructor stub
		super (x, y, speed, barX, barY, height);
		this.pack = new HumanPackage();
		
		this.status=new String("TODDLER");
		this.att1=new String("HEALTH");
		this.att2=new String("INTELLIGENCE");
		this.att3=new String("MOOD");
		
		this.obj = new ImageIcon("humanImage/baloon_40.png").getImage();
		
		ImgPool = new ArrayList<Image>();
		
		//These are just some images that i use to build my moving baby
		ImgPool.add(new ImageIcon("humanImage/baby1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/baby2_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/baby1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/baby3_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/babyLeft1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/babyLeft2_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/babyLeft1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/babyLeft3_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/teenRight2_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/teenRight1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/teenRight3_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/teenRight2_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/teenLeft1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/teenLeft2_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/teenLeft3_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/teenLeft1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/adultRight1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/adultRight2_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/adultRight3_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/adultRight1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/adultLeft1_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/adultLeft2_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/adultLeft3_50.png").getImage());
		ImgPool.add(new ImageIcon("humanImage/adultLeft1_50.png").getImage());
		
		iconPool = new ArrayList<Image>();
		iconPool.add(new ImageIcon("humanImage/Heart_30.png").getImage());
		iconPool.add(new ImageIcon("humanImage/idea_30.png").getImage());
		iconPool.add(new ImageIcon("humanImage/smiley_30.png").getImage());
		iconPool.add(new ImageIcon("humanImage/Heart_30.png").getImage());
		iconPool.add(new ImageIcon("humanImage/social_30.png").getImage());
		iconPool.add(new ImageIcon("humanImage/idea_30.png").getImage());
		iconPool.add(new ImageIcon("humanImage/houseWood_30.png").getImage());
		iconPool.add(new ImageIcon("humanImage/Coin_30.png").getImage());
		iconPool.add(new ImageIcon("humanImage/Heart_30.png").getImage());
		
		this.current = ImgPool.get(0);
		this.Current = 0;
		this.begin = 0;
		this.end = 4;
		this.direction = 1;
		
		
	}
	
	@Override
	public void LevelUp() {
		System.out.println("Leveled Up");
		this.setState(this.getState() + 1);
		this.setCurrentStateAtt(this.getCurrentStateAtt() + 3);
		if (this.state==2) {
			this.status=new String ("TEENAGER");
			this.att2=new String("SOCIAL");
			this.att3=new String("INTELLIGENCE");
		}
		else if (this.state==3) {
			this.status=new String ("ADULT");
			this.att1=new String ("FAMILY");
			this.att2=new String ("MONEY");
			this.att3=new String ("HEALTH");
		}
		this.startImage+=8;
		this.endImage+=8;
		this.begin=this.startImage;
		this.end=this.endImage;
		this.Current=this.startImage;
		this.current=this.ImgPool.get(Current);
		for (ProgressBar p : bars) {
			p.reset();
		}
	}
	
	@Override
	public boolean check(int index) {
		if (this.state==1) {
			return this.pack.QuestionPool1.get(index).getAlready();
		}
		else if (this.state==2) {
			return this.pack.QuestionPool2.get(index).getAlready();
		}
		else {
			return this.pack.QuestionPool3.get(index).getAlready();
		}
	}
}

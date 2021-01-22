package project.fin;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Devil extends Character{

	public Devil(float x, float y, int speed, int barX, int barY, int height) {
		super(x, y, speed, barX, barY, height);
		// TODO Auto-generated constructor stub
		this.pack = new devilPackage();
		
		this.status=new String("CERBERUS");
		this.att1=new String("MAGIC");
		this.att2=new String("HEAT");
		this.att3=new String("POWER");
		
		this.obj = new ImageIcon("devilImage/fireBall50.png").getImage();
		
		ImgPool = new ArrayList<Image>();
		
		//These are just some images that i use to build my moving baby

		ImgPool.add(new ImageIcon("devilImage/cerberusRight.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/cerberusRight.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/cerberusRight.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/cerberusRight.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/cerberusFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/cerberusFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/cerberusFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/cerberusFix.png").getImage());

		ImgPool.add(new ImageIcon("devilImage/gargoyleRight.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/gargoyleRight.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/gargoyleRight.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/gargoyleRight.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/gargoyleFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/gargoyleFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/gargoyleFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/gargoyleFix.png").getImage());
		
		ImgPool.add(new ImageIcon("devilImage/devilFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/devilFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/devilFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/devilFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/devilFix.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/devilLeft.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/devilLeft.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/devilLeft.png").getImage());
		ImgPool.add(new ImageIcon("devilImage/devilLeft.png").getImage());
		
		iconPool = new ArrayList<Image>();
		iconPool.add(new ImageIcon("devilImage/magic30.png").getImage());
		iconPool.add(new ImageIcon("devilImage/heat30.png").getImage());
		iconPool.add(new ImageIcon("devilImage/power30.png").getImage());
		iconPool.add(new ImageIcon("devilImage/magic30.png").getImage());
		iconPool.add(new ImageIcon("devilImage/greed30.png").getImage());
		iconPool.add(new ImageIcon("devilImage/power30.png").getImage());
		iconPool.add(new ImageIcon("devilImage/anger30.png").getImage());
		iconPool.add(new ImageIcon("devilImage/fireMagic30.png").getImage());
		iconPool.add(new ImageIcon("devilImage/power30.png").getImage());
		
		this.current = ImgPool.get(0);
		this.Current = 0;
		this.begin = 0;
		this.end = 4;
		this.direction = 1;
	}

	@Override
	public void LevelUp() {
		// TODO Auto-generated method stub
		System.out.println("Leveled Up");
		this.setState(this.getState() + 1);
		this.setCurrentStateAtt(this.getCurrentStateAtt() + 3);
		if (this.state==2) {
			this.status=new String ("GAROGYLE");
			this.att2=new String("GREED");
		}
		else if (this.state==3) {
			this.status=new String ("DEVIL KING");
			this.att1=new String ("ANGER");
			this.att2=new String ("FIRE MAGIC");
			this.att3=new String ("POWER");
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
		// TODO Auto-generated method stub
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

package project.fin;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class God extends Character{

	public God(float x, float y, int speed, int barX, int barY, int height) {
		super(x, y, speed, barX, barY, height);
		// TODO Auto-generated constructor stub
		this.pack = new godPackage();
		
		this.status=new String("HADES");
		this.att1=new String("STRENGTH");
		this.att2=new String("MIGHT");
		this.att3=new String("FOLLOWER");
		
		this.obj = new ImageIcon("godImage/smallSword.png").getImage();
		
		ImgPool = new ArrayList<Image>();
		
		//These are just some images that i use to build my moving baby
		ImgPool.add(new ImageIcon("godImage/hades90.png").getImage());
		ImgPool.add(new ImageIcon("godImage/hades90.png").getImage());
		ImgPool.add(new ImageIcon("godImage/hades90.png").getImage());
		ImgPool.add(new ImageIcon("godImage/hades90.png").getImage());
		ImgPool.add(new ImageIcon("godImage/hades90.png").getImage());
		ImgPool.add(new ImageIcon("godImage/hades90.png").getImage());
		ImgPool.add(new ImageIcon("godImage/hades90.png").getImage());
		ImgPool.add(new ImageIcon("godImage/hades90.png").getImage());
		
		ImgPool.add(new ImageIcon("godImage/kratosFixs.png").getImage());
		ImgPool.add(new ImageIcon("godImage/kratosFixs.png").getImage());
		ImgPool.add(new ImageIcon("godImage/kratosFixs.png").getImage());
		ImgPool.add(new ImageIcon("godImage/kratosFixs.png").getImage());
		ImgPool.add(new ImageIcon("godImage/kratosLeft.png").getImage());
		ImgPool.add(new ImageIcon("godImage/kratosLeft.png").getImage());
		ImgPool.add(new ImageIcon("godImage/kratosLeft.png").getImage());
		ImgPool.add(new ImageIcon("godImage/kratosLeft.png").getImage());
		
		ImgPool.add(new ImageIcon("godImage/zeus.png").getImage());
		ImgPool.add(new ImageIcon("godImage/zeus.png").getImage());
		ImgPool.add(new ImageIcon("godImage/zeus.png").getImage());
		ImgPool.add(new ImageIcon("godImage/zeus.png").getImage());
		ImgPool.add(new ImageIcon("godImage/zeusLeft.png").getImage());
		ImgPool.add(new ImageIcon("godImage/zeusLeft.png").getImage());
		ImgPool.add(new ImageIcon("godImage/zeusLeft.png").getImage());
		ImgPool.add(new ImageIcon("godImage/zeusLeft.png").getImage());
		
		iconPool = new ArrayList<Image>();
		iconPool.add(new ImageIcon("godImage/strength30.png").getImage());
		iconPool.add(new ImageIcon("godImage/might30.png").getImage());
		iconPool.add(new ImageIcon("godImage/follower30.png").getImage());
		iconPool.add(new ImageIcon("godImage/strength30.png").getImage());
		iconPool.add(new ImageIcon("godImage/speed30.png").getImage());
		iconPool.add(new ImageIcon("godImage/follower30.png").getImage());
		iconPool.add(new ImageIcon("godImage/strength30.png").getImage());
		iconPool.add(new ImageIcon("godImage/wisdom30.png").getImage());
		iconPool.add(new ImageIcon("godImage/worshipper30.png").getImage());
		
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
			this.status=new String ("KRATOS");
			this.att2=new String("SPEED");
		}
		else if (this.state==3) {
			this.status=new String ("ZEUS");
			this.att2=new String ("WISDOM");
			this.att3=new String ("WORSHIPPER");
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

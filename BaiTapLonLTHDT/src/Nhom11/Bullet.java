package Nhom11;

import Nhom11.Common.Status;
import static Nhom11.Board.mang;

public class Bullet extends GameObject{
    public Monster monster;
    private final int SPEED = 4;
    private Status status;
    private boolean live = false;
    
	public Bullet(int x, int y) {
		super(x, y);
		this.x = x;
		this.y = y;
	}
	public Bullet(int x, int y, Monster monster) {
		super(x, y);
		this.monster = monster;
		this.x = x;
		this.y = y;
		this.live = true;
		init();
	}
	public Bullet(int x,int y,Monster monster,int k)
	{
		super(x, y);
		this.monster = monster;
		this.x = x;
		this.y = y;
		this.live = true;
		this.loadimage("Image/bullet_down.png");
    	this.getimageDimention();
    	if(k==1) status=Status.LEFT;
    	else if(k==2) status=Status.DOWN;
    	else if(k==3) status=Status.RIGHT;
    	else if(k==4) status=Status.UP;
    	else if(k==5) status=Status.LEFT_UP;
    	else if(k==6) status=Status.LEFT_DOWN;
    	else if(k==7) status=Status.RIGHT_DOWN;
    	else status=Status.RIGHT_UP;
	}
    public void init ()
    {
    	this.loadimage("Image/bullet_down.png");
    	this.getimageDimention();
    	status = monster.status;
    }
    
    public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void move ()
    {
		if(monster.getSpecies()!=9)
		{
			if(status == Status.LEFT) 
	    	{
	    		x=x-SPEED;
	    		this.loadimage("Image/bullet_left.png");
	    	};
	    	if(status == Status.RIGHT) 
	    	{
	    		x=x+SPEED;
	    		this.loadimage("Image/bullet_right.png");
	    	}
	    	if(status == Status.UP)
	    	{
	    		y=y-SPEED;
	    		this.loadimage("Image/bullet_up.png");
	    	};
	    	if(status == Status.DOWN) 
	    	{
	    		y=y+SPEED;
	    		this.loadimage("Image/bullet_down.png");
	    	};
		} else
		{
			if(status == Status.LEFT) 
	    	{
	    		x=x-SPEED;
	    		this.loadimage("Image/boss_bullet_left.png");
	    	};
	    	if(status == Status.RIGHT) 
	    	{
	    		x=x+SPEED;
	    		this.loadimage("Image/boss_bullet_right.png");
	    	}
	    	if(status == Status.UP)
	    	{
	    		y=y-SPEED;
	    		this.loadimage("Image/boss_bullet_up.png");
	    	};
	    	if(status == Status.DOWN) 
	    	{
	    		y=y+SPEED;
	    		this.loadimage("Image/boss_bullet_down.png");
	    	};
	    	if(status == Status.LEFT_UP) 
	    	{
	    		x=x-SPEED;
	    		y=y-SPEED;
	    		this.loadimage("Image/boss_bullet_left_up.png");
	    	};
	    	if(status == Status.LEFT_DOWN) 
	    	{
	    		x=x-SPEED;
	    		y=y+SPEED;
	    		this.loadimage("Image/boss_bullet_left_down.png");
	    	};
	    	if(status == Status.RIGHT_UP) 
	    	{
	    		x=x+SPEED;
	    		y=y-SPEED;
	    		this.loadimage("Image/boss_bullet_right_up.png");
	    	};
	    	if(status == Status.RIGHT_DOWN) 
	    	{
	    		x=x+SPEED;
	    		y=y+SPEED;
	    		this.loadimage("Image/boss_bullet_right_down.png");
	    	};
		}
    	
    }
    public boolean kiemtradan ()
    {
    	if (x<0 || x + this.width + 20> Common.WIDTH - Common.CELLW|| y<50 + Common.CELLH || y+this.height>Common.HEIGHT) return false;
    	if (mang[y/32-1][x/32]==1 || mang[y/32-1][x/32]>100 
    			|| mang[y/32-1][x/32]==7 ) 
    	return true;
     	return false;
    }
    public int damage (int k)
    {
    	return k;
    }
}

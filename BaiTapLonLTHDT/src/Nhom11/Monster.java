package Nhom11;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Nhom11.Common.Status;

public class Monster extends GameObject {
    protected int x1,y1;
    protected int x2,y2;
    protected int map;
    protected int maxhp,hp;
    protected int atk,def;
    protected int exp;
    protected int gold;
    protected int species=1;
    protected int shot;
    protected Status status;
    protected final int SPEED = 2;
    protected boolean die = false;
    protected boolean fight = false;
	public Monster(int x, int y) {
		super(x, y);
		this.x=x;
		this.y=y;
		initmonster(this.species);
	}

	public Monster(int x1, int y1, int x2, int y2, int status, int map, int species,int shot) {
		super(x1 * 32,(y1) * 32 + 50);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.map = map;
		this.species = species;
		this.shot = shot;
		if (status==0) this.status=Status.LEFT;
		else if (status==1) this.status=Status.RIGHT;
		else if (status==2) this.status=Status.DOWN;
		else if (status==3) this.status=Status.UP;
		initmonster(this.species);
	}

	public int getMaxhp() {
		return maxhp;
	}
	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public boolean isDie() {
		return die;
	}
	public void setDie(boolean die) {
		this.die = die;
	}
	
    public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public int getMap() {
		return map;
	}

	public void setMap(int map) {
		this.map = map;
	}

	public int getSpecies() {
		return species;
	}

	public void setSpecies(int species) {
		this.species = species;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getShot() {
		return shot;
	}

	public void setShot(int shot) {
		this.shot = shot;
	}

	public boolean isFight() {
		return fight;
	}

	public void setFight(boolean fight) {
		this.fight = fight;
	}

	public void initmonster(int k)
    {
		switch (k)
		{
		case 1:
		{
			this.loadimage("Image/monster1_down.gif");
			this.getimageDimention();
			maxhp=hp=30;
			atk=2;
			def=0;
			exp=3;
			gold=10;
			break;
		}
		case 2:
		{
			this.loadimage("Image/monster2_down.gif");
			this.getimageDimention();
			maxhp=hp=40;
			atk=3;
			def=0;
			exp=5;
			gold=15;
			break;
		}
		case 3:
		{
			this.loadimage("Image/monster3_down.gif");
			this.getimageDimention();
			maxhp=hp=60;
			atk=4;
			def=1;
			exp=8;
			gold=20;
			break;
		}
		case 4:
		{
			this.loadimage("Image/monster4_down.gif");
			this.getimageDimention();
			maxhp=hp=80;
			atk=3;
			def=3;
			exp=10;
			gold=30;
			break;
		}
		case 5:
		{
			this.loadimage("Image/monster5_down.gif");
			this.getimageDimention();
			maxhp=hp=100;
			atk=8;
			def=4;
			exp=12;
			gold=35;
			break;
		}
		case 6:
		{
			this.loadimage("Image/monster6_down.gif");
			this.getimageDimention();
			maxhp=hp=120;
			atk=10;
			def=5;
			exp=15;
			gold=40;
			break;
		}
		case 7:
		{
			this.loadimage("Image/monster7_down.gif");
			this.getimageDimention();
			maxhp=hp=130;
			atk=12;
			def=7;
			exp=18;
			gold=50;
			break;
		}
		case 8:
		{
			this.loadimage("Image/monster8_down.gif");
			this.getimageDimention();
			maxhp=hp=150;
			atk=15;
			def=10;
			exp=20;
			gold=60;
			break;
		}
		case 9:
		{
			this.loadimage("Image/boss_down.png");
			this.getimageDimention();
			maxhp=hp=5000;
			atk=100;
			def=50;
			break;
		}
		}		
    }
	public void drawHp (Graphics g)
	{
		if(species!=9)
		{
			g.setColor(Color.green);
			g.fillRect(x, y-19, this.width*this.hp/this.maxhp, 6);
		} else
		{
			g.setColor(Color.red);
			g.fillRect(x, y-19, this.width*this.hp/this.maxhp, 6);
		}
	}
		
	public void move ()
	{
		if(species!=9)
		{
			if (status==Status.LEFT || status==Status.RIGHT)
			{
			    if (x+this.width<=x1*32 || x<=Common.CELLW)	status = Status.RIGHT;
			    if (x+this.width>=x2*32 || x+this.width>=Common.WIDTH-Common.CELLW) status = Status.LEFT;                                                                                                                                ;
			} else
			if (status==Status.UP || status==Status.DOWN)
			{
				if (y+this.height<=y1*32 || y<=Common.CELLH+50) status = Status.DOWN;
				if (y+this.height>=y2*32 || y+this.height>=Common.HEIGHT-Common.CELLH) status = Status.UP;
			}
			
			switch (status) {	
			case UP:
				this.loadimage("Image/monster"+species+"_up.gif");
				y=y-SPEED;
				break;
			case DOWN:
				this.loadimage("Image/monster"+species+"_down.gif");
				y=y+SPEED;
				break;
			case LEFT:
				this.loadimage("Image/monster"+species+"_left.gif");
				x=x-SPEED;
				break;
			case RIGHT:
				this.loadimage("Image/monster"+species+"_right.gif");
				x=x+SPEED;
				break;
			}
		} else
		{
            Random rd = new Random();
            int a = rd.nextInt(618)+32;
            int b = rd.nextInt(658)+32;
			if (x<=Common.CELLW)	status = Status.RIGHT;
	        if (x+this.width>=Common.WIDTH-Common.CELLW) status = Status.LEFT;
	        if (x==a) status = Status.DOWN;
			if (y<=Common.CELLH+50) status = Status.DOWN;
			if (y+this.height-50>=Common.HEIGHT-Common.CELLH) status = Status.UP;
			if (y==b) status = Status.LEFT;
			switch (status) {	
			case UP:
				this.loadimage("Image/boss_up.png");
				y=y-SPEED;
				break;
			case DOWN:
				this.loadimage("Image/boss_down.png");
				y=y+SPEED;
				break;
			case LEFT:
				this.loadimage("Image/boss_left.png");
				x=x-SPEED;
				break;
			case RIGHT:
				this.loadimage("Image/boss_right.png");
				x=x+SPEED;
				break;
			}
		}
	} 
	public void skill ()
	{
		switch (status) {	
		case UP:
			this.loadimage("Image/boss_up_skill.gif");
			y=y-SPEED;
			break;
		case DOWN:
			this.loadimage("Image/boss_down_skill.gif");
			y=y+SPEED;
			break;
		case LEFT:
			this.loadimage("Image/boss_left_skill.gif");
			x=x-SPEED;
			break;
		case RIGHT:
			this.loadimage("Image/boss_right_skill.gif");
			x=x+SPEED;
			break;
		}
	}

}

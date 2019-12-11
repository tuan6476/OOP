package Nhom11;

import static Nhom11.GameManager.loop;
import static Nhom11.GameManager.map;
import static Nhom11.GameManager.shop;
import static Nhom11.Board.mang;
import static Nhom11.GameManager.bullets;
import java.awt.event.KeyEvent;

import Nhom11.Common.Status;

public class Player extends GameObject implements Common{
	private Status status;
	private int maxhp,hp;
	private int maxmn,mn;
	private int atk,def;
	private int binhmau=0;
	private int item=0;
	private int gold=0;
	private int kill=0;
	private boolean fight=false;
	private boolean skill=false;
	private final int SPEED=32;
	private int exp=0,Lv,maxexp;
	public Player(int x, int y) {
		super(x, y);
		this.x=x;
		this.y=y;
		initplayer();
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
	public int getMaxmn() {
		return maxmn;
	}
	public void setMaxmn(int maxmn) {
		this.maxmn = maxmn;
	}
	public int getMn() {
		return mn;
	}
	public void setMn(int mn) {
		this.mn = mn;
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
	public boolean isFight() {
		return fight;
	}
	public void setFight(boolean fight) {
		this.fight = fight;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getLv() {
		return Lv;
	}
	public void setLv(int lv) {
		Lv = lv;
	}
	public int getMaxexp() {
		return maxexp;
	}
	public void setMaxexp(int maxexp) {
		this.maxexp = maxexp;
	}
	
	public boolean isSkill() {
		return skill;
	}
	public void setSkill(boolean skill) {
		this.skill = skill;
	}
	
	public int getBinhmau() {
		return binhmau;
	}
	public void setBinhmau(int binhmau) {
		this.binhmau = binhmau;
	}
	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public int getKill() {
		return kill;
	}
	public void setKill(int kill) {
		this.kill = kill;
	}
	
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public void initplayer()
	{
		maxhp=hp=20;
		maxmn=mn=10;
		atk=3;
		def=1;
		Lv=1;
		this.setMaxexp(exptoLvup(this.Lv));
		this.loadimage("Image/war-down.png");
		this.getimageDimention();
	}
    public int exptoLvup (int k)
    {
    	if (k==1) return 50;
    	else if (k==2) return 75;
    	else if (k==3) return 100;
    	else if (k==4) return 150;
    	else if (k==5) return 200;
    	else if (k==6) return 300;
    	else if (k==7) return 500;
    	else if (k==8) return 750;
    	return 1000;
    	
    }
    public void upLv (int k)
	{
		if (k==1 && this.exp>=50)
		{
			this.Lv=2;
			this.exp=0;
			this.atk++;
			this.maxhp=this.hp=25;
		} else
		if (k==2 && this.exp>=75)
		{
			this.Lv=3;
			this.exp=0;
			this.atk++;
			this.maxhp=this.hp=35;
			
		} else
		if (k==3 && this.exp>=100)
		{
			this.Lv=4;
			this.exp=0;
			this.atk++;
			this.maxhp=this.hp=50;
		} else
		if (k==4 && this.exp>=150)
		{
			this.Lv=5;
			this.exp=0;
			this.atk++;
			this.maxhp=this.hp=60;
		} else
		if (k==5 && this.exp>=200)
		{
			this.Lv=6;
			this.exp=0;
			this.atk++;
			this.maxhp=this.hp=75;
		} else
		if (k==6 && this.exp>=300)
		{
     		this.Lv=7;
			this.exp=0;
 			this.atk++;
			this.maxhp=this.hp=85;
		} else
		if (k==7 && this.exp>=500)
		{
			this.Lv=8;
			this.exp=0;
 			this.atk++;
			this.maxhp=this.hp=100;
		} else
		if (k==8 && this.exp>=750)
		{
			this.Lv=9;
			this.exp=0;
 			this.atk++;
			this.maxhp=this.hp=130;
		} else
		if (k==9 && this.exp>=1000)
		{
			this.Lv=10;
			this.exp=0;
 			this.atk++;
			this.maxhp=this.hp=150;
		} else
		if (k==10 && this.exp>=1000)
		{
			this.exp=1000;
		}
	}
    public boolean misson ()
    {
    	if (map==1)
    	{
    		if (kill>=15) return true;
    		else return false;
    	} else 
    	if (map==2)
    	{
    		if (this.Lv>=3) return true;
    		else return false;
    	} else 
    	if (map==3)
    	{
    		if (kill>=25) return true;
    		else return false;
    	} else 
    	if (map==4)
    	{
    		if(item>=15) return true;
    		else return false;
    	}
    	return false;
    }
    public void move ()
    {
    	this.chuyenmap(this.x, this.y);
    	this.kiemtradivaogai(this.x,this.y);
    }
    public boolean kiemtraduongdi (int x,int y)
    {
//    	if (x<CELLW || y<50 || x+this.width>WIDTH-CELLW|| y+this.height>HEIGHT)
//    	return false;
    	if (mang[(y+64-50)/32-1][x/32]==1 || mang[(y+64-50)/32-1][x/32]>100 
    			|| mang[(y+64-50)/32-1][x/32]==7 || mang[y/32][x/32]==2) 
    	return true;
     	return false;
    }
    public void kiemtradivaogai (int x, int y)
    {
    	if (mang[(y+64-50)/32-1][x/32]==7 && loop%100==0) 
    	{
    		this.hp=this.hp-1;
    	}
    }
    public void muado (int x,int y)
    {
    	if (mang[y/32][x/32]==2)
    	{
    		shop = true;
    	}
    }
    public void chuyenmap (int x,int y)
    {
    	if (mang[y/32][x/32]>100 && misson())
    	{
    		int a = mang[y/32][x/32]/100;
    		int b = mang[y/32][x/32]%100/10;
    		int c = mang[y/32][x/32]%10;
    		map = a;
    		this.x = b*CELLW;
    		this.y = c*CELLW + 50;
    		kill=0;
    		for(int i = 0;i<bullets.size();i++)
    		{
    			bullets.remove(i);
    		}
    	}
    }
    public void keyreleased (KeyEvent e)
	{
		
		int key = e.getKeyCode();
		if (key==KeyEvent.VK_UP  )
		{
            if (kiemtraduongdi(x, y-SPEED)) y=y-SPEED;
//            else dy=0;
			
			this.loadimage("Image/war-up.png");
			status=Status.UP;
		} else
		if (key==KeyEvent.VK_DOWN )
		{
			if (kiemtraduongdi(x, y+SPEED)) y=y+SPEED;
//			else dy=0;
			
			this.loadimage("Image/war-down.png");
			status=Status.DOWN;
		} else
		if ( key==KeyEvent.VK_LEFT )
		{
			if (kiemtraduongdi(x-SPEED, y)) x=x-SPEED;
//			else dx=0;
			this.loadimage("Image/war-left.png");
			status=Status.LEFT;
		} else
		if (key==KeyEvent.VK_RIGHT )
		{
			if (kiemtraduongdi(x+SPEED, y)) x=x+SPEED;
//			else dx=0;
			this.loadimage("Image/war-right.png");
			status=Status.RIGHT;
		} else
		if(key== KeyEvent.VK_J)
		{
			if (status==Status.UP)
			{
				this.loadimage("Image/war-up.png");
			}
			if (status==Status.DOWN)
			{
				this.loadimage("Image/war-down.png");
			} else
			if (status==Status.LEFT)
			{
				this.loadimage("Image/war-left.png");
			} else 
			if (status==Status.RIGHT)
			{
				this.loadimage("Image/war-right.png");
			}
			fight=false;
		} else
		if (key== KeyEvent.VK_L)
		{
			if (binhmau>0)
			{
				if (hp <=  maxhp-8)
				{
					hp = hp +8;
				} else
				{
					hp = maxhp;
				}
				binhmau=binhmau-1;
			}
		}
		if (key== KeyEvent.VK_K)
		{
			if (status==Status.UP)
			{
				this.loadimage("Image/war-up.png");
			}
			if (status==Status.DOWN)
			{
				this.loadimage("Image/war-down.png");
			} else
			if (status==Status.LEFT)
			{
				this.loadimage("Image/war-left.png");
			} else 
			if (status==Status.RIGHT)
			{
				this.loadimage("Image/war-right.png");
			}
			skill=false;
		}
		
	}
	public void keypressed (KeyEvent e)
	{
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_J:
		{
			if (status==Status.UP)
			{
				this.loadimage("Image/war-ATK-up.gif");
			}
			if (status==Status.DOWN)
			{
				this.loadimage("Image/war-ATK-down.gif");
			} else
			if (status==Status.LEFT)
			{
				this.loadimage("Image/war-ATK-left.gif");
			} else 
			if (status==Status.RIGHT)
			{
				this.loadimage("Image/war-ATK-right.gif");
			}
			fight = true;
			break;
		}
		case KeyEvent.VK_K:
		{
			if (mn>3)
			{
				if (status==Status.UP)
				{
					this.loadimage("Image/war_up_skill.gif");
				}
				if (status==Status.DOWN)
				{
					this.loadimage("Image/war_down_skill.gif");
				} else
				if (status==Status.LEFT)
				{
					this.loadimage("Image/war_left_skill.gif");
				} else 
				if (status==Status.RIGHT)
				{
					this.loadimage("Image/war_right_skill.gif");
				}
				skill = true;
				mn=mn-3;
			} else
			{
				skill = false;
			}
			break;
		}
		}
	}
}

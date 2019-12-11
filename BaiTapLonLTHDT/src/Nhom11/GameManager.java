package Nhom11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GameManager extends JPanel implements Common,ActionListener{
	public static boolean playgame=false;
	public static boolean shop = false;
	public static boolean ingame;
	public static int SGY = 280;
	public static int map=1;
	public static int loop=0;
	public static ArrayList<Bullet> bullets;
		
	private boolean wingame;
	private StartGame startgame;
	private Board board;
	private SideWalk sw;
	private Player player;
	private ArrayList<Monster> monsters;  
	private ArrayList<HealthPotion> potions;
	private ArrayList<Item> items;
	private Timer timer;
	
	public GameManager ()
	{
		initgame();
	}
    public void initgame()
    {
    	ingame=true;
    	wingame=false;
		setFocusable(true);
		setBackground(Color.WHITE);
		setDoubleBuffered(true);
		player = new Player (360,320);
		Controls controls = new Controls (player);
		addKeyListener(controls);
		monsters = new ArrayList<>();
		potions  = new ArrayList<>();
		items  = new ArrayList<>();
		bullets = new ArrayList<>();
		initmonster("Image/quai.txt");
		sw = new SideWalk(player);
		timer = new Timer(DELAY,this);
		timer.start();
    }
    public void initmonster(String str) 
    {
    	try(Scanner sc = new Scanner (new File(str)))
    	{
    		int n = sc.nextInt();
    		for (int i=0;i<n;i++)
    		{
    			monsters.add(new Monster(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
    		}
    	} catch (Exception e) {
			System.out.print("loi");
		}
    }
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	if (!playgame)
    	{
    		startgame = new StartGame(SGY);
     		startgame.draw(g);
    	} else if (playgame && ingame)
    	{
    		board = new Board("Image/map"+map+".txt");
//     		board.draw(g);
    		Image board = new ImageIcon("Image/map"+map+".png").getImage();
    		g.drawImage(board, 0, 50, this);
    		sw.draw(g);
    		for (int i=0;i<monsters.size();i++)
    		{
    			Monster monster = monsters.get(i);
    			if (monster.getMap()==map)
    			{
    				monster.drawHp(g);
            		g.drawImage(monster.image, monster.x, monster.y-12, this);
    			}    			
    		} 
    		for (int i=0;i<potions.size();i++)
    		{
    			HealthPotion potion = potions.get(i);
    			g.drawImage(potion.image, potion.x, potion.y, this);
    		}
    		for (int i=0;i<items.size();i++)
    		{
    			Item item = items.get(i);
    			g.drawImage(item.image, item.x, item.y, this);
    		}
    		for (int i=0;i<bullets.size();i++)
    		{
    			Bullet bullet = bullets.get(i);
    			if(bullet.monster.getSpecies()==9)
    			{
    				g.drawImage(bullet.image, bullet.x+15, bullet.y+30, this);
    			} else
    			g.drawImage(bullet.image, bullet.x+10, bullet.y+10, this);
    		}
    		g.drawImage(player.image,player.x, player.y-9, this);
    	} else if (!ingame)
    	{
    		Image gameover = new ImageIcon("Image/game_over.gif").getImage();
    		g.drawImage(gameover, 0, 0, this);
    	} 
    	if (wingame)
    	{
    		Image wingame = new ImageIcon("Image/win_game.png").getImage();
    		g.drawImage(wingame, 0, 0, this);
    	}
    	if (shop)
    	{
    		Shop sh = new Shop(player,new ImageIcon("Image/shop.png").getImage(),new ImageIcon("Image/mui_ten_shop.png").getImage());
    		sh.paintComponent(g);
    	}
    }
	@Override
	public
	void actionPerformed(ActionEvent e) {
		inGame();
		updateplayer();
		updatemonster();	
		updatepotion();
		updateitem();
		updatebullet();
		checkCollisonMonster();
		checkCollisonPotion();
		checkCollisonItem();
		checkCollisonBullet();
		repaint();
		loop++;
		if (loop%200==0 && player.getMn()<player.getMaxmn()) player.setMn(player.getMn()+1);
		if (loop%250==0 && player.getHp()<player.getMaxhp()) player.setHp(player.getHp()+1);
	}
	public void checkhp ()
	{
		if (player.getHp()<=0) ingame=false;
		else ingame=true;
	}
	public void inGame ()
	{
		if (!ingame)
		{
			timer.stop();
		}
		if (wingame == true)
		{
			timer.stop();
		}
	}
	public void updateplayer ()
	{
		player.move();
		player.setMaxexp(player.exptoLvup(player.getLv()));
		player.upLv(player.getLv());
		player.muado(player.x, player.y);
	}
	public void updatemonster ()
	{
		
		for(int i = 0;i<monsters.size();i++)
		{
			Monster monster = monsters.get(i);
			if (monster.getMap()==map)
			{
				if (monster.die==true) 
				{
					monster.loadimage("");
				}
				else if(!monster.isFight()) monster.move();
				if (monster.die==true && loop%500==0) 
					{
					    monster.die=false;
					    monster.setHp(monster.getMaxhp());
					}
				if (monster.getSpecies()==9 && (loop%100==0 || loop%100==1 || loop%100==2 || loop%100==3 ||loop%100==4 ))
				{
					monster.skill();
				}
				if (monster.getShot()==1 && loop%100==0 && !monster.isDie())
				{
					if(monster.getSpecies()!=9)
					{
						Bullet bullet = new Bullet(monster.x, monster.y, monster);
						bullets.add(bullet);
					} else
					{
						Bullet bullet1 = new Bullet(monster.x, monster.y, monster,1);
						bullets.add(bullet1);
						Bullet bullet2 = new Bullet(monster.x, monster.y, monster,2);
						bullets.add(bullet2);
						Bullet bullet3 = new Bullet(monster.x, monster.y, monster,3);
						bullets.add(bullet3);
						Bullet bullet4 = new Bullet(monster.x, monster.y, monster,4);
						bullets.add(bullet4);
						Bullet bullet5 = new Bullet(monster.x, monster.y, monster,5);
						bullets.add(bullet5);
						Bullet bullet6 = new Bullet(monster.x, monster.y, monster,6);
						bullets.add(bullet6);
						Bullet bullet7 = new Bullet(monster.x, monster.y, monster,7);
						bullets.add(bullet7);
						Bullet bullet8 = new Bullet(monster.x, monster.y, monster,8);
						bullets.add(bullet8);
					}				
				}
			}			
		}
	}
	public void updatepotion ()
	{
		for (int i=0;i<potions.size();i++)
		{
			HealthPotion potion = potions.get(i);
			if (potion.isLive()==false) potions.remove(i);
		}
	}
	public void updateitem ()
	{
		for (int i=0;i<items.size();i++)
		{
			Item item = items.get(i);
			if (item.isLive()==false) items.remove(i);
		}
	}
	public void updatebullet ()
	{
		for (int i=0;i<bullets.size();i++)
		{
			Bullet bullet = bullets.get(i);
			if (bullet.kiemtradan()==false || bullet.isLive()==false) bullets.remove(i);
			else bullet.move();
		}
	}
	public void checkCollisonMonster()
	{
//		Graphics g =null;
		Rectangle myCharBound = player.getBound();
		for(int i = 0;i<monsters.size();i++)
		{
		Monster monster = monsters.get(i);
		Rectangle monsterBound = monster.getBound();
		if (myCharBound.intersects(monsterBound))
		{
			if (monster.getMap()==map)
			{
				monster.setFight(true);
				if (loop%50==0 && monster.die==false) player.setHp(player.getHp()-monster.getAtk()+monster.getDef());
				if (player.isFight()==true && monster.getHp()>0)
				{
					Random rd = new Random();
					if (rd.nextInt(100)>60)
					{
						int dmg = player.getAtk()-monster.getDef();
						if (dmg>=0) monster.setHp(monster.getHp()-dmg);
					}
					if (monster.getHp()<=0) 
						{
						if (rd.nextInt(100)>60) potions.add(new HealthPotion(monster.x,monster.y));
						if (rd.nextInt(100)>50 && monster.getSpecies()==7) items.add(new Item(monster.x,monster.y));
						monster.die=true;
						if (monster.getSpecies()==9) wingame=true;
						player.setExp(player.getExp()+monster.getExp());
						player.setGold(player.getGold()+monster.getGold());
						player.setKill(player.getKill()+1);
						}
				}
				if (player.isSkill()==true && monster.getHp()>0)
				{
					Random rd = new Random();
					if (rd.nextInt(100)>20)
						{
						    int dmg=player.getAtk()*3-monster.getDef();
						    if (dmg>=0) monster.setHp(monster.getHp()-dmg);
//						    g.setColor(Color.BLACK);
//						    g.drawString("-"+dmg, monster.x, monster.y-10);
						}
					if (monster.getHp()<=0) 
						{
						if (rd.nextInt(100)>60) potions.add(new HealthPotion(monster.x,monster.y));
						if (rd.nextInt(100)>70 && monster.getSpecies()==7) items.add(new Item(monster.x,monster.y));
						monster.die=true;
						if (monster.getSpecies()==9) wingame=true;
						player.setExp(player.getExp()+monster.getExp());
						player.setGold(player.getGold()+monster.getGold());
						player.setKill(player.getKill()+1);
						}
				}
				checkhp();
			}			
		} else
		{
			monster.setFight(false);
		}
		}
	}
	public void checkCollisonPotion ()
	{
		Rectangle myCharBound = player.getBound();
		for (int i=0;i<potions.size();i++)
		{
			HealthPotion potion = potions.get(i);
			Rectangle potionBound = potion.getBound();
			if (myCharBound.intersects(potionBound))
			{
				player.setBinhmau(player.getBinhmau()+1);
				potion.setLive(false);
			}
		}
	}
	public void checkCollisonItem ()
	{
		Rectangle myCharBound = player.getBound();
		for (int i=0;i<items.size();i++)
		{
			Item item = items.get(i);
			Rectangle itemBound = item.getBound();
			if (myCharBound.intersects(itemBound))
			{
				player.setItem(player.getItem()+1);
				item.setLive(false);
			}
		}
	}
	public void checkCollisonBullet ()
	{
		Rectangle myCharBound = player.getBound();
		for (int i=0;i<bullets.size();i++)
		{
			Bullet bullet = bullets.get(i);
			Rectangle bulletBound = bullet.getBound();
			if (myCharBound.intersects(bulletBound))
			{
				player.setHp(player.getHp()-bullet.damage(player.getLv()));
				bullet.setLive(false);
			}
		}
	}
}

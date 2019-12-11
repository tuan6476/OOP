package Nhom11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class SideWalk {
    private Player player;

	public SideWalk(Player player) {
		super();
		this.player = player;
	}
    
    public void draw (Graphics g)
    {
    	g.setColor(new Color(130,100,84));
		g.fillRect(0, 0, 640, 50);
		g.setColor(Color.WHITE);
		g.drawString("HP", 20, 15);
		g.setColor(Color.RED);
		g.fillRect(60, 10, 300*player.getHp()/player.getMaxhp(), 5);
		g.setColor(Color.WHITE);
		g.drawString("MP", 20, 25);
		g.setColor(Color.BLUE);
		g.fillRect(60, 20, 300*player.getMn()/player.getMaxmn(), 5);
		Font font = new Font("Arial",Font.BOLD,16);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Lv "+player.getLv(), 18, 40);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(60, 30, 300*player.getExp()/player.getMaxexp(), 5);
		Image binhmau = new ImageIcon("Image/hp.png").getImage();
		g.drawImage(binhmau, 420, 5, null);
		g.setColor(Color.WHITE);
		g.drawString(""+player.getBinhmau(), 445, 20);
		Image gold = new ImageIcon("Image/gold.png").getImage();
		g.drawImage(gold, 470, 5, null);
		g.setColor(Color.WHITE);
		g.drawString(""+player.getGold(), 495, 20);
    }
}

package Nhom11;

import  static Nhom11.GameManager.SGY;
import  static Nhom11.GameManager.playgame;
import  static Nhom11.GameManager.map; 
import  static Nhom11.GameManager.shop;
import  static Nhom11.GameManager.ingame; 
import  static Nhom11.Shop.SGX;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Controls extends KeyAdapter{
	private Player player;
		
	public Controls(Player player) {
		super();
		this.player = player;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (!playgame)
		{
			if (key==KeyEvent.VK_A)
			{
				System.exit(0);
			} else
			if (key==KeyEvent.VK_DOWN && SGY==280)
			{
				SGY=370;
			} else
			if (key==KeyEvent.VK_UP && SGY==370)
			{
				SGY=280;
			} else 
			if (key==KeyEvent.VK_ENTER && SGY==280)
			{
				playgame=true;
			} else
			if (key==KeyEvent.VK_ENTER && SGY==370)
			{
				playgame = false;
				JFrame hd = new JFrame("Hướng dẫn");
                hd.setSize(550, 520);
                hd.setResizable(false);
                hd.setLocationRelativeTo(null);
                hd.setVisible(true);
                JTextArea ta = new JTextArea();
                hd.add(ta);     
                ta.setEditable(false);
                ta.setBackground(new Color(250, 250, 250));
                ta.setFont(new java.awt.Font("Arial", 1, 25));
                ta.setText("\n Sử dụng các phím mũi tên để di chuyển"
                		+ "\n Bấm J để đánh, K để dùng skill, L để hồi máu"
                		+ "\n Bấm U để xem thông tin nhân vật"
                		+ "\n Bấm I để xem nhiệm vụ"
                		+ "\n Bấm Q để thoát ra ngoài"
                		+ "\n Bấm A để thoát game");
			}
		} else 
		{
			if (key==KeyEvent.VK_A)
			{
				System.exit(0);
			} else
			if (key==KeyEvent.VK_U)
			{
				JFrame showinfomation = new JFrame("Thông tin nhân vật");
				showinfomation.setContentPane(new ShowInfo(new ImageIcon("Image/background-showinfo.png").getImage(),player));	
				showinfomation.setSize(450, 420);
				showinfomation.setResizable(false);
				showinfomation.setLocationRelativeTo(null);
				showinfomation.setVisible(true);			
			} else
			if (key==KeyEvent.VK_I)
			{
				JFrame misson = new JFrame("Nhiệm vụ");
				misson.setSize(450, 200);
				misson.setResizable(false);
				misson.setLocationRelativeTo(null);
				misson.setVisible(true);
				if (map==1)
				{
					JTextArea ta = new JTextArea();
	                misson.add(ta);     
	                ta.setEditable(false);
	                ta.setBackground(new Color(250, 250, 250));
	                ta.setFont(new java.awt.Font("Arial", 1, 25));
	                ta.setText("\n\n             Đánh bại 15 con quái"
	                		+ "\n                        ("+player.getKill()+"/15)");
				} else
				if (map==2)
				{
					JTextArea ta = new JTextArea();
	                misson.add(ta);     
	                ta.setEditable(false);
	                ta.setBackground(new Color(250, 250, 250));
	                ta.setFont(new java.awt.Font("Arial", 1, 25));
	                ta.setText("\n\n             Bạn cần lên cấp 3");
				} else
				if (map==3)
				{
					JTextArea ta = new JTextArea();
	                misson.add(ta);     
	                ta.setEditable(false);
	                ta.setBackground(new Color(250, 250, 250));
	                ta.setFont(new java.awt.Font("Arial", 1, 25));
	                ta.setText("\n\n             Đánh bại 25 con quái"
	                		+ "\n                        ("+player.getKill()+"/25)");
				} else
				if (map==4)
				{
					JTextArea ta = new JTextArea();
	                misson.add(ta);     
	                ta.setEditable(false);
	                ta.setBackground(new Color(250, 250, 250));
	                ta.setFont(new java.awt.Font("Arial", 1, 25));
	                ta.setText("\n\n             Thu thập 15 huy hiệu"
	                		+ "\n                        ("+player.getItem()+"/15)");
				} else
				if (map==5)
				{
					JTextArea ta = new JTextArea();
		            misson.add(ta);     
		            ta.setEditable(false);
		            ta.setBackground(new Color(250, 250, 250));
		            ta.setFont(new java.awt.Font("Arial", 1, 25));
	                ta.setText("\n\n             Đánh bại boss");
					}
			} else
			if (shop == true)
			{
				if (key==KeyEvent.VK_DOWN && SGX==220)
				{
					SGX=360;
				} else
				if (key==KeyEvent.VK_UP && SGX==360)
				{
					SGX=220;
				} else 
				if (key==KeyEvent.VK_DOWN && SGX==360)
				{
					SGX=480;
				} else
				if (key==KeyEvent.VK_UP && SGX==480)
				{
					SGX=360;
				} else
				if (key==KeyEvent.VK_ENTER && SGX==220)
				{
					if (player.getGold()>=100)
					{
						player.setAtk(player.getAtk()+1);
						player.setGold(player.getGold()-100);
					}
					
				} else
				if (key==KeyEvent.VK_ENTER && SGX==360)	
				{
					if (player.getGold()>=100)
					{
						player.setDef(player.getDef()+1);
						player.setGold(player.getGold()-100);
					}	
				} else
				if (key==KeyEvent.VK_ENTER && SGX==480)	
				{
					if (player.getGold()>=50)
					{
						player.setBinhmau(player.getBinhmau()+1);
						player.setGold(player.getGold()-50);
					}
				} else
				if (key==KeyEvent.VK_Q)
				{
					shop = false;
				}
			} else
			player.keypressed(e);
			if(key == KeyEvent.VK_A)
			{
				playgame=false;
			}
		}
	}
    @Override
    public void keyReleased(KeyEvent e) {
    	player.keyreleased(e);
    }
}

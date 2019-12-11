package Nhom11;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class StartGame implements Common{
    private Image background;
    private Image icon;
      
    private int SGY;

	public StartGame(int x) {
		SGY=x;
		background = new ImageIcon("Image/background.png").getImage();
		icon = new ImageIcon("Image/mui-ten.png").getImage();
	}
    public void draw (Graphics g)
    {
    	g.drawImage(background,0,0,null);
//		g.setFont(new Font("Arial", Font.BOLD, 40)); 
		g.drawImage(icon, 280, SGY, null);
    }
}

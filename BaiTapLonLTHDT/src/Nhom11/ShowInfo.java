package Nhom11;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowInfo extends JComponent{
	private Player player;
	private Image background;
	public ShowInfo(Image img,Player player) {
		background = img;
		this.player = player;
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
    	g.drawImage(background, 0, 0, this);
    	g.setColor(Color.WHITE);
    	g.setFont(new Font("Arial",1,25));
    	g.drawString("Thông tin nhân vật", 130, 70);
    	g.drawString("HP: "+player.getHp()+"/"+player.getMaxhp(), 30, 120);
    	g.drawString("MP: "+player.getMn()+"/"+player.getMaxmn(), 30, 150);
    	g.drawString("Lv "+player.getLv(), 280, 120);
    	g.drawString("Lên cấp: "+player.getExp()+"/"+player.getMaxexp(), 255, 150);
    	g.drawString("Tấn công: "+player.getAtk(), 30, 180);
    	g.drawString("Phòng thủ: "+player.getDef(), 30, 210);
    	g.drawString("Tốc độ: "+5, 30, 240);
	}
}

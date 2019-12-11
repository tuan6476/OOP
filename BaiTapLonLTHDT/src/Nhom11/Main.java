package Nhom11;

import javax.swing.JFrame;

public class Main extends JFrame implements Common{
     public Main ()
     {
    	 setTitle("Lap trinh huong doi tuong");
    	 add(new GameManager());
    	 setResizable(false);
    	 setSize(Common.WIDTH, Common.HEIGHT+80);
    	 setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 setLocationRelativeTo(null);
    	 setVisible(true);
     }
     public static void main(String[] args) {
		new Main();
	}
}

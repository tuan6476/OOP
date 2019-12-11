package Nhom11;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class Board implements Common{
    public static int mang[][]=new int[COUNTH][COUNTW];
     
    private Image wall;
    private Image road;
	public Board(String str) {
        NhapMangTuFile(str);
	}
	public void NhapMangTuFile(String tenFile){
        try(Scanner sc = new Scanner(new File(tenFile))){                     
            for(int i = 0 ; i < Common.COUNTH; i++)
                for( int j = 0; j < Common.COUNTW; j++ )
                    mang[i][j] = sc.nextInt();
            
        }catch(Exception ex){
            System.out.printf("Loi gap phai");
        }
    }
    public void draw (Graphics g)
    {
    	int x ,y;
    	for (int i=0;i<COUNTH;i++)
    		for (int j=0;j<COUNTW;j++)
    		{
    			x=i*CELLW;
    			y=j*CELLH+50;
    			if (mang[j][i]==1)
    			{
    				road = new ImageIcon("Image/duong.png").getImage();
                    g.drawImage(road, x, y, CELLW, CELLH, null);
    			} else
//    			if (mang[j][i]==9)
    			{
    				wall = new ImageIcon("Image/tuong.png").getImage();
                    g.drawImage(wall, x, y, CELLW, CELLH, null);
    			}
    		}
    }
     
     
}

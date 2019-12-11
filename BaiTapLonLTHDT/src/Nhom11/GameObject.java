package Nhom11;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class GameObject {
    protected int x,y;
    protected int width,height;
    protected Image image;
	public GameObject(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void loadimage (String str)
	{
		ImageIcon ii = new ImageIcon(str);
		this.image=ii.getImage();
	}
	public void getimageDimention ()
	{
		this.width=image.getWidth(null);
		this.height=image.getHeight(null);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Rectangle getBound()
	{
		return new Rectangle(x,y,width,height);
	}
}

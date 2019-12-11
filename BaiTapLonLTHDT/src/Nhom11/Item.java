package Nhom11;

public class Item extends GameObject{
	private boolean live;
	public Item (int x, int y) {
		super(x, y);
		this.x=x;
		this.y=y;
		init();
	}
    public void init ()
    {
    	this.live=true;
    	this.loadimage("Image/item.png");
    	this.getimageDimention();
    }
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
}

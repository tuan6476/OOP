package Nhom11;

public class HealthPotion extends GameObject{
    private boolean live;
	public HealthPotion(int x, int y) {
		super(x, y);
		this.x=x;
		this.y=y;
		init();
	}
    public void init ()
    {
    	this.live=true;
    	this.loadimage("Image/hp.png");
    	this.getimageDimention();
    }
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
    
}

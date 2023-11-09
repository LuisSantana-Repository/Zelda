package src.iteso.objects;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Move {
	public int x,y;
	protected int speed;
	protected int life;
	public int direction;
	protected BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
	protected int fCounter=0,iCounter=1;
	
	public abstract void update();
	public abstract void draw(Graphics2D g2);
	public Rectangle hitbox;
	
	
}

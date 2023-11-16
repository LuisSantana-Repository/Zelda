package src.iteso.objects;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Move {
	protected int x,y;
	protected int speed;
	protected int life;
	protected direccion direction;
	protected BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
	protected int fCounter=0,iCounter=1;
	protected Rectangle hitbox;
	
	public abstract void update();
	public abstract void draw(Graphics2D g2);
	public abstract int getX();
	public abstract int getY();
	public abstract Rectangle getHitbox();
	public abstract direccion getDireccion();
	
	
}

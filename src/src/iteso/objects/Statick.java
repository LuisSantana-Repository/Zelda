package src.iteso.objects;
import java.awt.Graphics2D;
import java.awt.image.*;

public abstract class Statick {
	protected BufferedImage image;
	protected Boolean colicion;
	
	protected abstract void paint(Graphics2D g2);
	protected abstract void update();
	
}

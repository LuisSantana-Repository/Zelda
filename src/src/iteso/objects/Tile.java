package src.iteso.objects;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {
	private BufferedImage image;
	private Boolean colicion;
	private Tile() {}
	
	
	
	public Tile(int colicion, BufferedImage image) {
		this.colicion=true;
		this.image= image;
		
	}



	public BufferedImage getImage() {
		return image;
	}



	public Boolean getColicion() {
		return colicion;
		}
	

}

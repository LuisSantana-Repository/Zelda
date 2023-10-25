package src.iteso.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import src.iteso.game.GamePanel;

public class Tile extends Statick {
	private Tile() {}
	
	
	
	public Tile(int colicion, BufferedImage image) {
		this.colicion=colicion;
		this.image= image;
		
	}
	

}

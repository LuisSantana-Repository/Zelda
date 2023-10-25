package src.iteso.objects;

import java.awt.Color;
import java.awt.Graphics2D;

import src.iteso.game.GamePanel;

public class Background extends Statick{
	private Background() {}
	public static final int OVERWORLD=1;
	private Color imagen;
	
	public Background(int color) {
		
		switch(color) {
			case 1:
				imagen = new Color(252, 216, 168);
				break;
			default:
				imagen = Color.BLACK;
				break;
		}
	}
	
	public void update() {}
	
	public void draw(Graphics2D g2) {
		g2.setColor(imagen);
		g2.fillRect(0, 0, GamePanel.maxColums, GamePanel.maxHeight);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, GamePanel.maxColums, GamePanel.maxHeight-(GamePanel.tileSize*11));
	}
}

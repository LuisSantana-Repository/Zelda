package src.iteso.objects;

import java.awt.Color;
import java.awt.Graphics2D;

import src.iteso.game.GamePanel;

public class Foreground extends Statick {
	private Color imagen;
	public Foreground() {
		imagen = Color.BLACK;
	}
	
	@Override
	public void paint(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, GamePanel.maxColums, GamePanel.maxHeight-(GamePanel.tileSize*11));
	}

	@Override
	protected void update() {
	}

}

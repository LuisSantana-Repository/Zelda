package src.iteso.game;

import src.iteso.objects.*;

public class CollicionDetector {
	public CollicionDetector() {
	}
	
	public static Boolean deteccionPared(Player Link) {
		int leftXTile = (Link.getX() + Link.getHitbox().x)/GamePanel.tileSize;
		int rightXTile = (Link.getX() + Link.getHitbox().x +Link.getHitbox().width)/GamePanel.tileSize;
		int upYTile = ((Link.getY() + Link.getHitbox().y)/GamePanel.tileSize)-3;
		int downYTile =((Link.getY() + Link.getHitbox().y +Link.getHitbox().height)/GamePanel.tileSize)-3;
		//System.out.println(leftXTile+" "+rightXTile);
		//System.out.println(upYTile+" "+downYTile);
		
		if(leftXTile<0)leftXTile=0;
		if(rightXTile<0)rightXTile=0;
		if(upYTile<0)upYTile=0;
		if(downYTile<0)downYTile=0;
		
		if(leftXTile>15)leftXTile=15;
		if(rightXTile>15)rightXTile=15;
		if(upYTile>10)upYTile=10;
		if(downYTile>10)downYTile=10;
		
		
		switch(Link.getDireccion()) {
		case UP:
			if(GamePanel.Map().colided(upYTile, leftXTile)==true || GamePanel.Map().colided(upYTile, rightXTile)) {
				return true;
			}else
				return false;
			
			
		case DOWN:
			if(GamePanel.Map().colided(downYTile, leftXTile)==true || GamePanel.Map().colided(downYTile, rightXTile)) {
				return true;
			}else
				return false;
			
			
		case LEFT:
			if(GamePanel.Map().colided(downYTile, leftXTile)==true || GamePanel.Map().colided(upYTile, leftXTile)) {
				return true;
			}else
				return false;
			
			
			
		case RIGHT:
			if(GamePanel.Map().colided(downYTile, rightXTile)==true || GamePanel.Map().colided(upYTile, rightXTile)) {
				return true;
			}else
				return false;
		}
		
		return false;
		
	}
}

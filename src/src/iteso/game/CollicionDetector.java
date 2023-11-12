package src.iteso.game;

import src.iteso.objects.*;

public class CollicionDetector {
	public CollicionDetector() {
	}
	
	public static Boolean deteccionPared(Player Link) {
		int leftXTile = (Link.x + Link.hitbox.x)/GamePanel.tileSize;
		int rightXTile = (Link.x + Link.hitbox.x +Link.hitbox.width)/GamePanel.tileSize;
		int upYTile = ((Link.y + Link.hitbox.y)/GamePanel.tileSize)-3;
		int downYTile =((Link.y + Link.hitbox.y +Link.hitbox.height)/GamePanel.tileSize)-3;
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
		
		
		switch(Link.direction) {
		case 1:
			if(GamePanel.Map().colided(upYTile, leftXTile)==true || GamePanel.Map().colided(upYTile, rightXTile)) {
				return true;
			}else
				return false;
			
			
		case 2:
			if(GamePanel.Map().colided(downYTile, leftXTile)==true || GamePanel.Map().colided(downYTile, rightXTile)) {
				return true;
			}else
				return false;
			
			
		case 3:
			if(GamePanel.Map().colided(downYTile, leftXTile)==true || GamePanel.Map().colided(upYTile, leftXTile)) {
				return true;
			}else
				return false;
			
			
			
		case 4:
			if(GamePanel.Map().colided(downYTile, rightXTile)==true || GamePanel.Map().colided(upYTile, rightXTile)) {
				return true;
			}else
				return false;
		}
		
		return false;
		
	}
}

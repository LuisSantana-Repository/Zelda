package src.iteso.objects;
import src.iteso.game.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player extends Move {
	GamePanel gp;
	Keyboard kb;
	Rectangle hitbox;
	boolean attack;
	boolean colicionOn = false;

	
	
	private Player() {}
	
	
	public Player(GamePanel gp, Keyboard kb) {
		this.gp =gp;
		this.kb=kb;
		start();
		hitbox = new Rectangle(8,16,32,32);
		life = 3;
		
		try {
			down1=ImageIO.read(getClass().getResourceAsStream("/Link/FW/l0_sprite_1.png"));
			down2=ImageIO.read(getClass().getResourceAsStream("/Link/FW/l0_sprite_2.png"));
			up1=ImageIO.read(getClass().getResourceAsStream("/Link/BW/sprite_0.png"));
			up2=ImageIO.read(getClass().getResourceAsStream("/Link/BW/sprite_1.png"));
			left1=ImageIO.read(getClass().getResourceAsStream("/Link/SLW/sprite_0.png"));
			left2=ImageIO.read(getClass().getResourceAsStream("/Link/SLW/sprite_1.png"));
			right1=ImageIO.read(getClass().getResourceAsStream("/Link/SRW/sprite_0.png"));
			right2=ImageIO.read(getClass().getResourceAsStream("/Link/SRW/sprite_1.png"));
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	
	public void start() {
		this.x=100;
		this.y=100;
		this.speed =4;
		this.direction=4;
	}
	
	public void update() {
		if(kb.isW()||kb.isA()||kb.isS()||kb.isD()) {
			if(kb.isW()) {
				this.direction=1;
				this.y -= this.speed;
			}
			else if(kb.isS()) {
				this.direction=2;
				this.y += this.speed;
			}
			else if(kb.isA()) {
				this.direction=3;
				this.x -= this.speed;
			}
			else if(kb.isD()) {
				this.direction=4;
				this.x += this.speed;
			}
			fCounter++;
			if(fCounter>10) {
				if(iCounter==1) {
					iCounter=2;
				}else {
					iCounter=1;
				}
				fCounter=0;
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(this.x, this.y, GamePanel.tileSize, GamePanel.tileSize);
		BufferedImage temp = null;
		switch(direction) {
		case 1:
			if(iCounter==1) {
				temp= up1;
			}else {
				temp= up2;
			}
			break;
		case 2:
			if(iCounter==1) {
				temp= down1;
			}else {
				temp= down2;
			}
			break;
		case 3:
			if(iCounter==1) {
				temp=left1;
			}else {
				temp=left2;
			}
			
			break;
		case 4:
			if(iCounter==1) {
				temp=right1;
			}else {
				temp=right2;
			}
			break;
		}
		g2.drawImage(temp, x,y,GamePanel.tileSize,GamePanel.tileSize,null); 
		
		//g2.setColor(Color.BLACK);
		//g2.fillRect(this.x+hitbox.x, this.y+hitbox.y, hitbox.height, hitbox.width);
	}
}

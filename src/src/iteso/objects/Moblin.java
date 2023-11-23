package src.iteso.objects;
import src.iteso.game.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Moblin extends Move {
	
	//private boolean attack;
	int mCounter=0;
	
	
	
	
	public Moblin() {
		start();
		hitbox = new Rectangle(12,24,24,24);
		life = 3;
		
		try {
			down1=ImageIO.read(getClass().getResourceAsStream("/Moblin/moblin frente 1.png"));
			down2=ImageIO.read(getClass().getResourceAsStream("/Moblin/moblin frente 2.png"));
			up1=ImageIO.read(getClass().getResourceAsStream("/Moblin/moblin atras 1.png"));
			up2=ImageIO.read(getClass().getResourceAsStream("/Moblin/moblin atras 2.png"));
			left1=ImageIO.read(getClass().getResourceAsStream("/Moblin/moblin izquierda 1.png"));
			left2=ImageIO.read(getClass().getResourceAsStream("/Moblin/moblin izquierda 2.png"));
			right1=ImageIO.read(getClass().getResourceAsStream("/Moblin/moblin derecha 1.png"));
			right2=ImageIO.read(getClass().getResourceAsStream("/Moblin/moblin derecha 1.png"));
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	
	public void start() {
		this.x=300;
		this.y=300;
		this.speed =4;
		this.direction=direccion.RIGHT;
	}

	public void update() {
		

			if(mCounter<50) {//up 1
				this.direction=direccion.UP;
				this.y -= this.speed;
			}
			else if(mCounter<100) {//down 2
				this.direction=direccion.DOWN;
				this.y += this.speed;
			}
			else if(mCounter<150) {//left 3
				this.direction=direccion.LEFT;
				this.x -= this.speed;
			}
			else if(mCounter<200) {//right 4 
				this.direction=direccion.RIGHT;
				this.x += this.speed;
			}
			else if(mCounter<201) {
				mCounter=0;
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
			
			
			if(CollicionDetector.deteccionPared(this) == true) {
				System.out.println("choque");
				switch(direction) {
				case UP:
					this.y += this.speed;
					break;
					
				case DOWN:
					this.y -= this.speed;
					break;
					
				case LEFT:
					this.x += this.speed;
					break;
				case RIGHT:
					this.x -= this.speed;
					break;
				}
				
			}
			
		}
		
	
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(this.x, this.y, GamePanel.tileSize, GamePanel.tileSize);
		BufferedImage temp = null;
		switch(direction) {
		case UP:
			if(iCounter==1) {
				temp= up1;
			}else {
				temp= up2;
			}
			break;
		case DOWN:
			if(iCounter==1) {
				temp= down1;
			}else {
				temp= down2;
			}
			break;
		case LEFT:
			if(iCounter==1) {
				temp=left1;
			}else {
				temp=left2;
			}
			
			break;
		case RIGHT:
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
	
	public int moveX(){
		int leftXTile = (x + hitbox.x)/GamePanel.tileSize;
		int rightXTile = (x + hitbox.x +hitbox.width)/GamePanel.tileSize;
		if(leftXTile>15) {
			x=x-GamePanel.maxColums;
			return +1;
			
		}else if(rightXTile<0) {
			x=x+GamePanel.maxColums+ GamePanel.tileSize;
			return -1;
		}
		return 0;
	}
	public int moveY() {
		int upYTile = ((y + hitbox.y)/GamePanel.tileSize)-3;
		int downYTile =((y + hitbox.y + hitbox.height)/GamePanel.tileSize)-3;
		if(upYTile>11) {
			y=y-GamePanel.maxHeight + 2*GamePanel.tileSize;
			return -1;
			
		}else if(downYTile<0) {
			y=y+GamePanel.maxHeight- 3*GamePanel.tileSize;
			return +1;
		}
		return 0;
	}


	@Override
	public int getX() {
		return x;
	}


	@Override
	public int getY() {
		return y;
	}


	@Override
	public direccion getDireccion() {
		return this.direction;
	}


	@Override
	public Rectangle getHitbox() {
		// TODO Auto-generated method stub
		return hitbox;
	}
}

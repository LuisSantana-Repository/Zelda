package src.iteso.game;

import java.awt.Graphics2D;
import java.io.*;

import javax.imageio.ImageIO;

import src.iteso.objects.Tile;

public class World {
	private World() {}
	private static Tile tiles[][];
	private int map[][] = new int[11][16];
	private int color;
	
	private void updateStatics()
	{
		try {
			tiles = new Tile[1][4];
			tiles[0][0]= new Tile(1, ImageIO.read(getClass().getResourceAsStream("/Tiles/Color1/bushes.png")));
			tiles[0][1]= new Tile(1, ImageIO.read(getClass().getResourceAsStream("/Tiles/Color1/agua verde.png")));
			tiles[0][2]= new Tile(1, ImageIO.read(getClass().getResourceAsStream("/Tiles/Color1/Arbol verde.png")));
			tiles[0][3]= new Tile(1, ImageIO.read(getClass().getResourceAsStream("/Tiles/Color1/caracol verde.png")));
			System.out.println("epico me llame");
		}catch(IOException e) {
			System.out.println(e);
		}
	}	
	
	public World(InputStream input) {
		if (tiles==null) {
			updateStatics();
		}
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			int x=0;
			int y=0;
			String line = reader.readLine();
			char [] caracters= line.toCharArray();
			color=Character.getNumericValue(caracters[0]);
			while(y<11) {
				line = reader.readLine();
				while(x<16){
					caracters= line.toCharArray();
					map[y][x]=Character.getNumericValue(caracters[x]);
					x++;
				}
				y++;
				x=0;
			}
			reader.close();
			
		}catch(Exception e) {
			System.out.println(e); 
			
		}
		
	}
	
	
	public void paint(Graphics2D g2) {
		for(int fila=0; fila<11 ;fila++) {
			for(int columna=0;columna<16;columna++) {
				if(map[fila][columna] !=0) {
					g2.drawImage(tiles[color-1][map[fila][columna]-1].getImage(), 
							columna*GamePanel.tileSize, fila*GamePanel.tileSize+(GamePanel.tileSize*3),
							GamePanel.tileSize,GamePanel.tileSize,null); 
				}
			}
		}
	}


	public Boolean colided(int y, int x) {
		if(map[y][x]!=0 && tiles[color-1][(map[y][x]) -1].getColicion()==true) {
			return true;
		}else {
			return false;
		}
	}
}



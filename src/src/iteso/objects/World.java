package src.iteso.objects;

import java.io.*;

import javax.imageio.ImageIO;

public class World {
	private World() {}
	private static Tile tiles[][];
	
	
	private void updateStatics()
	{
		
	}	
	
	
	public World(InputStream input) {
		if (tiles==null) {
			updateStatics();
		}
	}
}

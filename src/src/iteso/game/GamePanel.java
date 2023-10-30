package src.iteso.game;
import javax.swing.JPanel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import src.iteso.objects.*;

public class GamePanel extends JPanel implements Runnable{
	
	
	final public static int pixels =16;//16x16 size of link and objecs
	final public static int scale = 3; //16 bits is very samll so we make ir bigger
	final public static int tileSize = pixels*scale;
	
	//nes original size is 256 * 224
	final public static int pixelsCol=256/pixels;
	final public static int pixelsHeight=224/pixels;
	final public static int maxColums =256 * scale; 
	final public static int maxHeight= 224 * scale;
	//
	final private int FPS=24;
	int x=0;
	int y=0;
	World mundo[][]= new World[1][1];
	
	
	
	Thread gameThread;
	Keyboard key = new Keyboard();
	//un thread es unn hilo de ejecicion concurrentes dentro de un programa
	//se necesita runable para trabajar con treads
	
	
	Player link = new Player(this,key);
	Background background = new Background(Background.OVERWORLD);
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(maxColums, maxHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);//esto es para que el buffer lo haga detras de la imprecion en pocas palabras es para que la impreciones se vean bonitas
		this.addKeyListener(key);
		this.setFocusable(true); // ete objeto va a set el que reciba inturs siempre;
	}
	
	public void startGame() {
		gameThread = new Thread(this); 
		gameThread.start();
		//BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/1-1.txt")));
		mundo[0][0]= new World(getClass().getResourceAsStream("/1-1.txt"));
	}
	
	@Override
	public void run() {
		
		double interval =1000/FPS;// System nos puede dar el tiempo en milisegundos por ende podemos usar cuantos milisegundos hay en un segundo 
		double next= System.currentTimeMillis()+interval;
		double timeLeft;
		//sirve para updetear todo muentras que el juego corre y updatea el mapa
		
		while (gameThread != null) {
			update();
			
			repaint();
			
			
			try {
				timeLeft=next - System.currentTimeMillis();
				if(timeLeft>0) {
					Thread.sleep((long)timeLeft);
				}
				next = System.currentTimeMillis() + interval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//System.out.print("Funcionando 60fps");
		}
		
	}
	
	
	
	public void update() {
		link.update();
		background.update();
	}
	
	
	
	public void paint(Graphics g) {//grafics 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		background.drawback(g2);
		
		mundo[0][0].paint(g2);
		link.draw(g2);
		
		background.drawforward(g2);
		g2.dispose();
	}
}

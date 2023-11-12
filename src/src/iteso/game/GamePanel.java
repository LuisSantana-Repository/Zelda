package src.iteso.game;
import javax.swing.JPanel;
import java.awt.*;

import src.iteso.objects.*;

public class GamePanel extends JPanel implements Runnable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private static int pixels =16;//16x16 size of link and objecs
	final private static int scale = 3; //16 bits is very samll so we make ir bigger
	final public static int tileSize = pixels*scale;
	
	//nes original size is 256 * 224
	final public static int pixelsCol=256/pixels;
	final public static int pixelsHeight=224/pixels;
	final public static int maxColums =256 * scale; 
	final public static int maxHeight= 224 * scale;
	//
	final private int FPS=60;
	private int x=0;
	private int y=0;
	private World mundo[][]= new World[8][16];
	public static World map;
	
	
	private Thread gameThread;
	private Keyboard key = new Keyboard();
	//un thread es unn hilo de ejecicion concurrentes dentro de un programa
	//se necesita runable para trabajar con treads
	
	
	Player link = new Player();
	Background background = new Background(Background.OVERWORLD);
	Foreground foreground = new Foreground();
	
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
		mundo[0][0]= new World(getClass().getResourceAsStream("/0-0.txt"));
		mundo[0][1]= new World(getClass().getResourceAsStream("/0-1.txt"));
		mundo[0][2]= new World(getClass().getResourceAsStream("/0-2.txt"));
		mundo[0][3]= new World(getClass().getResourceAsStream("/0-3.txt"));
		mundo[0][4]= new World(getClass().getResourceAsStream("/0-4.txt"));
		mundo[0][5]= new World(getClass().getResourceAsStream("/0-5.txt"));
		mundo[0][6]= new World(getClass().getResourceAsStream("/0-6.txt"));
		mundo[0][7]= new World(getClass().getResourceAsStream("/0-7.txt"));
		mundo[0][8]= new World(getClass().getResourceAsStream("/0-8.txt"));
		mundo[0][9]= new World(getClass().getResourceAsStream("/0-9.txt"));
		mundo[0][10]= new World(getClass().getResourceAsStream("/0-10.txt"));
		mundo[0][11]= new World(getClass().getResourceAsStream("/0-11.txt"));
		mundo[0][12]= new World(getClass().getResourceAsStream("/0-12.txt"));
		mundo[0][13]= new World(getClass().getResourceAsStream("/0-13.txt"));
		mundo[0][14]= new World(getClass().getResourceAsStream("/0-14.txt"));
		mundo[0][15]= new World(getClass().getResourceAsStream("/0-15.txt"));

		mundo[1][0]= new World(getClass().getResourceAsStream("/1-0.txt"));
		mundo[1][1]= new World(getClass().getResourceAsStream("/1-1.txt"));
		mundo[1][2]= new World(getClass().getResourceAsStream("/1-2.txt"));
		mundo[1][3]= new World(getClass().getResourceAsStream("/1-3.txt"));
		mundo[1][4]= new World(getClass().getResourceAsStream("/1-4.txt"));
		mundo[1][5]= new World(getClass().getResourceAsStream("/1-5.txt"));
		mundo[1][6]= new World(getClass().getResourceAsStream("/1-6.txt"));
		mundo[1][7]= new World(getClass().getResourceAsStream("/1-7.txt"));
		mundo[1][8]= new World(getClass().getResourceAsStream("/1-8.txt"));
		mundo[1][9]= new World(getClass().getResourceAsStream("/1-9.txt"));
		mundo[1][10]= new World(getClass().getResourceAsStream("/1-10.txt"));
		mundo[1][11]= new World(getClass().getResourceAsStream("/1-11.txt"));
		mundo[1][12]= new World(getClass().getResourceAsStream("/1-12.txt"));
		mundo[1][13]= new World(getClass().getResourceAsStream("/1-13.txt"));
		mundo[1][14]= new World(getClass().getResourceAsStream("/1-14.txt"));
		mundo[1][15]= new World(getClass().getResourceAsStream("/1-15.txt"));
		
		mundo[2][0]= new World(getClass().getResourceAsStream("/2-0.txt"));
		mundo[2][1]= new World(getClass().getResourceAsStream("/2-1.txt"));
		mundo[2][2]= new World(getClass().getResourceAsStream("/2-2.txt"));
		mundo[2][3]= new World(getClass().getResourceAsStream("/2-3.txt"));
		mundo[2][4]= new World(getClass().getResourceAsStream("/2-4.txt"));
		mundo[2][5]= new World(getClass().getResourceAsStream("/2-5.txt"));
		mundo[2][6]= new World(getClass().getResourceAsStream("/2-6.txt"));
		mundo[2][7]= new World(getClass().getResourceAsStream("/2-7.txt"));
		mundo[2][8]= new World(getClass().getResourceAsStream("/2-8.txt"));
		mundo[2][9]= new World(getClass().getResourceAsStream("/2-9.txt"));
		mundo[2][10]= new World(getClass().getResourceAsStream("/2-10.txt"));
		mundo[2][11]= new World(getClass().getResourceAsStream("/2-11.txt"));
		mundo[2][12]= new World(getClass().getResourceAsStream("/2-12.txt"));
//		mundo[2][13]= new World(getClass().getResourceAsStream("/2-13.txt"));
		mundo[2][14]= new World(getClass().getResourceAsStream("/2-14.txt"));
		mundo[2][15]= new World(getClass().getResourceAsStream("/2-15.txt"));
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
		y=y+link.moveY();
		x=x+link.moveX();
		map = mundo[y][x];
		link.update();
		
		
	}
	
	
	
	public void paint(Graphics g) {//grafics 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		background.paint(g2);
		
		mundo[y][x].paint(g2);
		link.draw(g2);
		
		foreground.paint(g2);
		g2.dispose();
	}
	
	static World Map() {
		return map;
	}
}

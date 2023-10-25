import javax.swing.JFrame;
import src.iteso.game.*;
public class main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//la pantalla se mantiene abirta hasta que se cierre
		window.setResizable(false);// EL TAMANO NUNCA PUEDE VOLVERSE A CAMBIAR
		window.setTitle("The Legend Of Zelda");//crea el nombre de la pestana

		
		GamePanel gamepanel = new GamePanel();
		window.add(gamepanel);// porque es una calse hija te deja agregarla
		
		window.pack();//checa las configutracion y lo acomoda para que tnegna el alyout de los subcomponesntes de GamePanel
		
		
		window.setLocationRelativeTo(null);//mostrar en el centro del juego
		window.setVisible(true);// se pueda ver
		
		
		gamepanel.startGame();
	}

}

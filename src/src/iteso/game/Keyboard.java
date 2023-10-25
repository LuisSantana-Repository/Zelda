package src.iteso.game;
import java.awt.event.*;

public class Keyboard implements KeyListener{
	private boolean W,A,S,D,Enter,Attack,Item;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			W=true;
		}
		if (code == KeyEvent.VK_A) {
			A=true;
		}
		if (code == KeyEvent.VK_S) {
			S=true;
		}
		if (code == KeyEvent.VK_D) {
			D=true;
		}
		if (code == KeyEvent.VK_N) {
			Attack=true;
		}
		if (code == KeyEvent.VK_M) {
			Item=true;
		}
		if (code == KeyEvent.VK_ENTER) {
			Enter=true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			W=false;
		}
		if (code == KeyEvent.VK_A) {
			A=false;
		}
		if (code == KeyEvent.VK_S) {
			S=false;
		}
		if (code == KeyEvent.VK_D) {
			D=false;
		}
		if (code == KeyEvent.VK_N) {
			Attack=false;
		}
		
	}

	public boolean isW() {
		return W;
	}

	public void setW(boolean w) {
		W = w;
	}

	public boolean isA() {
		return A;
	}

	public void setA(boolean a) {
		A = a;
	}

	public boolean isS() {
		return S;
	}

	public void setS(boolean s) {
		S = s;
	}

	public boolean isD() {
		return D;
	}

	public void setD(boolean d) {
		D = d;
	}

	public boolean isEnter() {
		return Enter;
	}

	public void setEnter(boolean enter) {
		Enter = enter;
	}

	public boolean isAttack() {
		return Attack;
	}

	public void setAttack(boolean attack) {
		Attack = attack;
	}

	public boolean isItem() {
		return Item;
	}

	public void setItem(boolean item) {
		Item = item;
	}
	
	
	
	

}

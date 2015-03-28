import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

//Rectangle nos ayuda a detectar las colisiones entre la raqueta y la pelota.

public class Raqueta {
	private static final int Y = 330;
	private static final int ANCHO = 60;
	private static final int ALTURA = 10;
	//static finale para definir una contastante las cuales se declaran en mayuscula.
	int x = 0;
	int xa = 0;
	private Juego juego;

	
	
	public Raqueta(Juego juego) {
		this.juego = juego;
	}

	public void mover() {
		if (x + xa > 0 && x + xa < juego.getWidth() - ANCHO)
			//Evita que la raqueta salga de la pantalla.
			//Ancho, el ancho de la raqueta.
			//getWidth() ancho de la pantalla
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, ANCHO, ALTURA);
		//La forma de la raqueta, rectangulo de 60 x 10.
		
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -juego.velocidad;
		//se movera a la izquierda
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = juego.velocidad;
		//se movera a la derecha
	}

	public Rectangle getLimites() {
		//Este metodo indica los limites de la raqueta para poder detectar la colision de esta con la pelota.
		return new Rectangle(x, Y, ANCHO, ALTURA);
	}

	public int getTopY() {
		return Y;
	}
	//regresa a la posicion inicial
}
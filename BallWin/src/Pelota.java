import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.RenderingHints;


//Rectangle nos ayuda a detectar las colisiones entre la pelota y la raqueta.

public class Pelota {
	private static final int DIAMETRO = 20;
	//static finale para definir una contastante las cuales se declaran en mayuscula.
	int x = 0;
	int y = 0;
	//x & y son variables de posicionamiento para la pelota
	int xa = 1;
	//la pelota se mueve a la derecha, cuando esta valga -1 se mueve a la izquierda
	int ya = 1;
	//la pelota se mueve hacia abajo, cuando sea -1 se mueve hacia arriba
	//xa & ya son variables que dan la velocidad y direccion que se incrementa 1 cada vez que se mueve la pelota.
	private Juego juego;
	
	
	public Pelota(Juego juego) {
		this.juego= juego;

	}

	void mover() throws InterruptedException {
		boolean cambiarDireccion = true;
		
		if (x + xa < 0)
			xa = juego.velocidad;
		else if (x + xa > juego.getWidth() - DIAMETRO)
			//Condicion del margen superior.
			//getWidth() ancho de la pantalla.
			xa = -juego.velocidad;
		else if (y + ya < 0)
			ya = juego.velocidad;
		else if (y + ya > juego.getHeight() - DIAMETRO)
			//Condicion del margen inferior.
			//getHeight() alto de la pantalla.
			 
			juego.Perdiste();
		//Si la condicion se cumple, se termina el juego.
		else if (Colision()){
			ya = -juego.velocidad;
			y = juego.raqueta.getTopY() - DIAMETRO;
			//Posicion de la parte superior de la raqueta y se posiciona Y por encima de la pelota. 
			juego.velocidad++;
		} else 
			cambiarDireccion = true;
		
		if (cambiarDireccion)
			x = x + xa;
		y = y + ya;
	}

	
	private boolean Colision() {
		return juego.raqueta.getLimites().intersects(getLimites());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETRO, DIAMETRO);
		// imprime un ovalo (la pelota) de un diametro (variable DIAMETER) de 30 x 30
		g.setColor(Color.blue);
		//Color de la raqueta.
	}
	
	public Rectangle getLimites() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
		
		
	}
}
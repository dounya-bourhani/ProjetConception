package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

public final class Projectile{
	private double x;
	private double y;
	private double vitesse;
	private double direction;
	private Image representation;
	private GraphicsContext gc;

	private static Projectile instance = null;
	

	private Projectile(GraphicsContext gcParent, double xInitial, double yInitial, double directionInitiale){
		gc = gcParent;
		vitesse = 1;
		representation = new Image("assets/ball.png");
		x = xInitial;
		y = yInitial;
		direction = directionInitiale;
	}

	public static Projectile getInstance(GraphicsContext gcP, double xInit, double yInit, double directionInit) {
		if (instance == null) {
			instance = new Projectile(gcP, xInit, yInit, directionInit);
		}
		return instance;
	}
	/**
	 * Gére les modifications du modèle
	 */
	public void controlleur(){
		x = x + vitesse * Math.cos(Math.toRadians(direction));
		y = y + vitesse * Math.sin(Math.toRadians(direction));
		vue();
	}

	private void vue(){
		gc.drawImage(representation, x, y);
	}
}
//isparent bounding si les deux rectangle se touche alors tuer
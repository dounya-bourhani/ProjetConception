package fr.icom.info.m1.balleauprisonnier_mvn;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.Random;
import java.util.ArrayList;
/**
 * 
 * Classe gerant un joueur
 *
 */
public class Player 
{
	  // position horizontale du joueur
	  private double x;
	  // Largeur du terrain :
	  private final int largeurTerrain;
      // position verticale du joueur
	  private final double y;
      // Rotation du joueur (devrait toujours être en 0 et 180) :
	  private double angle = 90;
	  // Pas d'un joueur
	  private double step;
	  // Couleurs possibles
	  public enum typeJoueur {BLUE, RED, SKELETON, ORC};
	  // Orientations possibles
	  public enum orientation {HAUT, BAS};
	  // Orientation
	  private orientation orientationActuelle;
	  // Couleur du joueur :
	  private typeJoueur typeDeJoueur;
	  // Un projectile vient d'être tiré
	  private boolean tirEnCours;

	  // On une image globale du joueur
	  private Image directionArrow;
	  protected Sprite sprite;
	  private ImageView PlayerDirectionArrow;
	  Image tilesheetImage;
	  
	  private GraphicsContext graphicsContext;
	  
	  /**
	   * Constructeur du Joueur
	   * 
	   * @param gc ContextGraphic dans lequel on va afficher le joueur
	   * @param type couleur du joueur
	   * @param yInit position verticale
	   * @param orientationInitiale Orientation du joueur
	   * @param largeurPlateau Largeur du terrain
	   * @param vitesse Vitesse du joueur
	   * @param xInit Position initiale du joueur en largeur du terrain
	   */
	  public Player(GraphicsContext gc, typeJoueur type, int xInit, int yInit,orientation orientationInitiale,int largeurPlateau, double vitesse)
	  {
		// Tous les joueurs commencent au centre du canvas, 
	    x = xInit;               
	    y = yInit;
	    graphicsContext = gc;
	    typeDeJoueur=type;
	    largeurTerrain = largeurPlateau;
	    orientationActuelle = orientationInitiale;
	    tirEnCours = false;
	    angle = 0;

	    // On charge la representation du joueur
	  	switch(orientationActuelle){
			case HAUT:
				directionArrow = new Image("resources/assets/PlayerArrowDown.png");
				break;
		  	case BAS:
				directionArrow = new Image("resources/assets/PlayerArrowUp.png");
		  		//directionArrow = new Image("C:\\Users\\bourh\\Cours\\CoursM1\\Conception_Agile_de_Projet\\Projet\\Projet\\ProjetConception\\src\\main\\resources\\assets\\PlayerArrowUp.png");
				break;
	  }
        PlayerDirectionArrow = new ImageView();
        PlayerDirectionArrow.setImage(directionArrow);
        PlayerDirectionArrow.setFitWidth(10);
        PlayerDirectionArrow.setPreserveRatio(true);
        PlayerDirectionArrow.setSmooth(true);
        PlayerDirectionArrow.setCache(true);

	  	switch(typeDeJoueur){
			  case BLUE :
			  	tilesheetImage = new Image("resources/assets/PlayerBlue.png");
				  break;
			  case RED :
			  	tilesheetImage = new Image("resources/assets/PlayerRed.png");
			  	break;
			  case SKELETON :
			  	tilesheetImage = new Image("resources/assets/skeleton.png");
			  	break;
			  case ORC :
			  	tilesheetImage = new Image("resources/assets/orc.png");
			  	break;
			  default:
			  	tilesheetImage = new Image("resources/assets/orc.png");
			  	break;
	  }


        sprite = new Sprite(tilesheetImage, 0,0, Duration.seconds(.2), orientationActuelle);
        sprite.setX(x);
        sprite.setY(y);
        //directionArrow = sprite.getClip().;

	    // Tous les joueurs ont une vitesse aleatoire entre 0.0 et 1.0
        //Random randomGenerator = new Random();
        step = vitesse;

	  }

	  /*
	  public Player(GraphicsContext gc, typeJoueur type, int xInit, int yInit, orientation orientationInitiale, int largeurPlateau){
	  	this(gc, type, xInit, yInit, orientationInitiale, largeurPlateau, Math.random()*(1.0-0.0));
	  }
	  */

	  //  Affichage de la flèche
	  private void affichageFleche(){
		graphicsContext.save(); // saves the current state on stack, including the current transform
		rotate(graphicsContext, angle, x + directionArrow.getWidth() / 2, y + directionArrow.getHeight() / 2);
		graphicsContext.drawImage(directionArrow, x, y);
		graphicsContext.restore(); // back to original state (before rotation)
		}

		// Gestion de la rotation de la flèche
	  private void rotate(GraphicsContext gc, double angle, double px, double py){
		Rotate r = new Rotate(angle, px, py);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy()-sprite.getHauteurCellule()/2.0);
		}

	  /**
	   *  Affichage du joueur
	   */
//	  void display()
//	  {
//		  graphicsContext.save(); // saves the current state on stack, including the current transform
//	      rotate(graphicsContext, angle, x + directionArrow.getWidth() / 2, y + directionArrow.getHeight() / 2);
//		  graphicsContext.drawImage(directionArrow, x, y);
//		  graphicsContext.restore(); // back to original state (before rotation)
//	  }

	  
	  /**
	   *  Deplacement du joueur vers la gauche, on cantonne le joueur sur le plateau de jeu
	   */
	 
	  private void moveLeft()
	  {	    
	    if (x > 10 && x < 520) 
	    {
			spriteAnimate();
		    x -= step;
	    }
	  }

	  /**
	   *  Deplacement du joueur vers la droite
	   */
	  private void moveRight()
	  {
	    if (x > 10 && x < 520) 
	    {
			spriteAnimate();
		    x += step;
	    }
	  }

	  
	  /**
	   *  Rotation du joueur vers la gauche
	   */
	  private void turnLeft()
	  {
	    if (angle > 0 && angle < 180) 
	    {
	    	angle += 1;
	    }
	    else {
	    	angle += 1;
	    }

	  }

	  
	  /**
	   *  Rotation du joueur vers la droite
	   */
	  private void turnRight()
	  {
	    if (angle > 0 && angle < 180) 
	    {
	    	angle -=1;
	    }
	    else {
	    	angle -= 1;
	    }
	  }


	  private void shoot(){
	  	sprite.playShoot();
	  }
	  
	  /**
	   *  Deplacement en mode boost
	   */
//	  void boost()
//	  {
//	    x += step*2;
//		  spriteAnimate();
//	  }

	  void spriteAnimate(){
	  	  //System.out.println("Animating sprite");
		  if(!sprite.isRunning) {sprite.playContinuously();}
		  sprite.setX(x);
		  sprite.setY(y);
	  }

	  public boolean controlleur(ArrayList<String> input, Field.equipes equipe){
	  	boolean shoot = false;
		switch(equipe){
			case UNE:
				if(input.contains("Q")){
					moveLeft();
				}
				if(input.contains("D")){
					moveRight();
				}
				if(input.contains("Z")){
					turnLeft();
				}
				if(input.contains("S")){
					turnRight();
				}
				if(input.contains("SPACE") && !tirEnCours){
					shoot();
					shoot = true;
					tirEnCours = true;
				}else if(!input.contains("SPACE")){
					tirEnCours = false;
				}
				break;
			case DEUX:
				if(input.contains("LEFT")){
					moveLeft();
				}
				if(input.contains("RIGHT")){
					moveRight();
				}
				if(input.contains("UP")){
					turnLeft();
				}
				if(input.contains("DOWN")){
					turnRight();
				}
				if(input.contains("ENTER") && !tirEnCours){
					shoot();
					shoot =  true;
					tirEnCours = true;
				}else if(!input.contains("ENTER")){
					tirEnCours = false;
				}
				break;
		}
		this.affichageFleche();
		return shoot;
	}
	  /**
	   * @return l'abscisse du joueur.
	   */
		public double getX(){
			return x;
		}

		/**
		 * @return l'ordonée du joueur.
		 */
		public double getY(){
			return y;
		}

		/**
		 * @return l'angle du joueur.
		 */
		public double getAngle(){
			return angle;
		}

		public orientation getOrientation(){
			return orientationActuelle;
		}
}

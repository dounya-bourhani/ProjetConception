package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;


public class IAPlayer extends Player{
	/**
	 * Constructeur du joueur IAplay
	 * @param gc Contexte graphique
	 * @param color couleur du joueur
	 * @param xInit Position initiale du joueur en largeur du terrain
	 * @param yInit Position initiale du joueur en longueur du terrain
	 * @param orientationInitiale Orientation du joueur
	 * @param largeurPlateau Largeur du terrain
	 * @param vitesse Vitesse du joueur
	 */
	public IAPlayer(GraphicsContext gc, typeJoueur color, int xInit, int yInit, Player.orientation orientationInitiale, int largeurPlateau, double vitesse){
		super(gc, color, xInit, yInit, orientationInitiale, largeurPlateau, vitesse); 
	}

	/**
	 * Gére les modifications du modèle à partir des infos de la vue.
	 * @param input Liste des touches en train d'être appuyées.
	 */
	public boolean controlleur(ArrayList<String> input, Field.equipes equipe){
		// Reste statique.
		return false;
	}
}

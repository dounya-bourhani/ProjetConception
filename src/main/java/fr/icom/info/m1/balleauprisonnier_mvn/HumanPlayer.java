package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.canvas.GraphicsContext;

public class HumanPlayer extends Player {
    /**
     * Constructeur du Joueur
     *
     * @param gc                  ContextGraphic dans lequel on va afficher le joueur
     * @param type                couleur du joueur
     * @param xInit               Position initiale du joueur en largeur du terrain
     * @param yInit               position verticale
     * @param orientationInitiale Orientation du joueur
     * @param largeurPlateau      Largeur du terrain
     * @param vitesse             Vitesse du joueur
     */
    public HumanPlayer(GraphicsContext gc, typeJoueur type, int xInit, int yInit, orientation orientationInitiale, int largeurPlateau, double vitesse) {
        super(gc, type, xInit, yInit, orientationInitiale, largeurPlateau, vitesse);
    }
}

package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.canvas.GraphicsContext;

public interface PlayerFactoryIF {

    Player createPlayer(GraphicsContext gc, Player.typeJoueur type, int xInit, int yInit, Player.orientation orientationInitiale, int largeurPlateau, double vitesse);

}

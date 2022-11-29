package fr.icom.info.m1.balleauprisonnier_mvn;

import javafx.scene.canvas.GraphicsContext;

public class PlayerFactory implements PlayerFactoryIF {

    @Override
    public Player createPlayer(GraphicsContext gc, Player.typeJoueur type, int xInit, int yInit, Player.orientation orientationInitiale, int largeurPlateau, double vitesse) {
        Player player;
        switch (type) {
            case BLUE:
            case RED:
                player = new HumanPlayer(gc, type, xInit, yInit, orientationInitiale, largeurPlateau, vitesse);
                break;
            case ORC:
            case SKELETON:
                player = new IAPlayer(gc, type, xInit, yInit, orientationInitiale, largeurPlateau, vitesse);
                break;
            default:
                throw new RuntimeException("Type " + type + " pas reconnu");
        }
        return player;
    }
}

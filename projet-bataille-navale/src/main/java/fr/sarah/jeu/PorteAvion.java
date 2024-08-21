package fr.sarah.jeu;

public class PorteAvion extends Bateau {

    public PorteAvion(int ligne, int colonne, boolean vertical) {
        super(ligne, colonne, 4, vertical, Case.PORTEAVION);
    }
}

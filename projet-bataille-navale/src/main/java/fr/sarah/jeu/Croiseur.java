package fr.sarah.jeu;

public class Croiseur extends Bateau {
    public Croiseur(int ligne, int colonne, boolean vertical) {
        super(ligne, colonne, 3, vertical, Case.CROISEUR);
    }
}

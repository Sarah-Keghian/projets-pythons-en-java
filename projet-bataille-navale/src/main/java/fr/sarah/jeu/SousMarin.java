package fr.sarah.jeu;

public class SousMarin extends Bateau {
    public SousMarin(int ligne, int colonne, boolean vertical) {
        super(ligne, colonne, 2, vertical, Case.SOUSMARIN);
    }
}

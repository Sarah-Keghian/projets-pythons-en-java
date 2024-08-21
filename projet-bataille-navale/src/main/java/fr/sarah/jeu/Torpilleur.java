package fr.sarah.jeu;

public class Torpilleur extends Bateau {

    public Torpilleur(int ligne, int colonne, boolean vertical){
        super(ligne, colonne, 2, vertical, Case.TORPILLEUR);
    }
}

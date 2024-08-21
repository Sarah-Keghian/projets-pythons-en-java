package fr.sarah.main;

import fr.sarah.jeu.Bateau;
import fr.sarah.jeu.Case;
import fr.sarah.jeu.Couple;
import fr.sarah.jeu.Grille;

public class MainFonctionnalite {
    public static void main(String[] args) {
        Grille grille = new Grille(5,7);
        Bateau b = new Bateau(5,6,2, Case.BATEAU);
//        grille.tirer(0,1);
        grille.ajouter(b);
        System.out.println(b.positions());
        System.out.println(grille);

//        Couple c2 = new Couple(5,6);
//        Couple c = new Couple(5,6);
//        System.out.println(c.hashCode());
//        System.out.println(c2.hashCode());

                    }
}

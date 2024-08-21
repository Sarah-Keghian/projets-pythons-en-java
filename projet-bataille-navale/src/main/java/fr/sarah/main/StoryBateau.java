package fr.sarah.main;

import fr.sarah.jeu.Bateau;
import fr.sarah.jeu.Case;
import fr.sarah.jeu.Couple;

public class StoryBateau {
    public static void main(String[] args) {

        Bateau bateau1 = new Bateau(2, 1, 3, Case.BATEAU);
        Bateau bateau2 = new Bateau(1, 1, 2, true, Case.BATEAU);
        boolean chevauche = false;

        if (bateau1.chevauche(bateau2)) {
            System.out.println("Les bateaux se chevauchent");
        }
            else {
            System.out.println("Les bateaux ne se chevauchent pas");
        }
    }
}

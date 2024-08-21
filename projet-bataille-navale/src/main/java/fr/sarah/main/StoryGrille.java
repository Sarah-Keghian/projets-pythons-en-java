package fr.sarah.main;

import fr.sarah.jeu.Grille;

import java.util.Scanner;

public class StoryGrille {
    public static void main(String[] args) {
        Grille grille = new Grille(5,8);
        System.out.println(grille);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle coordonée en x ? ");
        int x = scanner.nextInt() - 1;
        System.out.println("Quelle coordonnée en y ? ");
        int y = scanner.nextInt() - 1 ;
        scanner.close();

        grille.tirer(x,y);
        System.out.println(grille);
    }
}

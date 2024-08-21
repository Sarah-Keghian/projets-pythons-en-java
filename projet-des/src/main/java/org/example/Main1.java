package org.example;
import classeDe.De;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Quelle valeur voulez-vous donner au dé ? ");
        int valeurInitiale = scanner.nextInt();
        System.out.print("Pour quelle valeur voulez-vous arrêter le dé ? ");
        int valeurFinale = scanner.nextInt();
        scanner.close();

       De d1 = new De(valeurInitiale);
       int compteur = 0;
       while (d1.getPosition() != valeurFinale) {
           compteur++;
           System.out.println(d1.lancer().getPosition());
       }
       System.out.println("Cela a pris " + compteur + " lancers");
    }
}
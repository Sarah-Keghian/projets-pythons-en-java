package org.user_stories;
import org.cartes.Carte;

import java.util.ArrayList;
import java.util.Random;

public class Voyance {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Carte> paquet = Carte.creerPaquet();
        ArrayList<Carte> petiteMain = new ArrayList<Carte>(); // Création d'une petite main pour contenir les 3 cartes choisies au hasard

        for (int i=0; i<=2; i++) {
            int indiceAleatoire = rand.nextInt(paquet.size());
            petiteMain.add(paquet.get(indiceAleatoire));
            paquet.remove(indiceAleatoire);
        }
        System.out.println(paquet);
        System.out.println(petiteMain);

    }
}

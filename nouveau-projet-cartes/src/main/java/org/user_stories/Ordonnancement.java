package org.user_stories;
import org.cartes.Carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static java.util.Collections.copy;

public class Ordonnancement {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Carte> paquet = Carte.creerPaquet();
        ArrayList<Carte> mainNonTriee = new ArrayList<>();
        ArrayList<Carte> mainTriee = new ArrayList<>();

        for (int i=0; i<10; i++){ // Creation de la main de 10 cartes au hasard
            int indiceCarteAleatoire = rand.nextInt(paquet.size());
            mainNonTriee.add(paquet.get(indiceCarteAleatoire));
            paquet.remove(indiceCarteAleatoire);

        }
        System.out.println("main non triée" + mainNonTriee);
        mainTriee.addAll(mainNonTriee);
        Collections.sort(mainTriee);
        System.out.println("main triée" + mainTriee);
        Carte c = mainTriee.get(0);
    }
}

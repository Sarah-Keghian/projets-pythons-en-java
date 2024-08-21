package org.example;
import org.cartes.Carte;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Carte> paquet = Carte.creerPaquet();
        ArrayList<Carte> defausse1 = new ArrayList<>();
        ArrayList<Carte> defausse2 = new ArrayList<>();
        ArrayList<Carte> pioche1 = new ArrayList<>(paquet.size()/2);
        ArrayList<Carte> pioche2 = new ArrayList<>(paquet.size()/2);

        Carte.melanger(paquet);
        for (int j = 0; j < paquet.size()/2; j++) {
            pioche1.add(paquet.get(j));
        }
        for (int k = paquet.size()/2; k < paquet.size(); k++) {
            pioche2.add(paquet.get(k));
        }

        Scanner scanner = new Scanner(System.in); // Demande à l'utilisateur le nombre max de tours
        System.out.println("Choisissez le nombre maximal de tour à faire : ");
        int nombreMaxTours = scanner.nextInt();
        scanner.close();
        int N = 0;

        while (N < nombreMaxTours || pioche1.isEmpty() || pioche2.isEmpty()){
            Carte carte1 = pioche1.getLast();
            pioche1.remove(carte1);
            Carte carte2 = pioche2.getLast();
            pioche2.remove(carte2);
            if (carte1.compareTo(carte2) > 0 ){
                defausse1.add(carte1);
                defausse1.add(carte2);
            }
            else {
                defausse2.add(carte2);
                defausse2.add(carte1);
            }

            if (pioche1.isEmpty()){
                pioche1.addAll(defausse1);
                defausse1.clear();
                Carte.melanger(pioche1);
            } else if (pioche2.isEmpty()) {
                pioche2.addAll(defausse2);
                defausse2.clear();
                Carte.melanger(pioche2);
            }
            N++;
        }
        if (pioche1.size() + defausse1.size() == pioche2.size() + defausse2.size()){
            System.out.println("Egalité");
        } else if (pioche1.size() + defausse1.size() > pioche2.size() + defausse2.size()) {
            System.out.println("Joueur 1 a gagné");
        } else {
            System.out.println("Joueur 2 a gagné");
        }
    }
}
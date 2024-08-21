package fr.sarah.main;
import fr.sarah.jeu.*;
import java.util.Random;

import java.util.ArrayList;

public class    Main {
    static ArrayList<Couple> positionSurGrille(Grille g){
        ArrayList<Couple> res = new ArrayList<>();
        for (int l=0; l<g.getNombreLignes(); l++){
            for (int c=0; c<g.getNombreColonnes(); c++){
                res.add(new Couple(l,c));
            }
        }
        return res;
    }
//    static ArrayList<Couple> positionsPossibles(Bateau bateau, Grille g){
//        int longueur = bateau.getLongueur();
//        ArrayList<Couple> res = positionSurGrille(g);
//        for (int l=0; l<g.getNombreLignes(); l++){
//            res.remove();
//        }
//        g.getNombreColonnes() - longueur + 1
//        return null;
//    }

    public static void main(String[] args) {
        Grille grille = new Grille(8,10);
        ArrayList<Bateau> bateaux = new ArrayList<>();
        Random random = new Random();

        int i = random.nextInt(1,grille.getNombreLignes()+1);
        int j = random.nextInt(1,grille.getNombreColonnes()+1);
        boolean verti = random.nextBoolean();
        PorteAvion p = new PorteAvion(i,j,verti);

        while (!grille.estDansGrille(p)){
            i = random.nextInt(1,grille.getNombreLignes()+1);
            j= random.nextInt(1,grille.getNombreColonnes()+1);
            verti = random.nextBoolean();
            p = new PorteAvion(i,j,verti);
        }
        bateaux.add(p);
        grille.ajouter(p);

        System.out.println(grille);

        Croiseur c = new Croiseur(i,j,verti);

        while (!grille.estDansGrille(new Croiseur(i,j,verti)) || bateaux.get(0).chevauche(c)) {
            i = random.nextInt(1, grille.getNombreLignes() + 1);
            j = random.nextInt(1, grille.getNombreColonnes() + 1);
            verti = random.nextBoolean();
            c = new Croiseur(i,j,verti);
        }
        bateaux.add(c);
        grille.ajouter(c);

        System.out.println(grille);

    }
}

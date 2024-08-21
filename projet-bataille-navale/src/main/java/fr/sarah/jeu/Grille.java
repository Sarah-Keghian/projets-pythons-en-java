package fr.sarah.jeu;

import java.util.ArrayList;

public class Grille {
    ArrayList<Case> matrice;
    int nombreColonnes;
    int nombreLignes;

    public Grille(int nombre_lignes, int nombre_colonnes){
        this.matrice = new ArrayList<>(nombre_colonnes * nombre_lignes);
        for (int i = 0; i < nombre_colonnes*nombre_lignes; i++){
            this.matrice.add(Case.VIDE);
        }
        this.nombreColonnes = nombre_colonnes;
        this.nombreLignes = nombre_lignes;
    }

    // ACCESSEURS
    public int getNombreColonnes(){
        return this.nombreColonnes;
    }
    public int getNombreLignes(){
        return this.nombreLignes;
    }
    public ArrayList<Case> getMatrice(){
        return this.matrice;
    }
    public int size(){
        return this.matrice.size();
    }

    // AFFICHAGE
    @Override
    public String toString(){
        String res = "  ";
        for (int k = 1; k <= this.nombreColonnes; k++){
            res += String.valueOf(k) + "  ";
        }
        res += "\n";

        for (int l = 0; l < this.nombreLignes; l++){
            res += String.valueOf(l+1) + " ";
            for (int c = 0; c < this.nombreColonnes; c++) {
                res += this.matrice.get(l*nombreColonnes + c).affichage + " ";
            }
            res += "\n";
        }
        return res;
    }

    // FONCTIONNALITE JEU : TIRER
    public void tirer(int ligne, int colonne) {
        this.matrice.set((ligne-1) * this.nombreColonnes + (colonne-1), Case.TIRE);
    }
    public boolean estDansGrille(Bateau bateau){
        for (Couple couple : bateau.positions()){
            int indiceMatrice = couple.get(0)*this.nombreColonnes + couple.get(1);
            if (indiceMatrice >= this.size() || indiceMatrice < 0){
                return false;
            }
        }
        return true;
    }
    public void ajouter(Bateau bateau){

        if (!this.estDansGrille(bateau)){
            System.out.println("Le bateau ne rentre pas dans la grille");
        }
        else {
            for (Couple couple : bateau.positions()){
                int l = couple.get(0);
                int c = couple.get(1);
                this.matrice.set(l * nombreColonnes + c, bateau.representation);
            }
        }

    }
}

package fr.sarah.jeu;

import java.util.ArrayList;

public class Bateau {

    protected int ligne;
    protected int colonne;
    protected int longueur;
    protected boolean vertical;
    Case representation = Case.BATEAU;

    // CONSTRUCTEURS
    public Bateau(int ligne, int colonne, int longueur, boolean vertical, Case representation) {
        this.ligne = ligne-1;
        this.colonne = colonne-1;
        this.longueur = longueur;
        this.vertical = vertical;
        this.representation = representation;
    }
    public Bateau(int ligne, int colonne, int longueur, Case representation) {
        this.ligne = ligne-1;
        this.colonne = colonne-1;
        this.longueur = longueur;
        this.vertical = false;
        this.representation = representation;
    }
    public Bateau(int ligne, int colonne, boolean vertical, Case representation) {
        this.ligne = ligne-1;
        this.colonne = colonne-1;
        this.longueur = 1;
        this.vertical = vertical;
        this.representation = representation;
    }
    public Bateau(int ligne, int colonne, Case representation) {
        this.ligne = ligne-1;
        this.colonne = colonne-1;
        this.longueur = 1;
        this.vertical = false;
        this.representation = representation;
    }

    // ACCESSEURS
    public int getLigne() {
        return this.ligne;
    }
    public int getColonne() {
        return this.colonne;
    }
    public int getLongueur() {
        return this.longueur;
    }
    public boolean isVertical() {
        return this.vertical;
    }

    // AUTRES
    public ArrayList<Couple> positions(){
        ArrayList<Couple> posi = new ArrayList<>();
        if (this.vertical) {
            for (int k=0; k<this.longueur; k++){
                posi.add(new Couple(this.ligne+k, this.colonne));
            }
        } else {
            for (int k=0; k<this.longueur; k++){
                posi.add(new Couple(this.ligne, this.colonne+k));
            }
        }
        return posi;
    }

    public boolean coule(Grille grille){
        for (Couple couple : this.positions()){
            int ligne = couple.get(0);
            int colonne = couple.get(1);
            if (grille.getMatrice().get(ligne * grille.getNombreColonnes() + colonne) != Case.TIRE){
                return false;
            }
        }
        return true;
    }
    public boolean chevauche(Bateau autre){
        boolean res = false;
        for (Couple couple1 : this.positions()){
            for (Couple couple2 : autre.positions()){
                if (couple1.equals(couple2)){
                    res = true;
                }
            }
        }
        return res;
    }
}

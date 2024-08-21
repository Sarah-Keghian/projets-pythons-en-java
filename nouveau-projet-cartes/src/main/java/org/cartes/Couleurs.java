package org.cartes;

public enum Couleurs {
    TREFLE("trèfle", 0),
    CARREAU("carreau", 1),
    COEUR("coeur", 2),
    PIQUE("pique", 3);

    public final String nom;
    public final int ordre;

    private Couleurs(String nom, int ordre) {
        this.nom = nom;
        this.ordre = ordre;
    }
}

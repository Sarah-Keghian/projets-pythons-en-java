package org.cartes;

public enum Valeurs {
    SEPT("sept", 0),
    HUIT("huit", 1),
    NEUF("neuf", 2),
    DIX("dix", 3),
    VALET("valet", 4),
    DAME("dame", 5),
    ROI("roi", 6),
    AS("as", 7);

    public final String nom;
    public final int ordre;
    Valeurs(String nom, int ordre){
        this.nom = nom;
        this.ordre = ordre;
    }
}

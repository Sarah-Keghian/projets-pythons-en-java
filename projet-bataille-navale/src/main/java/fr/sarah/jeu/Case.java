package fr.sarah.jeu;

public enum Case {
    VIDE("∿ "),
    TIRE("x "),
    BATEAU("⛵"),
    PORTEAVION("🚢"),
    CROISEUR("⛴"),
    TORPILLEUR("🚣"),
    SOUSMARIN("sm");

    public final String affichage;

    Case(final String affichage) {
        this.affichage = affichage;
    }
}

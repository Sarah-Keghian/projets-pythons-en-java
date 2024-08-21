package org.cartes;
import java.util.ArrayList;
import java.util.Random;

public class Carte implements Comparable<Carte>{

    public static final String SEPT = "sept";
    public static final String HUIT = "huit";
    public static final String NEUF = "neuf";
    public static final String DIX = "dix";
    public static final String VALET = "valet";
    public static final String DAME = "dame";
    public static final String ROI = "roi";
    public static final String AS = "as";

    public static final String COEUR = "coeur";
    public static final String CARREAU = "carreau";
    public static final String PIQUE = "pique";
    public static final String TREFLE = "trèfle";

    public static final String[] VALEURS = {SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI, AS};
    public static final String[] COULEURS = {TREFLE, CARREAU, COEUR, PIQUE};

    public final Valeurs valeur;
    public final Couleurs couleur;

    public Carte(Valeurs valeur, Couleurs couleur) { // Constructeur de Carte
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public static final ArrayList<Carte> creerPaquet(){
        ArrayList<Carte> paquet = new ArrayList<>(); // Création d'un tableau dynamique de cartes pour représenter le paquet
        for (Valeurs valeur : Valeurs.values()) { // Parcours des valeurs
            for (Couleurs couleur : Couleurs.values()) { //Parcours des couleurs
                paquet.add(new Carte(valeur, couleur)); //Ajout de la carte au paquet
            }
        }
        return paquet;
    }

    public static ArrayList<Carte> melanger(ArrayList<Carte> paquet){
        Random random = new Random();
        ArrayList<Carte> paquetMelange = new ArrayList<>();
        if (paquet.isEmpty()){
            return paquet;
        }
        else {
            for (int i=0; i < paquet.size(); i++){
               int indiceAleatoire1 = random.nextInt(paquet.size());
               paquetMelange.add(paquet.get(indiceAleatoire1));
               paquet.remove(indiceAleatoire1);
               int indiceAleatoire2 = random.nextInt(paquet.size());
               paquetMelange.add(paquet.get(indiceAleatoire2));
               paquet.remove(indiceAleatoire2);
            }
            return paquetMelange;
        }

    }
    @Override
    public int compareTo(Carte other) {
        if (this.valeur.equals(other.valeur) && this.couleur.equals(other.couleur)) { // Si les deux cartes sont égales
            return 0;
        } else if (this.valeur.equals(other.valeur)) { // Si leur valeurs sont egales
            if (this.couleur.ordre < other.couleur.ordre) { // Et si la couleur de this est plus faible que l'autre
                return -1;
            } else { // Si la couleur de this est plus forte que l'autre
                return 1;
            }
        } else { // Si les valeurs des deux cartes sont différentes
            if (this.valeur.ordre < other.couleur.ordre) { // Et si la valeur de this est plus faible que l'autre
                return -1;
            } else { // Si la valeur de this est plus forte que celle de l'autre
                return 1;
            }
        }
    }

    @Override //Surchage d'une méthode déjà existente
    public String toString() { // Affichage de la valeur et couleur de la carte
        return this.valeur.nom + " de " + this.couleur.nom;
    }
}
// TO DO : Mettre les attributs en privé et faire des accesseurs OU EN STATIC FINAL
// TO DO : Faire une interface pour le tri ou autre


package fr.sarah.jeu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {

    @Test
    void test_constructeur_nonNul() {
        Grille grille = new Grille(1, 3);
        assertNotNull(grille);
        assertNotNull(grille.matrice);
        assertInstanceOf(Grille.class, grille);
    }


    @Test
    void test_constructeur_matrice(){
        Grille grille = new Grille(1,3);
        ArrayList<Case> matriceAttendue = new ArrayList<>();
        matriceAttendue.add(Case.VIDE);
        matriceAttendue.add(Case.VIDE);
        matriceAttendue.add(Case.VIDE);

        assertEquals(3, grille.getNombreColonnes());
        assertEquals(matriceAttendue, grille.getMatrice());
    }

//    @Test
//    public void test_toString() {
//        Grille grille = new Grille(2,3);
//        String affichage = "~ ~ ~ \n~ ~ ~ \n";
//        assertEquals(affichage, grille.toString());
//    }

    @Test
    void test_tirer(){
        Grille grille = new Grille(2,3);
        grille.tirer(1,2);
        assertEquals(Case.TIRE, grille.getMatrice().get(0 * grille.getNombreColonnes() + 1));
    }

    @Test
    void test_ajouter(){
        Grille g = new Grille(2,3);
        g.ajouter(new Bateau(2,1,2,false, Case.BATEAU));
        ArrayList<Case> matriceAttendue = new ArrayList<>();
        matriceAttendue.add(Case.VIDE);
        matriceAttendue.add(Case.VIDE);
        matriceAttendue.add(Case.VIDE);
        matriceAttendue.add(Case.BATEAU);
        matriceAttendue.add(Case.BATEAU);
        matriceAttendue.add(Case.VIDE);

        assertEquals(matriceAttendue, g.getMatrice());

        Grille g1 = new Grille(2,3);
        g1.ajouter(new Bateau(1,0,2,true,Case.BATEAU));
        g1.ajouter(new Bateau(1,0,4,true,Case.BATEAU));
        matriceAttendue.set(0, Case.VIDE);
        matriceAttendue.set(1, Case.VIDE);
        matriceAttendue.set(2, Case.VIDE);
        matriceAttendue.set(3, Case.VIDE);
        matriceAttendue.set(4, Case.VIDE);
        matriceAttendue.set(5, Case.VIDE);

        assertEquals(matriceAttendue, g1.getMatrice());
    }

    @Test
    void test_EstDansGrille(){
        Grille g = new Grille(2,3);
        Bateau b1 = new Bateau(2,3,2,false, Case.BATEAU);
        Bateau b2 = new Bateau(1,2,2,true, Case.BATEAU);

        assertFalse(g.estDansGrille(b1));
        assertTrue(g.estDansGrille(b2));

    }
}
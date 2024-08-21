package fr.sarah.jeu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BateauTest {

    @Test
    void test_constructeur1_full_accesseurs() {
        int ligne = 1;
        int colonne = 2;
        int longueur = 3;
        boolean vertical = true;
        Bateau bateau = new Bateau(ligne, colonne, longueur, vertical, Case.BATEAU);
        assertInstanceOf(Bateau.class, bateau);

        assertEquals(ligne-1, bateau.getLigne());
        assertEquals(colonne-1, bateau.getColonne());
        assertEquals(longueur, bateau.getLongueur());
        assertEquals(vertical, bateau.isVertical());

        vertical = false;
        Bateau bateau1 = new Bateau(ligne, colonne, longueur, vertical, Case.BATEAU);
        assertEquals(vertical, bateau1.isVertical());
    }

    @Test
    void test_constructeur2_vertical_defaut(){
        int ligne = 1;
        int colonne = 2;
        int longueur = 3;
        Bateau bateau = new Bateau(ligne, colonne, longueur, Case.BATEAU);
        assertFalse(bateau.isVertical());
        assertEquals(Case.BATEAU, bateau.representation);
    }

    @Test
    void test_constructeur3_longueur_defaut() {
        int ligne = 1;
        int colonne = 2;
        boolean vertical = true;
        Bateau bateau = new Bateau(ligne, colonne, vertical, Case.BATEAU);
        assertEquals(1, bateau.getLongueur());
    }

    @Test
    void test_constructeur4_vertical_longueur_defaut() {
        int ligne = 1;
        int colonne = 2;

        Bateau bateau = new Bateau(ligne, colonne, Case.BATEAU);
        assertEquals(1, bateau.getLongueur());
        assertFalse(bateau.isVertical());
    }

    @Test
    void test_position(){
        int ligne = 3;
        int colonne = 4;
        int longueur = 3;
        Bateau bateau = new Bateau(ligne, colonne, longueur, Case.BATEAU);
        ArrayList<Couple> positionAttendue = new ArrayList<>();
        positionAttendue.add(new Couple(2,3));
        positionAttendue.add(new Couple(2,4));
        positionAttendue.add(new Couple(2,5));

        assertTrue(positionAttendue.get(0).equals(bateau.positions().get(0)));
        assertTrue(positionAttendue.get(1).equals(bateau.positions().get(1)));
        assertTrue(positionAttendue.get(2).equals(bateau.positions().get(2)));

        boolean vertical = true;
        Bateau bateau1 = new Bateau(ligne, colonne, longueur, vertical, Case.BATEAU);
        positionAttendue.set(0, new Couple(2,3));
        positionAttendue.set(1, new Couple(3,3));
        positionAttendue.set(2, new Couple(4,3));

        assertTrue(positionAttendue.get(0).equals(bateau1.positions().get(0)));
        assertTrue(positionAttendue.get(1).equals(bateau1.positions().get(1)));
        assertTrue(positionAttendue.get(2).equals(bateau1.positions().get(2)));
    }

    @Test
    void test_coule(){
        Grille g1 = new Grille(2,3);
        Bateau b1 = new Bateau(1,1,2, Case.BATEAU);
        g1.tirer(1,1);
        g1.tirer(1,2);
        assertTrue(b1.coule(g1));

        Bateau b2 = new Bateau(2,5,2, Case.BATEAU);
        Grille g2 = new Grille(4,8);
        g2.tirer(2,5);
        assertFalse(b2.coule(g2));
    }

    @Test
    void test_PorteAvion(){
        PorteAvion p = new PorteAvion(1,1, false);
        assertEquals(Case.PORTEAVION, p.representation);
        assertEquals(4, p.getLongueur());
    }
    @Test
    void test_Croiseur(){
        Croiseur c = new Croiseur(1,1,true);
        assertEquals(Case.CROISEUR, c.representation);
        assertEquals(3, c.getLongueur());
    }
    @Test
    void test_Torpilleur(){
        Torpilleur t = new Torpilleur(1,1,false);
        assertEquals(Case.TORPILLEUR, t.representation);
        assertEquals(2, t.getLongueur());
    }
    @Test
    void test_SousMarin(){
        SousMarin sm = new SousMarin(1,1,true);
        assertEquals(Case.SOUSMARIN, sm.representation);
        assertEquals(2, sm.getLongueur());
    }

    @Test
    void test_chevauche(){
        Bateau b1 = new Bateau(1,1,1, Case.BATEAU);
        Bateau b2 = new Bateau(1,1,2, true, Case.BATEAU);
        Bateau b3 = new Bateau(3,3,3, Case.BATEAU);
        Bateau b4 = new Bateau(2,1,2, Case.BATEAU);
        assertTrue(b1.chevauche(b2));
        assertFalse(b1.chevauche(b3));
        assertTrue(b2.chevauche(b4));
    }
}
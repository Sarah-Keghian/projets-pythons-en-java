package org.cartes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @Test
    public void test_constructeur() {
        Carte c = new Carte(Valeurs.SEPT, Couleurs.PIQUE);
        assertNotNull(c);
        assertInstanceOf(Carte.class, c);
        assertEquals("sept", Valeurs.SEPT.nom);
        assertEquals("pique", Couleurs.PIQUE.nom);
    }

    @Test
    public void test_toString() {
        Carte c = new Carte(Valeurs.SEPT, Couleurs.PIQUE);
        assertEquals("sept de pique", c.toString());
    }

    @Test
    public void test_compareTo() {
        Carte c1 = new Carte(Valeurs.HUIT, Couleurs.PIQUE);
        Carte c2 = new Carte(Valeurs.SEPT, Couleurs.CARREAU);
        Carte c3 = new Carte(Valeurs.HUIT, Couleurs.COEUR);
        Carte c4 = new Carte(Valeurs.DIX, Couleurs.PIQUE);
        assertTrue(c1.compareTo(c2) > 0);
        assertTrue(c1.compareTo(c3) > 0);
        assertTrue(c1.compareTo(c4) < 0);
        assertEquals(0, c1.compareTo(c1));
    }

    @Test
    public void test_creerPaquet() {
        ArrayList<Carte> paquet = Carte.creerPaquet();
        ArrayList<String> paquetAttendu = new ArrayList<>() {{
            add(new Carte(Valeurs.SEPT, Couleurs.TREFLE).toString());
            add(new Carte(Valeurs.SEPT, Couleurs.CARREAU).toString());
            add(new Carte(Valeurs.SEPT, Couleurs.COEUR).toString());
            add(new Carte(Valeurs.SEPT, Couleurs.PIQUE).toString());

            add(new Carte(Valeurs.HUIT, Couleurs.TREFLE).toString());
            add(new Carte(Valeurs.HUIT, Couleurs.CARREAU).toString());
            add(new Carte(Valeurs.HUIT, Couleurs.COEUR).toString());
            add(new Carte(Valeurs.HUIT, Couleurs.PIQUE).toString());

            add(new Carte(Valeurs.NEUF, Couleurs.TREFLE).toString());
            add(new Carte(Valeurs.NEUF, Couleurs.CARREAU).toString());
            add(new Carte(Valeurs.NEUF, Couleurs.COEUR).toString());
            add(new Carte(Valeurs.NEUF, Couleurs.PIQUE).toString());

            add(new Carte(Valeurs.DIX, Couleurs.TREFLE).toString());
            add(new Carte(Valeurs.DIX, Couleurs.CARREAU).toString());
            add(new Carte(Valeurs.DIX, Couleurs.COEUR).toString());
            add(new Carte(Valeurs.DIX, Couleurs.PIQUE).toString());

            add(new Carte(Valeurs.VALET, Couleurs.TREFLE).toString());
            add(new Carte(Valeurs.VALET, Couleurs.CARREAU).toString());
            add(new Carte(Valeurs.VALET, Couleurs.COEUR).toString());
            add(new Carte(Valeurs.VALET, Couleurs.PIQUE).toString());

            add(new Carte(Valeurs.DAME, Couleurs.TREFLE).toString());
            add(new Carte(Valeurs.DAME, Couleurs.CARREAU).toString());
            add(new Carte(Valeurs.DAME, Couleurs.COEUR).toString());
            add(new Carte(Valeurs.DAME, Couleurs.PIQUE).toString());

            add(new Carte(Valeurs.ROI, Couleurs.TREFLE).toString());
            add(new Carte(Valeurs.ROI, Couleurs.CARREAU).toString());
            add(new Carte(Valeurs.ROI, Couleurs.COEUR).toString());
            add(new Carte(Valeurs.ROI, Couleurs.PIQUE).toString());

            add(new Carte(Valeurs.AS, Couleurs.TREFLE).toString());
            add(new Carte(Valeurs.AS, Couleurs.CARREAU).toString());
            add(new Carte(Valeurs.AS, Couleurs.COEUR).toString());
            add(new Carte(Valeurs.AS, Couleurs.PIQUE).toString());

        }};
        int compteur = 0;
        boolean res = true;
        int longueurAttendue = Valeurs.values().length * Couleurs.values().length;
        for (Carte c : paquet){
            if (paquetAttendu.contains(c.toString())) {
                continue;
            } else {
                res = false;
                break;
            }
        }
        if (paquet.size() != Valeurs.values().length * Couleurs.values().length) {
            res = false;
        }
        assertTrue(res);
        }
}
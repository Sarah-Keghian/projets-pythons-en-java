import classeDe.De;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeTest {
    @Test
    void test_constructeur_vide(){
        var d1 = new De();
        assertEquals(1, d1.getPosition());

    }
    @Test
    void test_constructeur_avec_valeur_et_accesseur(){
        var d1 = new De(4);
        assertEquals(4, d1.getPosition());
    }
    @Test
    void test_lancer(){
        var d1 = new De();
        assertTrue(1 <= d1.lancer().getPosition() & d1.lancer().getPosition() <= 6);
    }
}
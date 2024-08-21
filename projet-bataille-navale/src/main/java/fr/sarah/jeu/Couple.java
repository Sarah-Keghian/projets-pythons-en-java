package fr.sarah.jeu;

import java.util.Arrays;
import java.util.Objects;

public class Couple {
    private final int[] pair;
    public Couple(int entier0, int entier1) {
        this.pair = new int[2];
        pair[0] = entier0;
        pair[1] = entier1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couple couple = (Couple) o;
        return Objects.deepEquals(pair, couple.pair);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pair);
    }

    public int get(int i) {
        return this.pair[i];
    }

    public String toString(){
        return "(" + String.valueOf(this.get(0)) + ", " + String.valueOf(this.get(1)) + ")";
    }
}

package edu.badpals.RomansGoHome;

import java.util.Optional;

public enum RomanNumbers {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int decimal = 0;
    private RomanNumbers(int decimal) {
        this.decimal = decimal;
    }

    public int getDecimal() {
        return decimal;
    }

    public static String[] getNames() {
        RomanNumbers[] states = values();
        String[] names = new String[states.length];

        for (int i = 0; i < states.length; i++) {
            names[i] = states[i].name();
        }

        return names;
    }
}

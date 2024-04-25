package edu.badpals.RomansGoHome;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanRegex {
    private final Pattern romanRegex;

    public RomanRegex() {
        romanRegex = Pattern.compile(String.format("([%s]+)", String.join("", RomanNumbers.getNames())));
    }

    public Matcher matcher(String toMatch) {
        return romanRegex.matcher(toMatch);
    }

    Pattern getRomanRegex() {
        return romanRegex;
    }
}

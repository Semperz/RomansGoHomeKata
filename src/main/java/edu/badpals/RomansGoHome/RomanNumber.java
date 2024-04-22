package edu.badpals.RomansGoHome;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private String romanNumber;
    private Pattern romanRegex = Pattern.compile(String.format("([%s]+)", String.join("", RomanNumbers.getNames()))); // TODO: Code this pattern

    public RomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    public int toDecimal() {
            // TODO: Implement this
        Matcher matcher = romanRegex.matcher(getRomanNumber());
        if (!matcher.find()) {
            return 0;
        }
        System.out.println(matcher.groupCount());
        for (int i = 0; i < matcher.groupCount(); ++i) {
            String currentGroup = matcher.group(i);
            System.out.println(currentGroup);
            System.out.println(RomanNumbers.valueOf(currentGroup).getDecimal());
        }

        return 0;
    }

    @Override
    public String toString() {
        return romanNumber;
    }
}

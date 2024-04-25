package edu.badpals.RomansGoHome;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private final String romanNumber;
    private final Pattern romanRegex = Pattern.compile(String.format("([%s]+)", String.join("", RomanNumbers.getNames()))); // TODO: Code this pattern

    public RomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    private int[] parseRomanStringToInts(String romanString) {
        return romanString.chars().mapToObj(c -> (char) c).mapToInt(numeral -> RomanNumbers.valueOf(Character.toString(numeral)).getDecimal()).toArray();
    }

    private String getAllMatchingGroups() {
        Matcher matcher = romanRegex.matcher(getRomanNumber());
        StringBuilder joinedGroups = new StringBuilder();
        while (matcher.find()) {
            joinedGroups.append(matcher.group());
        }
        return joinedGroups.toString();
    }

    public int toDecimal() {
        int[] parsedData = parseRomanStringToInts(getAllMatchingGroups());
        int total = 0;
        for (int i = 0; i < parsedData.length; ++i){
            if (i + 1 >= parsedData.length) {
                total += parsedData[i];
                break;
            }
            if (parsedData[i] >= parsedData[i +1]){
                total += parsedData[i];
            }else{
                total += parsedData[i + 1] - parsedData[i++];
            }
        }

        return total;
    }

    @Override
    public String toString() {
        return romanNumber;
    }
}

package edu.badpals.RomansGoHome;

import java.util.regex.Matcher;

public class RomanNumber {
    private final String romanNumber;
    private final RomanRegex romanRegex;

    public RomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
        romanRegex = new RomanRegex();
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    public int toDecimal() {
        Integer[] parsedData = parseRomanStringToInts(getAllMatchingGroups());
        int total = 0;
        for (int i = 0; i < parsedData.length; ++i){
            if (i + 1 >= parsedData.length) {
                total += parsedData[i];
                break;
            }
            if (parsedData[i] >= parsedData[i + 1]){
                total += parsedData[i];
            } else {
                total += parsedData[i + 1] - parsedData[i++];
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return romanNumber;
    }

    static Integer[] parseRomanStringToInts(String romanString) {
        return romanString.chars().mapToObj(c -> (char) c).mapToInt(numeral -> RomanNumbers.valueOf(Character.toString(numeral)).getDecimal()).boxed().toArray(Integer[]::new);
    }

    String getAllMatchingGroups() {
        Matcher matcher = romanRegex.matcher(getRomanNumber());
        StringBuilder joinedGroups = new StringBuilder();
        while (matcher.find()) {
            joinedGroups.append(matcher.group());
        }
        return joinedGroups.toString();
    }
}

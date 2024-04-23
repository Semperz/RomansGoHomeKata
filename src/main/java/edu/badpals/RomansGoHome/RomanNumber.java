package edu.badpals.RomansGoHome;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
        int total = 0;
        for (int i = 0; i < matcher.groupCount(); ++i) {
            String currentGroup = matcher.group(i);
            System.out.println(currentGroup);
            int[] parsedData = currentGroup.chars().mapToObj(c -> (char) c).mapToInt(numeral -> RomanNumbers.valueOf(Character.toString(numeral)).getDecimal()).toArray();
            for (int j = 0; j < parsedData.length; ++j){
                if (j + 1 >= parsedData.length) {
                    total += parsedData[j];
                    break;
                }
                if (parsedData[j] >= parsedData[j+1]){
                    total += parsedData[j];
                }else{
                    total += parsedData[j+1] - parsedData[j++];
                }
            }
            System.out.println(Arrays.toString(parsedData));
        }

        return total;
    }

    @Override
    public String toString() {
        return romanNumber;
    }
}

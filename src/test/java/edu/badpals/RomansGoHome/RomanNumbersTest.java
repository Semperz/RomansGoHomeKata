package edu.badpals.RomansGoHome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RomanNumbersTest {
    @Test
    public void correctEnumNamesTest(){
        String[] expectedLetters = {"I", "V", "X", "L", "C", "D", "M"};
        assertArrayEquals(RomanNumbers.getNames(), expectedLetters);
    }
}

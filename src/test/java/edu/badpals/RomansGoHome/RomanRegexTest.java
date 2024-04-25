package edu.badpals.RomansGoHome;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanRegexTest {
    @Test
    public void hasCorrectRegexPatternTest() {
        RomanRegex romanRegex = new RomanRegex();
        Pattern expectedPattern = Pattern.compile("([IVXLCDM]+)");
        assertEquals(romanRegex.getRomanRegex().toString(), expectedPattern.toString());
    }
}

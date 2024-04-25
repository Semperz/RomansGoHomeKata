package edu.badpals.RomansGoHome;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.aggregator.AggregateWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RomanNumberTest {

    public RomanNumber numeroRomano;

    /**
     * Grupos sumatorios M, C, X, I
     */

    @ParameterizedTest
    @CsvSource({
            "1000,  M",
            "2000,  UMMU",
            "3000,  UMMMU"
    })
    @Tag("sumatorio")
    public void grupoMTest(int decimal, String roman) {
        numeroRomano = new RomanNumber(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }

    @ParameterizedTest
    @CsvSource({
            "3300,  UMMMUCCCU",
            "3030,  UMMMUXXXU",
            "3003,  UMMMUIIIU"
    })
    @Tag("sumatorio")
    public void tresRepeticionesTest(int decimalValue, String romanNumber) {
        numeroRomano = new RomanNumber(romanNumber);
        assertEquals(decimalValue, numeroRomano.toDecimal());
    }

    @ParameterizedTest
    @CsvSource({
            "3503,  UMMMUDUIIIU",
            "3403,  MMMUCDUIIIU",
    })
    @Tag("sumatorio")
    public void dTest(int decimalValue, String romanNumber) {
        numeroRomano = new RomanNumber(romanNumber);
        assertEquals(decimalValue, numeroRomano.toDecimal());
    }

    /**
     * Grupos sustractivos
     * IV(4), IX(9),
     * XL(40), XC(90),
     * CD(400), CM(900)
     */
    @ParameterizedTest
    @CsvSource({
            "400,  UCDU",
            "900,  UCMU",
            "40,   UXLU",
            "90,   UXCU",
            "4,    UIVU",
            "9,    UIXU",
            "3888, MMMDCCCLXXXVIII",
            "2777, MMDCCLXXVII",
            "444,  CDXLIV",
            "439,  CDXXXIX"
    })
    @Tag("sustractivo")
    public void sustractivoTest(int decimalValue, String romanNumber) {
        numeroRomano = new RomanNumber(romanNumber);
        assertEquals(decimalValue, numeroRomano.toDecimal());
    }

    @Test
    public void cadenaVaciaTest() {
        String testCase = "";
        numeroRomano = new RomanNumber(testCase);
        assertEquals(0, numeroRomano.toDecimal());
    }

    @ParameterizedTest
    @Tag("parseado")
    @CsvSource({
            "X,    10",
            "IX,   1, 10",
            "CM,   100, 1000"
    })
    public void parseRomanStringToIntsTest(String romanNumber, @AggregateWith(VarargsAggregator.class) Integer... expectedInts) {
        assertArrayEquals(RomanNumber.parseRomanStringToInts(romanNumber), expectedInts);
    }

    /**
     * Test del tipo enumerado
     * RomanSymbols
     */
    @ParameterizedTest
    @Tag("enumerado")
    @CsvSource({
            "5,   V",
            "4,   IV",
            "900, CM"
    })
    public void valorDecimalTest(int decimal, String roman) {
        numeroRomano = new RomanNumber(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }
}

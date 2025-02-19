package dat102;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParentesSjekkerTest {

    
    @Test
    public void testKorrektParenteser() {
        assertTrue(ParentesSjekker.sjekkParenteser("{ [ ( ) ] }"));
    }

    @Test
    public void testKunKrøllParenteser() {
        assertTrue(ParentesSjekker.sjekkParenteser("{}"));
    }

    @Test
    public void testKunFirkantParenteser() {
        assertTrue(ParentesSjekker.sjekkParenteser("[]"));
    }

    @Test
    public void testKunVanligeParenteser() {
        assertTrue(ParentesSjekker.sjekkParenteser("()"));
    }

    @Test
    public void testKodeMedKorrektParenteser() {
        String javaprogram = """
        class HelloWorld {
            public static void main(String[] args) {
                System.out.println("Hello World!");
            }
        }
        """;
        assertTrue(ParentesSjekker.sjekkParenteser(javaprogram));
    }

    
    @Test
    public void testManglerSluttParentes() {
        assertFalse(ParentesSjekker.sjekkParenteser("{ [ ( ) }"));
    }

    @Test
    public void testManglerStartParentes() {
        assertFalse(ParentesSjekker.sjekkParenteser("[ ( ) ] }"));
    }

    @Test
    public void testFeilRekkefølge() {
        assertFalse(ParentesSjekker.sjekkParenteser("{ [ ( ] ) }"));
    }

    @Test
    public void testFeilKombinasjonAvParenteser() {
        assertFalse(ParentesSjekker.sjekkParenteser("{ ( ] }"));
    }

    @Test
    public void testKunStartParentes() {
        assertFalse(ParentesSjekker.sjekkParenteser("{"));
    }

    @Test
    public void testKunSluttParentes() {
        assertFalse(ParentesSjekker.sjekkParenteser("}"));
    }

    @Test
    public void testStartParentesUtenSlutt() {
        assertFalse(ParentesSjekker.sjekkParenteser("[ { ( "));
    }

    @Test
    public void testSluttParentesUtenStart() {
        assertFalse(ParentesSjekker.sjekkParenteser(") ] }"));
    }

    @Test
    public void testTomStreng() {
        assertTrue(ParentesSjekker.sjekkParenteser(""));
    }

    @Test
    public void testBalansertMenFeilRekkefølge() {
        assertFalse(ParentesSjekker.sjekkParenteser(") ("));
    }

    @Test
    public void testBalansertMenMedUgyldigeTegn() {
        assertFalse(ParentesSjekker.sjekkParenteser("{ a + b ( c } ]"));
    }
}
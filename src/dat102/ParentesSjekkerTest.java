package dat102;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParentesSjekkerTest {

    // 🔹 Tester ALLE typer balanserte parenteser
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
    public void testBlandetMedEkstraTegn() {
        assertTrue(ParentesSjekker.sjekkParenteser("{a[b(c)d]e}"));
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

    // 🔹 Tester feil i ulike parenteser
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

    // 🔹 Tester spesifikke scenarier som kan være problematiske
    @Test
    public void testTomStreng() {
        assertTrue(ParentesSjekker.sjekkParenteser(""));
    }

    @Test
    public void testBareStartParentes() {
        assertFalse(ParentesSjekker.sjekkParenteser("{"));
    }

    @Test
    public void testBareSluttParentes() {
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
    public void testBalansertMenFeilRekkefølge() {
        assertFalse(ParentesSjekker.sjekkParenteser(") ("));
    }

    @Test
    public void testBalansertMenMedUgyldigeTegn() {
        assertFalse(ParentesSjekker.sjekkParenteser("{ a + b ( c } ]"));
    }

    // 🔹 Tester for å treffe ALLE branches i koden
    @Test
    public void testBareTilfeldigeTegnUtenParenteser() {
        assertTrue(ParentesSjekker.sjekkParenteser("abcdefg12345"));
    }

    @Test
    public void testBalansertMenEkstraTegnMellomParentesene() {
        assertTrue(ParentesSjekker.sjekkParenteser("{ [a (b c) d] e}"));
    }

    @Test
    public void testStartParentesMenTomStabel() {
        assertFalse(ParentesSjekker.sjekkParenteser("{ [ ] ) }"));
    }

    @Test
    public void testTomStabelOgForsøkPåPop() {
        assertFalse(ParentesSjekker.sjekkParenteser(")"));
    }
}

package dat102;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParentesSjekkerTest {

    @Test
    public void testKorrektParenteser() {
        assertTrue(ParentesSjekker.sjekkParenteser("{ [ ( ) ] }"));
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
    public void testFeilRekkefolge() {
        assertFalse(ParentesSjekker.sjekkParenteser("{ [ ( ] ) }"));
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
}
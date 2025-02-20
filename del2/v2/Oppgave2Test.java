package v2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Oppgave2Test {

	Integer[] tabell = {4, 5, 1, 42, 47, 16, 8, 3, 6, 13};
	
	Integer[] tabellSort = {1, 3, 4, 5, 6, 8, 13, 16, 42, 47};
	
	@Test
	void testInnsetting() {
		SorterTabell.sorterVedInnsetting(tabell);
		assertEquals(Arrays.toString(tabellSort), Arrays.toString(tabell));
	}
	
	@Test
	void testUtvalg() {
		SorterTabell.utvalgssortering(tabell);
		assertEquals(Arrays.toString(tabellSort), Arrays.toString(tabell));
	}
	
	@Test
	void testKvikk() {
		SorterTabell.kvikksorter(tabell);
		assertEquals(Arrays.toString(tabellSort), Arrays.toString(tabell));
	}
	
	@Test
	void testFletting() {
		SorterTabell.flettesortering(tabell);
		assertEquals(Arrays.toString(tabellSort), Arrays.toString(tabell));
	}
	
}

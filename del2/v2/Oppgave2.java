package v2;

import java.util.Random;

public class Oppgave2 {

	public static void main(String[] args) {

		innsettingTid(10);
		System.out.println();
		utvalgTid(10);
		System.out.println();
		kvikkTid(10);
		System.out.println();
		fletteTid(10);
	}

	private static Integer[] Tilfeldig(int n) {
		int[] tempTab = new Random().ints(n, 0, 1000000).toArray();
		Integer[] tab = new Integer[tempTab.length];
		int i = 0;
		for (int value : tempTab) {
			tab[i++] = Integer.valueOf(value);
		}
		return tab;
	}

	private static void innsettingTid(int repitisjoner) {

		Integer[] kortTab = new Integer[32000];
		kortTab = Tilfeldig(kortTab.length);

		Integer[] midTab = new Integer[64000];
		midTab = Tilfeldig(midTab.length);

		Integer[] langTab = new Integer[128000];
		langTab = Tilfeldig(langTab.length);

		long startTid = 0;
		long sluttTid = 0;

		System.out.println("Sortering ved innsetting");
		System.out.println("N | Antall målinger | Tid (Snitt) | Teoretisk tid");

		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.sorterVedInnsetting(kortTab);

		}
		sluttTid = System.currentTimeMillis();

		System.out.println(kortTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner) + " | " + 
		((sluttTid - startTid) / (Math.pow(kortTab.length, 2)))
						* (Math.pow(kortTab.length, 2)));


		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.sorterVedInnsetting(midTab);
		}
		sluttTid = System.currentTimeMillis();

		System.out.println(midTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner) + " | " + 
		((sluttTid - startTid) / (Math.pow(midTab.length, 2)))
						* (Math.pow(midTab.length, 2)));


		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.sorterVedInnsetting(langTab);
		}
		sluttTid = System.currentTimeMillis();

		System.out.println(langTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner) + " | " + 
		((sluttTid - startTid) / (Math.pow(langTab.length, 2)))
						* (Math.pow(langTab.length, 2)));
	}

	private static void utvalgTid(int repitisjoner) {

		Integer[] kortTab = new Integer[32000];
		kortTab = Tilfeldig(kortTab.length);

		Integer[] midTab = new Integer[64000];
		midTab = Tilfeldig(midTab.length);

		Integer[] langTab = new Integer[128000];
		langTab = Tilfeldig(langTab.length);

		long startTid = 0;
		long sluttTid = 0;

		System.out.println("Sortering ved utvalg");
		System.out.println("N | Antall målinger | Tid (Snitt) | Teoretisk tid");

		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.utvalgssortering(kortTab);

		}
		sluttTid = System.currentTimeMillis();

		System.out.println(kortTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner) + " | " + 
				((sluttTid - startTid) / (Math.pow(kortTab.length, 2)))
								* (Math.pow(kortTab.length, 2)));


		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.utvalgssortering(midTab);
		}
		sluttTid = System.currentTimeMillis();

		System.out.println(midTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner) + " | " + 
				((sluttTid - startTid) / (Math.pow(midTab.length, 2)))
								* (Math.pow(midTab.length, 2)));


		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.utvalgssortering(langTab);
		}
		sluttTid = System.currentTimeMillis();

		System.out.println(langTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner) + " | " + 
				((sluttTid - startTid) / (Math.pow(langTab.length, 2)))
								* (Math.pow(langTab.length, 2)));
	}

	private static void kvikkTid(int repitisjoner) {

		Integer[] kortTab = new Integer[32000];
		kortTab = Tilfeldig(kortTab.length);

		Integer[] midTab = new Integer[64000];
		midTab = Tilfeldig(midTab.length);

		Integer[] langTab = new Integer[128000];
		langTab = Tilfeldig(langTab.length);
		
		long startTid = 0;
		long sluttTid = 0;

		System.out.println("Sortering ved kvikksortering");
		System.out.println("N | Antall målinger | Tid (Snitt) | Teoretisk tid");

		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.kvikksorter(kortTab);

		}
		sluttTid = System.currentTimeMillis();

		System.out.println(kortTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner)
				+ " | " + ((sluttTid - startTid) / (kortTab.length * (Math.log(kortTab.length) / Math.log(2))))
						* (kortTab.length * (Math.log(kortTab.length) / Math.log(2))));


		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.kvikksorter(midTab);
		}
		sluttTid = System.currentTimeMillis();

		System.out.println(midTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner) + " | "
				+ ((sluttTid - startTid) / (midTab.length * (Math.log(midTab.length) / Math.log(2))))
						* (midTab.length * (Math.log(midTab.length) / Math.log(2))));

		
		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.kvikksorter(langTab);
		}
		sluttTid = System.currentTimeMillis();

		System.out.println(langTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner)
				+ " | " + ((sluttTid - startTid) / (langTab.length * (Math.log(langTab.length) / Math.log(2))))
						* (langTab.length * (Math.log(langTab.length) / Math.log(2))));
	}

	private static void fletteTid(int repitisjoner) {

		Integer[] kortTab = new Integer[32000];
		kortTab = Tilfeldig(kortTab.length);

		Integer[] midTab = new Integer[64000];
		midTab = Tilfeldig(midTab.length);

		Integer[] langTab = new Integer[128000];
		langTab = Tilfeldig(langTab.length);

		long startTid = 0;
		long sluttTid = 0;

		System.out.println("Sortering ved flettesortering");
		System.out.println("N | Antall målinger | Tid (Snitt) | Teoretisk tid");

		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.flettesortering(kortTab);

		}
		sluttTid = System.currentTimeMillis();

		System.out.println(kortTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner)
				+ " | " + ((sluttTid - startTid) / (kortTab.length * (Math.log(kortTab.length) / Math.log(2))))
						* (kortTab.length * (Math.log(kortTab.length) / Math.log(2))));


		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.flettesortering(midTab);
		}
		sluttTid = System.currentTimeMillis();

		System.out.println(midTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner) + " | "
				+ ((sluttTid - startTid) / (midTab.length * (Math.log(midTab.length) / Math.log(2))))
						* (midTab.length * (Math.log(midTab.length) / Math.log(2))));


		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.flettesortering(langTab);
		}
		sluttTid = System.currentTimeMillis();

		System.out.println(langTab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner)
				+ " | " + ((sluttTid - startTid) / (langTab.length * (Math.log(langTab.length) / Math.log(2))))
						* (langTab.length * (Math.log(langTab.length) / Math.log(2))));
	}
}

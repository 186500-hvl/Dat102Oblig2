package v2;

import java.util.Random;

public class Oppgave2_b {

	public static void main(String[] args) {

		Integer[] Tab = new Integer[128000];
		Tab = Tilfeldig(128000, 10, 10);

		long startTid = 0;
		long sluttTid = 0;
		int repitisjoner = 10;
		System.out.println("Sortering ved kvikksortering");
		System.out.println("N | Antall målinger | Tid (Snitt) | Teoretisk tid");

		startTid = System.currentTimeMillis();
		for (int i = 0; i < repitisjoner; i++) {
			SorterTabell.kvikksorter(Tab);

		}
		sluttTid = System.currentTimeMillis();

		System.out.println(Tab.length + " | " + repitisjoner + " | " + ((sluttTid - startTid) / repitisjoner)
				+ " | " + ((sluttTid - startTid) / (Tab.length * (Math.log(Tab.length) / Math.log(2))))
						* (Tab.length * (Math.log(Tab.length) / Math.log(2))));
	}

	private static Integer[] Tilfeldig(int n, int min, int maks) {
		int[] tempTab = new Random().ints(n, 0, 1000000).toArray();
		Integer[] tab = new Integer[tempTab.length];
		int i = 0;
		for (int value : tempTab) {
			tab[i++] = Integer.valueOf(value);
		}
		return tab;
	}

}

package lib;

import junit.framework.TestSuite;
import junit.framework.TestCase;
import java.util.*;

public class CSVTest extends TestCase {
	static int totalAssertions = 0;
	static int bilanAssertions = 0;

	/* Tests des opérations */

	public void test_new_CSV() throws Exception {
		CSV csv = new CSV();
		totalAssertions++;
		assertEquals("new CSV() retourne un CSV", "lib.CSV", csv.getClass()
				.getName());
		bilanAssertions++;
	}

	public void test_read() {
		CSV csv = new CSV();
		try {
			csv.read("data/test_read.csv");
		} catch (Exception e) {
			System.out.println(e);
		}

		String[][] testArray = { { "bonjour", "ligne", "1" },
				{ "au", "revoir", "ligne", "2" } };

		ArrayList<ArrayList<String>> testSheet = new ArrayList<ArrayList<String>>();
		testSheet.add(new ArrayList<String>(Arrays.asList(testArray[0])));
		testSheet.add(new ArrayList<String>(Arrays.asList(testArray[1])));

		for (int i = 0; i < testSheet.size(); i++) {
			ArrayList<String> csvLine = csv.getSheet().get(i);
			ArrayList<String> testLine = testSheet.get(i);
			for (int j = 0; j < testLine.size(); j++) {
				totalAssertions++;
				assertEquals(csvLine.get(j) + " = " + testLine.get(j),
						csvLine.get(j), testLine.get(j));
				bilanAssertions++;
			}
		}
	}

	public void test_save() {
		String[][] testArray = { { "test", "fonction" },
				{ "CSV", ".", "save", "()" } };

		ArrayList<ArrayList<String>> testSheet = new ArrayList<ArrayList<String>>();
		testSheet.add(new ArrayList<String>(Arrays.asList(testArray[0])));
		testSheet.add(new ArrayList<String>(Arrays.asList(testArray[1])));

		CSV csv = new CSV();
		csv.setSheet(testSheet);
		try {
			csv.save("data/test_save.csv");
			csv.read("data/test_save.csv");
		} catch (Exception e) {
			System.out.println(e);
		}

		for (int i = 0; i < testSheet.size(); i++) {
			ArrayList<String> csvLine = csv.getSheet().get(i);
			ArrayList<String> testLine = testSheet.get(i);
			for (int j = 0; j < testLine.size(); j++) {
				totalAssertions++;
				assertEquals(csvLine.get(j) + " = " + testLine.get(j),
						csvLine.get(j), testLine.get(j));
				bilanAssertions++;
			}
		}
	}

	/* Tests des préconditions */

	public void test_read_exception() {
		CSV csv = new CSV();

		boolean exception = false;
		try {
			csv.read("nawak.csv");
		} catch (Exception e) {
			exception = true;
		}

		totalAssertions++;
		assertTrue("csv.read(<fichier_inexistant>) renvoi une exception",
				exception);
		bilanAssertions++;
	}

	/* Main */

	public static void main(String[] args) {
		System.out.println("Tests de la bibliothèque CSV");
		junit.textui.TestRunner.run(new TestSuite(CSVTest.class));
		if (bilanAssertions == totalAssertions) {
			System.out.print("Bravo !");
		} else {
			System.out.print("OUPS !");
		}
		System.out.println(" " + bilanAssertions + "/" + totalAssertions
				+ " assertions verifiées");
	}
}

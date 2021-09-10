import java.util.ArrayList;
import java.util.List;

/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/
/**
 * @Purpose: The PerformanceTest class is used to compare the implemented
 *           algorithms in term of time and the number of sheets used
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 */

public class PerformanceTest {

	public static void main(String[] args) {

		System.out.println("***********************************************");
		System.out.println("*********** Performance analysis **************");
		System.out.println("**********************************************");

		System.out.println();
		/*
		 * You must complete the Generator class in order to generate a random test
		 * values. You must complete the Algorithms class in order to call the two
		 * algorithms.
		 * 
		 * You can use any additional method you created in this class
		 */

		/**
		 * Remember: You need to calculate the time and number of sheets used for each
		 * run of each algorithm.
		 * 
		 * You are expected to run several tests (e.g. noOfTests=5) of your programs
		 * for, 10000, 20000, 30000, 40000, 50000 shapes (noOfShapes=10000,
		 * increment=10000) so that one can see how the algorithms perform for large
		 * datasets.
		 * 
		 * You are expected to run the same test a number of times to ensure accurate
		 * result (noOfRep=4). In this case, you need to calculate the average time and
		 * sheets needed for each run
		 **/

		// total number of tests - you need to CHANGE this value
		int noOfTests = 5;

		// number of repetitions for each test - you need to CHANGE this value
		int noOfRep = 5;

		// number of shapes needed for the first run - you need to CHANGE this
		// value
		int noOfShapes = 10000;

		// the increment in the number of shapes - you need to CHANGE this value
		int increment = 10000;

		Algorithms a = new Algorithms();
		Generator g = new Generator();
		long durationFF = 0;
		long durationNF = 0;
		double finalTimeFF = 0;
		double finalTimeNF = 0;
		int sizeCounterFF = 0;
		int sizeCounterNF = 0;
		int averageSheetsFF = 0;
		int averageSheetsNF = 0;
		StringBuilder sb = new StringBuilder("\t\t FirstFit and NextFit" + " \n");
		for (int i = 1; i <= noOfTests; i++) { /**
												 * with this algorithm I calculate the the average performance and then
												 * display it using string builder
												 */

			for (int j = 0; j < noOfRep; j++) {
				List generate = g.generateShapeList(noOfShapes);
				List checkFF = new ArrayList<>(generate);
				long starttime = System.nanoTime();
				checkFF = a.firstFit(checkFF);
				long stoptime = System.nanoTime();
				long startTime = System.nanoTime();
				List<Shape> checkNF = a.nextFit(generate);
				long stopTime = System.nanoTime();
				sizeCounterFF += checkFF.size();
				sizeCounterNF += checkNF.size();
				durationFF = durationFF + (stoptime - starttime);
				durationNF = durationNF + (stopTime - startTime);
			}

			averageSheetsFF = sizeCounterFF / noOfRep;
			averageSheetsNF = sizeCounterNF / noOfRep;
			finalTimeFF = (durationFF / noOfRep) / 1_000_000_000.0;
			finalTimeNF = (durationNF / noOfRep) / 1_000_000_000.0;

			sb.append(
					"For Test No " + i + " that had " + noOfRep + " repetitions" + " for " + noOfShapes + " shapes.\n");
			sb.append("FirstFit gave this result: \t and NextFit gave this result:\n");
			sb.append("finalTime: " + finalTimeFF + " sec\t\t finalTime: " + finalTimeNF + " sec\n");
			sb.append("Sheets: " + averageSheetsFF + "\t\t\t Sheets: " + averageSheetsNF + "\n");
			noOfShapes = noOfShapes + increment;
		}
		sb.append("\n");
		sb.append("Average times and Sheets for the whole run:\n");
		sb.append("Final average time of FirstFit: " + finalTimeFF / noOfTests + "\nFinal average time of NextFit: "
				+ finalTimeNF / noOfTests + "\n");
		sb.append("Sheets FirstFit: " + averageSheetsFF / noOfTests + "\t Sheets NextFit: "
				+ averageSheetsNF / noOfTests + "\n");
		sb.append("****************************************************");

		System.out.print(sb.toString());

	}
}

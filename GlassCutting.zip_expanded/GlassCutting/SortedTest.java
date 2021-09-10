
/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Purpose: The SortedTest class is used to compare the implemented algorithms
 *           in term of the number of sheets used WHEN the list of shapes is
 *           SORTED
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 */

public class SortedTest {
	/** Quick sort method Increase **/
	public void quicksortIncrease(List<Shape> A, int L, int R) {

		if (R > L) {
			int p = partition(A, L, R);
			quicksortIncrease(A, L, p - 1);
			quicksortIncrease(A, p + 1, R);

		}

	}

	/** Partition method Increase **/
	public int partition(List<Shape> A, int L, int R) {
		int pivot = A.get(R).getHeight();
		int i = L - 1;
		for (int j = L; j < R; j++) {
			if (A.get(j).getHeight() <= pivot) {
				i++;
				Collections.swap(A, i, j);
			}
		}
		Collections.swap(A, i + 1, R);
		return i + 1;
	}

	/** Quick sort Decrease **/
	public void quicksortDecrease(List<Shape> A, int L, int R) {

		if (R > L) {
			int p = partitionDecrease(A, L, R);
			quicksortDecrease(A, L, p - 1);
			quicksortDecrease(A, p + 1, R);

		}

	}

	/** Partition method/Decrease **/
	public int partitionDecrease(List<Shape> A, int L, int R) {
		int pivot = A.get(R).getHeight();
		int i = L - 1;
		for (int j = L; j < R; j++) {
			if (A.get(j).getHeight() >= pivot) {
				i++;
				Collections.swap(A, i, j);
			}
		}
		Collections.swap(A, i + 1, R);
		return i + 1;
	}

	public static List<Shape> SortIncrese(List<Shape> a) {// sorts the sapes by hight in increasing order

		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = 0; j < a.size() - i - 1; j++) {
				if (a.get(j).compareTo(a.get(j + 1)) == 1) {
					Collections.swap(a, j, j + 1);

				}
			}

		}

		return a;

	}

	public static List<Shape> SortDecrese(List<Shape> a) {// sorts the sapes by hight in increasing order

		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = 0; j < a.size() - i - 1; j++) {
				if (a.get(j).compareTo(a.get(j + 1)) == -1) {
					Collections.swap(a, j, j + 1);

				}
			}

		}

		return a;

	}

	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("**************** Sorted Test ****************");
		System.out.println("*********************************************");
		System.out.println();

		/*
		 * Generate a random shape list and then check the number of sheets used when
		 ** this shape list is passed un-sorted the list is sorted based on different
		 * criteria as set in the speciication document.
		 * 
		 * run several tests for different sizes of the "list of shapes"
		 */

		/*
		 * HINT: you might want to implements the comparTo method in the Shape class or
		 * implement the Comparator Interface to do the sorting
		 */

		// number of shapes needed for the first run - you need to CHANGE this
		// value
		int noOfShapes = 50000;

		Algorithms a = new Algorithms();
		Generator g = new Generator();
		SortedTest t = new SortedTest();
		List<Shape> shapeForAll = g.generateShapeList(noOfShapes);
		StringBuilder sb = new StringBuilder("  Unsorted and Sorted In increased order FirstFit" + " \n");
		List<Shape> checkFF = new ArrayList<>(shapeForAll);
		List<Sheet> unsorted = a.firstFit(checkFF);
		t.quicksortIncrease(checkFF, 0, checkFF.size() - 1);
		List<Sheet> sorted = a.firstFit(checkFF);

		sb.append("Sorted" + " \t\t\t Unsorted\n");
		sb.append("Sheets: " + sorted.size() + "\t\t\t Sheets: " + unsorted.size() + "\n");

		sb.append("\n");

		sb.append("****************************************************\n");
		sb.append(" Unsorted and Sorted In decreasing order FirstFit" + " \n");

		checkFF = new ArrayList<>(shapeForAll);
		List<Sheet> unsorted1 = a.firstFit(checkFF);
		t.quicksortDecrease(checkFF, 0, checkFF.size() - 1);
		List<Sheet> sortedDecrese = a.firstFit(checkFF);

		sb.append("Sorted" + " \t\t\t Unsorted\n");
		sb.append("Sheets: " + sortedDecrese.size() + "\t\t\t Sheets: " + unsorted1.size() + "\n");

		sb.append("****************************************************\n");
		sb.append("  Unsorted and Sorted In increased order NEXTFit" + " \n");
		List<Shape> checkNF = new ArrayList<>(shapeForAll);

		List<Sheet> unsortedNF = a.nextFit(checkNF);
		t.quicksortIncrease(checkNF, 0, checkNF.size() - 1);
		List<Sheet> sortedNF = a.nextFit(checkNF);

		sb.append("Sorted" + " \t\t\t Unsorted\n");
		sb.append("Sheets: " + sortedNF.size() + "\t\t\t Sheets: " + unsortedNF.size() + "\n");

		sb.append("\n");

		sb.append("****************************************************\n");
		sb.append(" Unsorted and Sorted In decreasing order NEXTFit" + " \n");

		checkNF = new ArrayList<>(shapeForAll);
		List<Sheet> unsortedNF1 = a.nextFit(checkNF);
		t.quicksortDecrease(checkNF, 0, checkNF.size() - 1);
		List<Sheet> sortedDecreseNF = a.nextFit(checkNF);

		sb.append("Sorted" + " \t\t\t Unsorted\n");
		sb.append("Sheets: " + sortedDecreseNF.size() + "\t\t\t Sheets: " + unsortedNF1.size() + "\n");

		System.out.print(sb.toString());

	}

}

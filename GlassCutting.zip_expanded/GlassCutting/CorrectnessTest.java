import java.util.ArrayList;
import java.util.List;

/**
	@NameofStudent: Dimo Dimchev
@StrudentNo:180322572
@Date Last Update:10/12/2019
*/
/**
 * @Purpose: The CorrectnessTest class is used to validate the correctness of
 *           the implemented algorithms. You can add additional methods if you
 *           need
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 */

public class CorrectnessTest {
	public static List<Shape> FirstFitTestShapeList(int number) {

		List<Shape> shapes = new ArrayList<Shape>();
		if (number == 1) {// this is the normal "random" test
							// W H
			shapes.add(new Shape(238, 140));
			shapes.add(new Shape(5, 40));
			shapes.add(new Shape(251, 65));
			shapes.add(new Shape(209, 73));
			shapes.add(new Shape(264, 76));

		}

		if (number == 2) {// check if shape will be placed after another shape in a shelf if there is
							// enough space, should place all shapes in 1 shelf
			shapes.add(new Shape(20, 200));
			shapes.add(new Shape(40, 150));
			shapes.add(new Shape(30, 149));
			shapes.add(new Shape(17, 111));
			shapes.add(new Shape(100, 200));
		}
		if (number == 3) {// testing if shape will be placed in the shelf if there is enough space after
							// it is being rotated
							// W H
			shapes.add(new Shape(100, 150));
			shapes.add(new Shape(140, 160));// these should be inserted one after another (routated)
			shapes.add(new Shape(150, 100));// this should be inserted on the second shelf
			shapes.add(new Shape(100, 150));// <---this shape should get rotated and placed on the second shelf right
											// after the first shape
			shapes.add(new Shape(100, 220));// This should be inserted in a new Sheet
			shapes.add(new Shape(210, 150));// This should be inserted right after the first element in the
											// sheet!(rotated version)
		}
		if (number == 4) {// testing if shape will be placed on a new shelf(not rotated)
			shapes.add(new Shape(100, 150));
			shapes.add(new Shape(140, 160));
			shapes.add(new Shape(150, 100));// this should be placed on the second shelf without a rotate
		}
		if (number == 5) {// testing if shape will be placed on a new shelf after being rotated
			shapes.add(new Shape(100, 150));
			shapes.add(new Shape(140, 160));
			shapes.add(new Shape(100, 200));// this should be routated,the inserted on the second shelf
		}
		if (number == 6) {// The total height of all shelves in a sheet does not exceed H
			shapes.add(new Shape(100, 150));
			shapes.add(new Shape(140, 160));
			shapes.add(new Shape(150, 151));// this shape should be added in another sheet,because if its added in the
											// same one it will exceed the height limit
			shapes.add(new Shape(100, 100));// this one however will be placed inside the first sheet on the second
											// shelf,because the it caps the height limit(250)

		}
		if (number == 7) {// The check if number of shapes placed on a sheet cannot exceed L(20 shapes per
							// Sheet)
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1)); // there are 25 shapes in here,and they will be ordered 20 in the first sheet
											// and 5 in second sheet
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
		}
		if (number == 8) {// here I check if The item will be added at the first available spot(FirstFit)
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(300, 200));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
		}
		return shapes;
	}

	public static List<Shape> NextFitTestShapeList(int number) {

		List<Shape> shapes = new ArrayList<Shape>();
		if (number == 1) {// this is the normal "random" test
							// W H
			shapes.add(new Shape(238, 140));
			shapes.add(new Shape(5, 40));
			shapes.add(new Shape(251, 65));
			shapes.add(new Shape(209, 73));
			shapes.add(new Shape(264, 76));

		}

		if (number == 2) {// check if shape will be placed after another shape in a shelf if there is
							// enough space,should place all shapes in 1 shelf
			shapes.add(new Shape(20, 200));
			shapes.add(new Shape(40, 150));
			shapes.add(new Shape(30, 149));
			shapes.add(new Shape(17, 111));
			shapes.add(new Shape(100, 200));
		}
		if (number == 3) {// testing if shape will be placed in the shelf if there is enough space after
							// it is being rotated
							// W H
			shapes.add(new Shape(100, 150));
			shapes.add(new Shape(140, 160));// these should be inserted one after another (routated)
			shapes.add(new Shape(150, 100));// this should be inserted on the second shelf
			shapes.add(new Shape(100, 150));// <---this shape should get rotated and placed on the second shelf right
											// after the first shape
			shapes.add(new Shape(100, 220));// This should be inserted in a new Sheet
			shapes.add(new Shape(210, 150));// This should be inserted right after the first element in the
											// sheet!(rotated version)
		}
		if (number == 4) {// testing if shape will be placed on a new shelf(not rotated)
			shapes.add(new Shape(100, 150));
			shapes.add(new Shape(140, 160));
			shapes.add(new Shape(150, 100));// this should be placed on the second shelf without a rotate
		}
		if (number == 5) {// testing if shape will be placed on a new shelf after being rotated
			shapes.add(new Shape(100, 150));
			shapes.add(new Shape(140, 160));
			shapes.add(new Shape(100, 200));// this should be routated,the inserted on the second shelf
		}
		if (number == 6) {// The total height of all shelves in a sheet does not exceed H
			shapes.add(new Shape(100, 150));
			shapes.add(new Shape(140, 160));
			shapes.add(new Shape(150, 151));// this shape should be added in another sheet,because if its added in the
											// same one it will exceed the height limit
			shapes.add(new Shape(100, 100));// this one shpuld be added after the last sheet,because next fit

		}
		if (number == 7) {// The number of shapes placed on a sheet cannot exceed L(20 shapes per Sheet)
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1)); // there are 25 shapes in here,and they will be ordered 20 in the first sheet
											// and 5 in second sheet
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
		}
		if (number == 8) {// here I check if The item will be added at/after the last used sheet at the
							// last shelf(NEXTFIT)
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(1, 1));
			shapes.add(new Shape(300, 250));
			shapes.add(new Shape(298, 1)); // this will check if next fit is adding in the last sheet and shelf
			shapes.add(new Shape(3, 1));// this should make a new shelf
			shapes.add(new Shape(1, 1));// this should be added on the second shelf, although there is place on the
										// first one

		}
		return shapes;
	}

	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*********** Correctness testing *************");
		System.out.println("*********************************************");
		System.out.println();
		Algorithms a = new Algorithms();
		/**
		 * If you want to try the tests for yourself just change the number inside the
		 * for each loop to the test you want to try from the corresponding method.
		 * 
		 */
		for (int i = 1; i <= 8; i++) {// this iterates trough all the tests and prints the results
			System.out.println("********************************************************************\n");
			System.out.println("\n Results for test No  " + i + " is:  \n");
			System.out.println("********************************************************************\n");
			System.out.println("\tFirstFit\n");
			for (Sheet s : a.firstFit(FirstFitTestShapeList(i))) {

				System.out.println(s.toString());

			}
			System.out.println("***************************************************\n");
			System.out.println("\tNextFit\n");

			for (Sheet s : a.nextFit(NextFitTestShapeList(i))) {

				System.out.println(s.toString());
			}
		}

		/*
		 * Here you will need to validate that your algorithms (nextFit() and
		 * firstFit()) behave as expected on small data sets. Think about normal cases
		 * and border cases. You can use any additional method you created in this class
		 */
	}
}

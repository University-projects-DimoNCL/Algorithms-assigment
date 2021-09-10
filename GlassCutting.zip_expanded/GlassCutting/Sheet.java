/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/

/**
 * @Purpose: The Sheet class represents a sheet with a list of shelves.
 * DO NOT MODIFY THE EXISTING METHODS SIGNITURE, You may add additional methods if you wish
 * 
 * @author  RYK 
 * @since   30/10/2019
 * extended by @author 
 */
import java.util.ArrayList;
import java.util.List;

public class Sheet {

	public static final int SHEET_HEIGHT = 250; // sheet height

	public static final int SHEET_WIDTH = 300; // sheet width

	public static final int SHAPE_LIMIT = 20; // maximum number of shapes that can be placed in each sheet (rule F)

	private List<Shelf> shelves = new ArrayList<Shelf>(); // list of shelves

	/**
	 * empty constructor
	 */
	public Sheet() {
	}

	/**
	 * This method is used to add a shelf to a sheet
	 * 
	 * @param a shelf\\\\\\\
	 */
	public void addShelf(Shelf shelf) {
		shelves.add(shelf);
	}

	/**
	 * @return height of all shelves in a sheet
	 */
	public int allShelvesHeight() {

		int total = 0;

		for (Shelf shelf : this.shelves) {

			// has a shelf with at least 1 shape
			if (!shelf.getShapes().isEmpty()) {

				// add all shelf height to total
				total += shelf.getHeight();
			}
		}
		return total;
	}

	/**
	 * @return list of all shelves in a sheet
	 */
	public List<Shelf> getShelves() {
		return this.shelves;
	}

	/**
	 * @return height
	 */
	public int getHeight() {
		return SHEET_HEIGHT;
	}

	/**
	 * @return width
	 */
	public int getWidth() {
		return SHEET_WIDTH;
	}

	@Override
	public String toString() {// overwritten TOOSTRING method
		int s = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("\t\t\t Sheet contains " + shelves.size() + " shelves\n");
		int i = 1;
		for (Shelf a : shelves) {
			sb.append("\n");
			sb.append("\t Shelf " + i + " has " + a.shapes.size() + " shape inside." + " The used shelf width" + " is "
					+ a.getWidth() + ", shelf height is " + a.getHeight() + "\n");
			i++;
			int k = 1;
			for (Shape b : a.shapes) {
				sb.append("\t\t Shape " + k + " width " + b.getWidth() + " and has height " + b.getHeight() + "\n");

				s++;
				k++;

			}

		}
		sb.append("\t Number of shapes  " + s);
		return sb.toString();
	}

	public void displayContent() {
		System.out.println(this.toString());
	}

	public int limitCheck() {// this method counts the shapes in the current sheet
		// it is used for determining Shape Limit on a sheet
		int counter = 0;
		for (Shelf shelf : shelves) {
			for (Shape shape : shelf.shapes) {
				counter++;
			}
		}
		return counter;
	}

}

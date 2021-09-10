/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/
/**
 * @Purpose: The Algorithms class contains the two algorithms you have to implement  
 * Do NOT modify the names and signatures of the two algorithm methods
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author 
 *
 **/

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

	/**
	 * This method is used to implement the next fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests(shapes to be
	 *        cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e. place
	 *         all the shapes). e.g. if you pass a "shapes" list that has two shapes
	 *         {(w=200,h=200),(w=50,h=100)}, then the returned list of sheets should
	 *         show us all the information needed (e.g. that one sheet is used, this
	 *         sheet has one shelf and this shelf has two shapes in it). In the test
	 *         program, you can use the returned list to retrieve the total number
	 *         of sheets used.
	 **/

	public List<Sheet> nextFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width of 300
		 * and a height of 250 as specified in the Sheet class)
		 */
		List<Sheet> usedSheets = new ArrayList<Sheet>();
		int usedSheet = 0;
		for (Shape shape : shapes) {

			boolean check = false;// This is a check to see if the shape is already inserted somewhere
			Shape rotation = shape.rotate();
			if (usedSheets.isEmpty()) {// checking if there is no sheets,then adding a new with the first shape
				usedSheets.add(new Sheet());
				usedSheets.get(usedSheet).addShelf(new Shelf(shape.getHeight()));
				usedSheets.get(usedSheet).getShelves().get(0).place(shape);
			} else {
				while (usedSheet < usedSheets.size()) {// Here I go to the last sheet and the last shelf to check if we
														// can insert the shape.
					Sheet sheet = usedSheets.get(usedSheet);
					if (sheet.limitCheck() < sheet.SHAPE_LIMIT) {// check if a sheet has 20 shapes if it does create a
																	// new sheet and insert the shape
						Shelf shelf = sheet.getShelves().get(sheet.getShelves().size() - 1);

						if (shape.getHeight() <= shelf.getHeight()
								&& shape.getWidth() + shelf.getWidth() <= sheet.getWidth() && check == false) {// check
																												// if
																												// shape
																												// can
																												// be
																												// inserted
							shelf.place(shape);
							check = true;
							break;

						} else if (rotation.getHeight() <= shelf.getHeight()
								&& rotation.getWidth() + shelf.getWidth() <= sheet.getWidth() && check == false) {// check
																													// if
																													// shape
																													// can
																													// be
																													// inserted
																													// after
																													// a
																													// rotatation
							shelf.place(rotation);
							check = true;
							break;
						}

						if (sheet.allShelvesHeight() + shape.getHeight() <= sheet.getHeight() && check == false) {// here
																													// we
																													// see
																													// if
																													// we
																													// can
																													// insert
																													// the
																													// shape
																													// in
																													// a
																													// new
																													// shelf
							sheet.addShelf(new Shelf(shape.getHeight()));
							sheet.getShelves().get(sheet.getShelves().size() - 1).place(shape);
							check = true;
							break;

						} else if (sheet.allShelvesHeight() + rotation.getHeight() <= sheet.getHeight()
								&& check == false) {// check if shape can be inserted on a new shelf after a rotatation
							sheet.addShelf(new Shelf(rotation.getHeight()));
							sheet.getShelves().get(sheet.getShelves().size() - 1).place(rotation);
							check = true;
							break;
						} else {
							usedSheet++;
						}
					} else { // those are the sheet counters that keep count of the last sheet used
						usedSheet++;
					}

				}
				if (check == false) {// create a new sheet for the shape

					usedSheets.add(new Sheet());
					usedSheets.get(usedSheet).addShelf(new Shelf(shape.getHeight()));
					usedSheets.get(usedSheet).getShelves().get(usedSheets.get(usedSheet).getShelves().size() - 1)
							.place(shape);
				}
			}
		}
		/*
		 * Add in your own code so that the method will place all the shapes according
		 * to NextFit under ALL the assumptions mentioned in the specification
		 * 
		 * 
		 */

		return usedSheets;
	}

	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests (shapes to be
	 *        cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e. place
	 *         all the shapes). e.g. if you pass a "shapes" list that has two shapes
	 *         {(w=200,h=200),(w=50,h=100)}, then the returned list of sheets should
	 *         show us all the information needed (e.g. that one sheet is used, this
	 *         sheet has one shelf and this shelf has two shapes in it). In the test
	 *         program, you can use the returned list to retrieve the total number
	 *         of sheets used
	 **/
	public List<Sheet> firstFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width of 300
		 * and a height of 250 as specified in the Sheet class)
		 */
		List<Sheet> usedSheets = new ArrayList<Sheet>();

		for (Shape shape : shapes) {
			boolean check = false;// This is a check to see if the shape is already inserted somewhere

			Shape rotation = shape.rotate();
			if (usedSheets.isEmpty()) { // checking if there is no sheets,then adding a new with the first shape
				usedSheets.add(new Sheet());
				usedSheets.get(0).addShelf(new Shelf(shape.getHeight()));
				usedSheets.get(0).getShelves().get(0).place(shape);
			} else {

				for (Sheet sheet : usedSheets) {// Here I go through all the sheets,shelves to find the place for the
												// shape
					if (sheet.limitCheck() < sheet.SHAPE_LIMIT) {
						for (Shelf shelf : sheet.getShelves()) {
							if (check == false && (shape.getHeight() <= shelf.getHeight())
									&& (shape.getWidth() + shelf.getWidth() <= sheet.getWidth())) {// check if shape can
																									// be inserted
								shelf.place(shape);
								check = true;

							} else if ((check == false && rotation.getHeight() <= shelf.getHeight())
									&& (rotation.getWidth() + shelf.getWidth() <= sheet.getWidth())) {// check if shape
																										// can be
																										// inserted
																										// after a
																										// rotatation
								shelf.place(rotation);
								check = true;

							}
						}
						if (check == false && sheet.allShelvesHeight() + shape.getHeight() <= sheet.getHeight()) {// here
																													// we
																													// see
																													// if
																													// we
																													// can
																													// insert
																													// the
																													// shape
																													// in
																													// a
																													// new
																													// shelf
							sheet.addShelf(new Shelf(shape.getHeight()));
							sheet.getShelves().get(sheet.getShelves().size() - 1).place(shape);
							check = true;

						} else if (check == false
								&& sheet.allShelvesHeight() + rotation.getHeight() <= sheet.getHeight()) {// check if
																											// shape can
																											// be
																											// inserted
																											// on a new
																											// shelf
																											// after a
																											// rotatation
							sheet.addShelf(new Shelf(rotation.getHeight()));
							sheet.getShelves().get(sheet.getShelves().size() - 1).place(rotation);
							check = true;

						}
					}
				}
				if (check == false) {// create a new sheet for the shape

					usedSheets.add(new Sheet());
					usedSheets.get(usedSheets.size() - 1).addShelf(new Shelf(shape.getHeight()));
					usedSheets.get(usedSheets.size() - 1).getShelves().get(0).place(shape);
				}
			}
		}
		/*
		 * Add in your own code so that the method will place all the shapes according
		 * to FirstFit under the assumptions mentioned in the spec
		 */

		return usedSheets;
	}

}

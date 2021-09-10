/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/

/**
 *  @Purpose: The Generator class generates a list of shapes of random width and height.
 * Do NOT modify the names and signatures of the generator method
 * 
 * @author  RYK
 * @since   30/10/2019
 * extended by @author 
 */
import java.util.ArrayList;
import java.util.List;

public class Generator {

	public static final int MAX_SIZE_HEIGHT = 250;
	public static final int MAX_SIZE_WIDTH = 300;

	/**
	 * This method will generate a list of shapes of random width and height
	 * (integers). The random width is between 1 and MAX_SIZE_WIDTH inclusive. The
	 * random height is between 1 and MAX_SIZE_HEIGHT inclusive.
	 * 
	 * @param numberOfShapes: the number of shapes to generate
	 * @return a list of shapes of random sizes
	 */
//DONE!

	public List<Shape> generateShapeList(int numberOfShapes) {

		List<Shape> shapes = new ArrayList<Shape>();

		for (int i = 0; i < numberOfShapes; i++) {
			int width = (int) (Math.random() * ((MAX_SIZE_WIDTH - 1) + 1)) + 1;
			int height = (int) (Math.random() * ((MAX_SIZE_HEIGHT - 1) + 1)) + 1;
			shapes.add(new Shape(width, height));
		}

		return shapes;
	}

}
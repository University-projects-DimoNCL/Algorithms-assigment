/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/
/**
 * @Purpose: The shape class represents a single shape. DO NOT MODIFY THE
 *           SIGNITURE OF EXISTING METHODS, You may add additional methods if
 *           you wish
 * 
 * @author RYK
 * @since 30/10/2019 extended by @author
 * 
 **/

public class Shape implements Comparable<Shape> {

	private int sWidth; // width of the shape
	private int sHeight; // height of the shape

	/**
	 * A Shape constructor to set the width and height of a shape.
	 * 
	 * @param width  of a shape
	 * @param height of a shape
	 **/
	public Shape(int width, int height) {

		// Shape width and height should not be greater than the sheet width and height
		if (width > Sheet.SHEET_WIDTH || height > Sheet.SHEET_HEIGHT) {
			throw new IllegalArgumentException("Shape width or height is not valid");

		}

		this.sWidth = width;
		this.sHeight = height;
	}

	/**
	 * @return height of a shape
	 **/
	public int getHeight() {
		return sHeight;
	}

	/**
	 * @return width of a shape
	 */
	public int getWidth() {
		return sWidth;
	}

	public Shape rotate() {
		if (this.sHeight < Sheet.SHEET_WIDTH && this.sWidth < Sheet.SHEET_HEIGHT) {
			return new Shape(sHeight, sWidth);
		}
		return this;
	}

	@Override
	public boolean equals(Object object) {// I use it to check if its the same object
		if (object == this) {
			return true;
		}
		if (object instanceof Shape) {
			Shape s = (Shape) object;
			if ((this.getHeight() == s.getHeight()) && (this.getWidth() == s.getWidth())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Shape o) {
		if (this.getHeight() * this.getWidth() == o.getHeight() * o.getWidth()) {

			return 0;
		} else if (this.getHeight() * this.getWidth() < o.getHeight() * o.getWidth()) {
			return -1;
		} else {

			return 1;
		}
	}

}

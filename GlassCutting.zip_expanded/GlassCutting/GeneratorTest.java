
/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GeneratorTest {
	/**
	 * I Test if there are out of bounds random numbers + how random is my algorithm
	 */
	@Test
	void testRandomGenerator() {
		Generator g = new Generator();
		int MatchCount = 0;
		for (int i = 0; i < 1000; i++) {

			List<Shape> list = g.generateShapeList(1000);

			for (Shape a : list) {
				if (a.getHeight() == 1 || a.getWidth() == 1) {
					System.out.println("Works");
					MatchCount++;
				}
				if (a.getHeight() == g.MAX_SIZE_HEIGHT || a.getWidth() == g.MAX_SIZE_WIDTH) {
					System.out.println("Works");
					MatchCount++;
				}

				assertFalse(a.getHeight() > g.MAX_SIZE_HEIGHT);
				assertFalse(a.getWidth() > g.MAX_SIZE_WIDTH);
				assertFalse(a.getWidth() < 1);
				assertFalse(a.getWidth() < 1);
			}

		}

		System.out.println(MatchCount / 1000);
	}
}

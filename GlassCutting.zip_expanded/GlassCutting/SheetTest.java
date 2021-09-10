
/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SheetTest {

	@Test
	void displayTest() {
		Sheet a = new Sheet();
		Shelf Shelf1 = new Shelf(30);
		Shelf Shelf2 = new Shelf(30);
		Shape c = new Shape(10, 15);
		Shape d = new Shape(20, 20);
		Shape g = new Shape(30, 30);
		Shelf1.place(c);
		Shelf1.place(g);
		Shelf2.place(c);
		Shelf2.place(g);
		Shelf1.place(d);
		Shelf2.place(d);
		a.addShelf(Shelf1);
		a.addShelf(Shelf2);
		a.displayContent();
	}

}

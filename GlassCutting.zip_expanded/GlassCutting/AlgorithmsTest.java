
/**
 	@NameofStudent: Dimo Dimchev
	@StrudentNo:180322572
	@Date Last Update:10/12/2019
*/
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class AlgorithmsTest {

	@Test
	void fftest() {
		Algorithms a = new Algorithms();
		Generator g = new Generator();
		System.out.println("***************************************************");
		System.out.println("\tFirstFit");
		for (Sheet s : a.firstFit(g.generateShapeList(5))) {

			System.out.println(s.toString());
		}
	}

	@Test
	void nftest() {
		Algorithms a = new Algorithms();
		Generator g = new Generator();
		System.out.println("***************************************************");
		System.out.println("\tNextFit");
		for (Sheet s : a.nextFit(g.generateShapeList(10))) {
			System.out.println("*");
			System.out.println(s.toString());
		}
	}

}

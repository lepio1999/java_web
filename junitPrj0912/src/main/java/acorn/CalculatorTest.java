package acorn;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	Calculator t = new Calculator();

	@Test
	void testAdd() {
		//fail("Not yet implemented");
		assertEquals(8, t.add(3, 5));
	}

	@Test
	void testMin() {
		//fail("Not yet implemented");
		assertEquals(2, t.min(5, 3));
	}

	@Test
	void testMul() {
		//fail("Not yet implemented");
		assertEquals(9, t.mul(3, 3));
	}

	@Test
	void testDiv() {
		//fail("Not yet implemented");
		assertEquals(3, t.div(9, 3));
	}

	@Test
	void testDivisor() {
		//fail("Not yet implemented");
		int [] result = t.divisor(10);
		int [] result2 = {1,2,5,10};
		assertArrayEquals(result2, result);
		//assertArrayEquals(new int[] {1,2,5,10}, t.yak(10));
	}
}

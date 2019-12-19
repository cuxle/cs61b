import org.junit.Test;
import static org.junit.Assert.*;
public class TestSort {
	/** test sort method of Sort class. */

	@Test
	public void testSort() {
		String[] input = {"i", "have", "an", "egg"};
		String[] expected = {"an", "egg", "have", "i"};
		Sort.sort(input);

		assertArrayEquals(expected, input);
		
	}

	@Test
	public void testFindSmallest()
	{
		String[] input = {"i", "have", "an", "egg"};
		int start = 1;
		int res = Sort.findSmallest(input, start);
		assertEquals(2, res);
	}

	@Test
	public void testSwapToPos() {
		String[] input = {"i", "have", "an", "egg"};
		String[] expected = {"egg", "have", "an", "i"};
		Sort.swapToPos(input, 0, 3);
		assertArrayEquals(expected, input);

	}

}
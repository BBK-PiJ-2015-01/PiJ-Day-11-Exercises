import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;
import java.lang.*;


public class SimpleHashTest {

	private SimpleMap instance;
	
	@Before
	public void init() {
		instance = new IntegerToStringSimpleMap();
	}
	
	@Test
	public void isEmptyTest() {

		boolean expectedIsEmpty = true;
		boolean resultIsEmpty = instance.isEmpty();
		assertEquals(expectedIsEmpty,resultIsEmpty );
	}
	
	@Test
	public void isEmptyTestForPopulatedMap() {

		boolean expectedIsEmpty = false;
		int expectedKey = new Random().nextInt(Integer.MAX_VALUE);
		String expectedString = "expectedString";
		instance.put(expectedKey, expectedString);
		boolean resultIsEmpty = instance.isEmpty();
		assertEquals(expectedIsEmpty,resultIsEmpty );
	}
	
	@Test
	public void putTest() {

		int expectedKey = new Random().nextInt(Integer.MAX_VALUE);
		String expectedString = "expectedString";
		instance.put(expectedKey, expectedString);
	}
	
	//@Test(expected=ArrayIndexOutOfBoundsException.class)
	@Test
	public void putNegativeIndexTest() {

		int expectedKey = -1;
		String expectedString = "expectedString";
		instance.put(expectedKey, expectedString);
	}
	
	@Test
	public void putMultipleTest() {

		int limit = 2000;
		Random random = new Random();
		for (int i = 0; i < limit; i++ ) {
			instance.put(random.nextInt(Integer.MAX_VALUE), null);
		}
	}
	
	@Test 
	public void getFromEmptyMapTest() {
		
		String result = instance.get(new Random().nextInt(Integer.MAX_VALUE));
		assertNull(result);
	}
	
	@Test 
	public void getValidTest() {
		
		int expectedKey = new Random().nextInt(Integer.MAX_VALUE);
		String expectedString = "expectedString";
		instance.put(expectedKey, expectedString);
		String resultString = instance.get(expectedKey);
		assertEquals(expectedString, resultString);
	}
	
	@Test 
	public void getNotFoundTest() {
		
		int expectedKey = new Random().nextInt(Integer.MAX_VALUE);
		String expectedString = "expectedString";
		instance.put(expectedKey, expectedString);
		String resultString = instance.get(expectedKey+1);
		assertNull(resultString);
	}
	
	@Test
	public void removeFromEmptyMapTest() {
		
		int expectedKey = new Random().nextInt(Integer.MAX_VALUE);
		instance.remove(expectedKey);
	}
	
	@Test
	public void removeValidTest() {
		
		int expectedKey = new Random().nextInt(Integer.MAX_VALUE);
		String expectedString = "expectedString";
		instance.put(expectedKey, expectedString);
		instance.remove(expectedKey);
	}
	
	@Test 
	public void removeNotFoundTest() {
		
		int expectedKey = new Random().nextInt(Integer.MAX_VALUE);
		String expectedString = "expectedString";
		instance.put(expectedKey, expectedString);
		instance.remove(expectedKey+1);
	}
}
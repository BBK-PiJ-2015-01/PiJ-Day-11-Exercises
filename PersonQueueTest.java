import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;
import java.lang.*;


public class PersonQueueTest {

	private PersonQueue instance;
	
	@Before
	public void init() {
		instance = new BasicSupermarketQueue();
	}
	
	@Test
	public void insertNullTest() {
	
		instance.insert(null);
	}
	
	@Test
	public void insertValidTest() {

		int expectedQSize = 1;
		instance.insert(getPerson());
		int resultQSize = instance.size();
		assertEquals(expectedQSize, resultQSize);		
	}
	
	@Test
	public void insertManyTest() {

		int qLimit = 2000;
		for (int i = 0; i < qLimit; i++) {
			instance.insert(getPerson());
		}
		int expectedQSize = qLimit;
		int resultQSize = instance.size();
		assertEquals(expectedQSize, resultQSize);		
	}
	
	@Test
	public void retrieveFromEmptyQueueTest() {
		
		Person expectedPerson = null;
		Person resultPerson = instance.retrieve();
		assertEquals(expectedPerson, resultPerson);		
	}
	
	@Test
	public void retrieveFromPopulatedQueueTest() {
		
		Person expectedPerson = getPerson();
		instance.insert(expectedPerson);
		Person resultPerson = instance.retrieve();
		assertEquals(expectedPerson, resultPerson);		
		//
		int expectedQSize = 0;
		int resultQSize = instance.size();
		assertEquals(expectedQSize, resultQSize);	
	}
	
	private Person getPerson() {

        return new Person() {

            @Override
            public void move(int distance) {
                // Go nowhere
            }

            @Override
            public void say(String message) {
                // Say nothing
            }
        };
    }
}
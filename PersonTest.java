import org.junit.*;
import static org.junit.Assert.*;
import java.util.Random;
import java.lang.*;


public class PersonTest {

	private PersonEx3 instance;
	
	@Before
	public void init() {
		instance = new PersonEx3();
	}
	
	@Test
	public void getInitialsTest() {

		String testName = "SERGIO GUTIERREZ SANTOS";
		String expectedInitials = "SGS";
		String resultInitials = instance.getInitials(testName);
		assertEquals(expectedInitials,resultInitials );
	}
	
	@Test
	public void getInitialsMultipleSpacesTest() {

		String testName = "SERGIO        GUTIERREZ                                           SANTOS";
		String expectedInitials = "SGS";
		String resultInitials = instance.getInitials(testName);
		assertEquals(expectedInitials,resultInitials );
	}
	
}
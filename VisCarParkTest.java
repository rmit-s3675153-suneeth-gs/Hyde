import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VisCarParkTest {
	VisCarPark a;
	@Before
	public void setUp() {
		a = new VisCarPark("car");
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test1(){
		//String s=a.EMPID();
		assertEquals(a.park(),"admin3");
	}
	@Test
	public void test2(){
		//String s=a.EMPID();
		assertEquals(a.park(),"car");
	}
	@Test
	public void test3(){
		assertNull(a);
	}
	@Test
	public void test4(){
		assertNotNull(a);
	}
	

}

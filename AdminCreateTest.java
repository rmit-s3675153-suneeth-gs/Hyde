import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdminCreateTest {
	AdminCreate a;
	@Before
	public void setUp() {
		a = new AdminCreate("r1234","Jim","carrey");
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test1(){
		//String s=a.EMPID();
		assertEquals(a.EMpid(),"r1234");
	}
	@Test
	public void test2(){
		//String s=a.EMPID();
		assertEquals(a.EMpid(),"r1237");
	}
	@Test
	public void test3(){
		assertNull(a);
	}
	@Test
	public void test4(){
		assertNotNull(a);
	}
	@Test
	public void test5(){
		//String s=a.EMPID();
		assertEquals(a.Firstname(),"Jim");
	}
	@Test
	public void test6(){
		//String s=a.EMPID();
		assertEquals(a.Lastname(),"carrey");
	}

}

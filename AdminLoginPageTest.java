import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AdminLoginPageTest {

	AdminLoginPage a;
	@Before
	public void setUp() {
		a = new AdminLoginPage("admin1","1234");
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test1(){
		//String s=a.EMPID();
		assertEquals(a.User(),"admin3");
	}
	@Test
	public void test2(){
		//String s=a.EMPID();
		assertEquals(a.pass(),"1222");
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
		assertEquals(a.User(),"admin1");
	}
	@Test
	public void test6(){
		//String s=a.EMPID();
		assertEquals(a.pass(),"1234");
	}
}

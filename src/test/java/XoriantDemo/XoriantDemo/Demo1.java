package XoriantDemo.XoriantDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void add() {			
		
		System.out.println("---------Addition");
		int a = 10;
		int b = 20;
		Assert.assertEquals(30, a+b);
	}
	
	@Test
	public void sub() {	
		
		System.out.println("---------Subtraction");
		int a = 10;
		int b = 20;
		Assert.assertEquals(10, b-a);
	}
}

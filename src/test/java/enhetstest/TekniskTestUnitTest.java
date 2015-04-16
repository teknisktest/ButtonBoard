package enhetstest;


import org.junit.Test;
import org.junit.Assert;
import com.soprasteria.boot.BootUp;

public class TekniskTestUnitTest {
	
	@Test
	public void TekniskTestIsFunFunFun() {
		Assert.assertEquals("FUN FUN FUN", BootUp.tekniskTest("teknisk test"));
	}
	
	@Test
	public void NotTekniskTestIsYeahYeah() {
		Assert.assertEquals("YEAH YEAH", BootUp.tekniskTest("selvangivelse"));
	}

}

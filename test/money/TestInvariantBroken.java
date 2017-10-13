package money;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInvariantBroken {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=InvariantBroken.class)
	public void testInvariantBroken() throws InvariantBroken {
		InvariantBroken exception = new InvariantBroken("");
		throw exception;
	}

}

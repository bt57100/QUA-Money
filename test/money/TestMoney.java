package money;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMoney {

	private String currency;
	private int amount;
	
	@Before
	public void setUp() throws Exception {
		this.currency = "";
		this.amount = 0;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=InvariantBroken.class)
	public void testMoneyNegative() throws InvariantBroken {
		Money money = new Money("euro",-1);
	}

	@Test(expected=InvariantBroken.class)
	public void testMoneyCurrency() throws InvariantBroken {
		Money money = new Money("",1);
	}

	@Test
	public void testMoney() throws InvariantBroken {
		Money money = new Money("euro",1);
		assertTrue("NOK constructor Currency", money.getDevise().equals("euro"));
		assertEquals("NOK constructor amount", 1, money.getMontant());
	}

	@Test
	public void testAdd() throws InvariantBroken {
		Money money1 = new Money("euro",2);
		Money money2 = new Money("euro",1);
		assertEquals("NOK add", money1.add(money2).getMontant(), 3);
	}

	@Test(expected=InvariantBroken.class)
	public void testAddDifferent() throws InvariantBroken {
		Money money1 = new Money("euro",1);
		Money money2 = new Money("yen",1);
		money1.add(money2);
	}

	@Test
	public void testSub() throws InvariantBroken {
		Money money1 = new Money("euro",2);
		Money money2 = new Money("euro",1);
		assertEquals("NOK sub", money1.sub(money2).getMontant(), 1);
	}

	@Test(expected=InvariantBroken.class)
	public void testSubDifferent() throws InvariantBroken {
		Money money1 = new Money("euro",1);
		Money money2 = new Money("yen",1);
		money1.sub(money2);
	}

}

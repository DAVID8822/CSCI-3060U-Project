import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class 257 {
	@Test
	void testStatementLine201TestPost() {
		System.out.println("Checking post");
		Assertions.assertEquals(iter);
	}
	@Test
	void testStatementLine206TestRent() {
		System.out.println("Testing Rent 1");
//		Assertions.assertEquals();
	}
	@Test
	void testStatementLine240TestRent() {
		System.out.println("Testing Rent 2");
//		Assertions.assertEquals();
	}
	@Test
	void testStatementLine248TestRent() {
		System.out.println("Rent Test 3");
		Assertions.assertEquals(rentedPosting);
	}

	@Test
	void testStatementLine259TestRent() {
		System.out.println("");
		Assertions.assertEquals(id, rentedPosting.getCityName(), rentedPosting.getNumBedrooms(), totalcost,  nights);
	}

	@Test
	void testStatementLine303TestRent() {
		System.out.println("");
		Assertions.assertEquals(currPost);
	}

	@Test
	void testStatementLine337Test2() {
		System.out.println("linetoArray");
		Assertions.assertEquals(stringSplit[0], new User(stringSplit[0], stringSplit[1], stringSplit[2]));
	}
	@Test
	void testStatementLine343Test() {
		System.out.println("");
		Assertions.assertEquals(stringSplit[0],Double.parseDouble(stringSplit[1]), Integer.parseInt(stringSplit[2]), Integer.parseInt(stringSplit[3]), Boolean.parseBoolean(stringSplit[4])));
	}

	@Test
	void testStatementLine406Test1() {
		System.out.println("");
		Assertions.assertEquals(reader,storedOutput, args[1], args[1], accountMap);
	}
}

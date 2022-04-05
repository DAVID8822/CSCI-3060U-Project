import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class 257 {
	@Test
	void logoutTest() {
		System.out.println("testing the output of the logout");
		Assertions.assertEquals(currentUser.name, currentUser.userType, outputFile, storedOutput);
	}
}

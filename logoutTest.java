import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class logoutTest{
    otbnb otbnb;
    public static Map<String, User> accountMap = new HashMap<>();
    public static ArrayList<Post> rentalList = new ArrayList<>();
    ArrayList <String> storedOutput = new ArrayList<String>();

    @BeforeEach
    void setUp() {
        otbnb otbnb= new otbnb(accountMap,rentalList,null,false);
        otbnb.accountMap.put("user1", new User("user1", "pass1", "AA"));
        otbnb.currentUser = accountMap.get("user1");
    }

    @Test
    public void testlogoutTrue() throws IOException {
        otbnb.loggedIn = true;
        otbnb.logout("test.txt", storedOutput);
        StackTraceElement[] ele = Thread.currentThread().getStackTrace();
        System.out.println(ele);
        assertEquals(ele, 6);
    }

    public void testlogoutFalse() throws IOException {
        otbnb.loggedIn = false;
        otbnb.logout("test.txt", storedOutput);
        StackTraceElement[] ele = Thread.currentThread().getStackTrace();
        System.out.println(ele);
        assertEquals(ele, 4);
    }
}

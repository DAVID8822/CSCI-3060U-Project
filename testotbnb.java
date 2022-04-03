import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testotbnb {

    public static Map<String, User> accountMap = new HashMap<>();
    public static ArrayList<Post> rentalList = new ArrayList<>();
   // otbnb otbnb= new otbnb(accountMap,rentalList,currentUser,loggedIn);

    @BeforeEach
    void setUp() {
        otbnb otbnb= new otbnb(accountMap,rentalList,null,false);
    }


    @Test
    void demoTestMethod() {
        System.out.println("Assert true test");
        assertTrue(true);
    }

    @Test
    public void testlogout1true(){
        String correctUser = "user1";
        String incorrectUser = "user2";
        accountMap.put("user1", new User("user1", "pass1", "AA"));
        assertTrue(accountMap.containsKey(correctUser));// True

    }
    @Test
    public void testlogout1false(){
        String incorrectUser = "user2";
        accountMap.put("user1", new User("user1", "pass1", "AA"));
        assertTrue(!accountMap.containsKey(incorrectUser));// True
    }
    @Test
    public void testlogout2true(){
        String correctUser = "user1";
        String correctPass = "pass1";
        accountMap.put("user1", new User("user1", "pass1", "AA"));
        assertTrue(accountMap.get(correctUser).getPassword().equals(correctPass));
    }
    @Test
    public void testlogout2false(){
        String correctUser = "user1";
        String incorrectPass = "gobbeldygook";
        accountMap.put("user1", new User("user1", "pass1", "AA"));
        assertTrue(!accountMap.get(correctUser).getPassword().equals(incorrectPass));
    }


}

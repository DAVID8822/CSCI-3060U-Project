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
    otbnb otbnb;
    public static Map<String, User> accountMap = new HashMap<>();
    public static ArrayList<Post> rentalList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        otbnb otbnb= new otbnb(accountMap,rentalList,null,false);
    }



    @Test
    public void testlogin1true(){
        String correctUser = "user1";
        String password = "asdf";
        otbnb.accountMap.put("user1", new User("user1", "pass1", "AA"));
        assertTrue(accountMap.containsKey(correctUser));// Test makes sure the hashmap contains the user that exists

    }
    @Test
    public void testlogin1false(){
        String incorrectUser = "user2";
        String password = "asdf";
        otbnb.accountMap.put("user1", new User("user1", "pass1", "AA"));
        assertTrue(!accountMap.containsKey(incorrectUser));// Test makes sure the hashmap doesn't contain a user that doesn't exist
    }
    @Test
    public void testlogin2true(){
        String correctUser = "user1";
        String correctPass = "pass1";
        otbnb.accountMap.put("user1", new User("user1", "pass1", "AA"));
        assertTrue(accountMap.get(correctUser).getPassword().equals(correctPass)); //Test makes sure correct passwords aren't seen as incorrect
    }
    @Test
    public void testlogin2false(){
        String correctUser = "user1";
        String incorrectPass = "gobbeldygook";
        otbnb.accountMap.put("user1", new User("user1", "pass1", "AA"));
        assertTrue(!accountMap.get(correctUser).getPassword().equals(incorrectPass)); //Test makes sure incorrect passwords aren't seen as correct
    }

    @Test
    public void testloginloop1(){
        //Testing a a variety of iterations on our while loop
        String [] it0 = {"notempty"};
        String [] it1 = {"","notempty"};
        String [] it2 = {"","","notempty"};
        String [] it5 = {"","","","","","notempty"};
        String username;
        int count =0;
        //Testing one iteration
        while((username = it0[count]).isEmpty()){
            count++;
        }
        assertEquals(count,0); //Making sure the number of iterations is equal to the expected number
        assertTrue(!username.isEmpty()); //Making sure that username is not empty

        count =0;
        while((username = it1[count]).isEmpty()){
            count++;
        }
        assertEquals(count,1);
        assertTrue(!username.isEmpty());

        count =0;
        while((username = it2[count]).isEmpty()){
            count++;
        }
        assertEquals(count,2);
        assertTrue(!username.isEmpty());

        count = 0;
        while((username = it5[count]).isEmpty()){
            count++;
        }
        assertEquals(count,5);
        assertTrue(!username.isEmpty());

    }

    @Test
    public void testloginloop2(){
        //Testing a a variety of iterations on our while loop
        String [] it0 = {"notempty"};
        String [] it1 = {"","notempty"};
        String [] it2 = {"","","notempty"};
        String [] it5 = {"","","","","","notempty"};
        String password;
        int count =0;

        while((password = it0[count]).isEmpty()){
            count++;
        }
        assertEquals(count,0); //Making sure the number of iterations is equal to the expected number
        assertTrue(!password.isEmpty()); //Making sure that password is not empty

        count =0;
        while((password = it1[count]).isEmpty()){
            count++;
        }
        assertEquals(count,1);
        assertTrue(!password.isEmpty());

        count =0;
        while((password = it2[count]).isEmpty()){
            count++;
        }
        assertEquals(count,2);
        assertTrue(!password.isEmpty());

        count = 0;
        while((password = it5[count]).isEmpty()){
            count++;
        }
        assertEquals(count,5);
        assertTrue(!password.isEmpty());

    }


}

package Lab02;

import Lab02.Lab02PersonEquals;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nazgual on 2/27/20.
 */
public class Lab02PersonEqualsTest {
    Lab02PersonEquals bob = new Lab02PersonEquals("Bob", "Gail", 68);
    Lab02PersonEquals robert = new Lab02PersonEquals("Robert", "Zemeckis", 67);
    @Test
    public void getName() throws Exception {
        assertEquals("Bob", bob.getName());
    }

    @Test
    public void getSurname() throws Exception {
        assertEquals("Zemeckis", robert.getSurname());
    }

    @Test
    public void getAge() throws Exception {
        assertNotEquals(68, robert.getAge());
    }

    @Test
    public void equals() throws Exception {
        Lab02PersonEquals copyBob = bob;
        assertEquals(bob, copyBob);
        Lab02PersonEquals newBob = new Lab02PersonEquals("Bob", "Gail", 68);
        assertEquals(bob, newBob);
        String json = bob.toJson(bob);
        Lab02PersonEquals fromJsonBob = bob.fromJson(json);
        assertEquals(bob, fromJsonBob);
        assertNotEquals(bob, robert);
        assertNotEquals(bob, new Object());
        assertNotEquals(bob, null);
    }

}
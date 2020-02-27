import org.junit.Test;

import static org.junit.Assert.*;


public class Lab01StringCheckerTest {
    Lab01StringChecker sc = new Lab01StringChecker();
    @Test
    public void findLessThanAverage() throws Exception {
        String[] input = {"123", "1234", "12345"};
        String[] expResult = {"123"};
        String[] actResult = sc.findLessThanAverage(input);
        assertArrayEquals(expResult, actResult);

    }

    @Test
    public void findAverage() throws Exception {
        //Arrange
        String[] input = {"123", "1234", "12345"};
        int expResult = 4;

        //Act
        int actResult = sc.findAverage(input);

        //Assert
        assertEquals(expResult, actResult);
    }

}
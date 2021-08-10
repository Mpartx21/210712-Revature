import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StringExampleTest {

    @Test
    public void TestForCompareFirstAndLastCharactersAreSame(){
        StringExample stringExample = new StringExample();

        boolean actual = stringExample.compareFirstAndLastCharactersAreSame("ABAB");
        boolean expected = true;

        assertEquals(actual,expected);
//        assertTrue(actual);
//        assertFalse(actual);
    }
}

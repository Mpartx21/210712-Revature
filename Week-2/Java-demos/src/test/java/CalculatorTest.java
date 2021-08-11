
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

@Test
    public void addNumberTest(){
        //Arrange
        Calculator calculator = new Calculator();
        //Act
        int actual = calculator.addNumber(12,20);
        //Assert
        int expected = 32;
        assertEquals(expected,actual);
    }
@Test
    public void subNumberTest(){
        //A
        Calculator calculator = new Calculator();
        //A
        int actual = calculator.subNumber(10,546);
        //A
        int expected = -536;
        assertEquals(expected,actual);
    }
    @Test
    public void getCubeTest(){
        int actual=  new Calculator().getCube(3);

        int expected = 27;
        assertEquals(actual,expected);
        }
        @Test
        public void findMaxNumberTest(){
        Calculator c = new Calculator();

        int actual = c.findMaxNumber(new int[] {2,4,5,4,8,2,6,5,4,5,6});
        int ex = 8;
        assertEquals(actual,ex);
    }

    @Test
    public void testForReverseString(){
        assertEquals("cba", calculator.reverseString("abc"));
    }
}

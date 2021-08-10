
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

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

}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

    @Test
    public void testForGetArea(){
      //a
        Rectangle rectangle= new Rectangle();
      //a
        int actual = rectangle.getArea(10,30);
      //a
        assertEquals(300,actual);
    }

    @Test
    public void testForParameter(){
        Rectangle rectangle = new Rectangle();

        assertEquals(rectangle.getParameter(10,20),60);
    }
}

package addcal;

import addcal.CalNum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalNumTest {
    @Test
    void ValidNumTest() { // CalNum에 들어온 값이 유효한지.
        CalNum num1 = new CalNum(30);
        assertEquals(num1.Valid(), true);
    }

    @Test
    void AddTest() {
        CalNum num1 = new CalNum(10);
        CalNum num2 = new CalNum(20);
        num1.add(num2);
        assertEquals(num1.getNum(), 30);
    }


}

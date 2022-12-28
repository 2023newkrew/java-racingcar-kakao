package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    public void moveTest(){
        Car car = new Car("aaaa");
        assertEquals(car.move(true), 1);
    }
    @Test
    public void notMoveTest(){
        Car car = new Car("aaaa");
        assertEquals(car.move(false), 0);
    }
}

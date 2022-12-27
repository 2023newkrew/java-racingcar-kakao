import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.model.Car;
import racing_car.model.GameControl;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("제공된 문자열로 자동차 배열 생성")
    void separateByComma() {
        String testNames = "pobi,crong,honux";
        Car[] cars = Car.from(testNames);
        assertArrayEquals(cars, new Car[] {
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        });
    }

    @Test
    @DisplayName("차량 전진 제어")
    void carControl(){
        GameControl gameControl = new GameControl();
        Car car = new Car("pobi");

        int number = gameControl.generateRandomNumber();
        gameControl.carControl(car, number);

        String output = car.showDistance();
        assertEquals(output, "-".repeat(number >= 4 ? 1 : 0));
    }

    @Test
    @DisplayName("차량간 거리 비교")
    void compareCars() {
        Car a = new Car("pobi");
        Car b = new Car("crong");

        a.move(4);
        b.move(2);

        assertEquals(-1, b.compareTo(a));
    }

    @Test
    @DisplayName("우승자 구하기")
    void getWinner() {
        
    }

}

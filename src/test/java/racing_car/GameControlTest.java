package racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.model.Car;
import racing_car.model.GameControl;

import static org.junit.jupiter.api.Assertions.*;

public class GameControlTest {

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
    @DisplayName("빈 문자열 테스트")
    void emptyName() {
        String testNames = "";
        Car[] cars = Car.from(testNames);
        assertArrayEquals(cars, new Car[] {
                new Car("")
        });
    }

    @Test
    @DisplayName("차량 전진 제어")
    void carControl(){
        GameControl gameControl = new GameControl();
        Car car = new Car("pobi");

        gameControl.carControl(car);

        String output = car.showDistance();
        assertTrue(output.equals("-") || output.equals(""));
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
        String testNames = "pobi,crong,honux,ryan,chunsik,jordy";
        Car[] cars = Car.from(testNames);

        int[] distances = new int[] {1, 5, 2, 5, 4, 5};
        for (int i = 0; i < distances.length; i++) {
            cars[i].move(distances[i]);
        }

        GameControl gameControl = new GameControl();
        Car[] winners = gameControl.getWinners(cars);

        assertArrayEquals(new Car[] {
                cars[1], cars[3], cars[5]
        }, winners);
    }

}

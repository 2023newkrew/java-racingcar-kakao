package racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.model.Car;
import racing_car.model.Cars;
import racing_car.model.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    @DisplayName("우승자 구하기")
    void getWinners() {
        String[] testNames = {"pobi", "crong", "honux", "ryan", "chun", "jordy"};
        Car[] cars = new Car[testNames.length];

        int[] distances = new int[]{1, 5, 2, 5, 4, 5};
        for (int i = 0; i < distances.length; i++) {
            cars[i] = new Car(testNames[i]);
            cars[i].move(distances[i]);
        }

        Game game = new Game(Cars.of(cars));

        assertEquals(Cars.of(new Car[]{
                cars[1], cars[3], cars[5]
        }), game.getWinners());
    }
}

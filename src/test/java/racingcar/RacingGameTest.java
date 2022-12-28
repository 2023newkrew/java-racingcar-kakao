package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class RacingGameTest {

    @Test
    @DisplayName("can generate random number from 0 to 9")
    public void can_generate_random_number_from_0_to_9() {
        RacingGame game = new RacingGame(List.of(""));
        int randomNumber = -1;
        final int cycle = 10000;
        for (int i = 0; i < cycle; i++)
            randomNumber = game.generateRandomNumber();
            assertTrue(randomNumber >= 0);
            assertTrue(randomNumber <= 9);
    }

    @Test
    @DisplayName("can get only the farthest cars")
    public void can_get_the_farthest_cars() {
        RacingGame game = new RacingGame(List.of("a","b","c"));
        List<Car> farthestCars = game.getFarthestCars();

        int maxPosition = farthestCars.get(0).getPosition();
        for(Car car : farthestCars) {
            assertEquals(maxPosition, car.getPosition());
        }

        for(Car car : game.getCars()) {
            if(farthestCars.contains(car)) continue;
            assertTrue(car.getPosition() < maxPosition);
        }
    }
}

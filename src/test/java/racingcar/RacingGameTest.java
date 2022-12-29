package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class RacingGameTest {
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

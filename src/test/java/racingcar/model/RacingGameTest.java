package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {
    @Test
    @DisplayName("can get only the farthest cars")
    public void can_get_the_farthest_cars() {
        RacingGame game = new RacingGame(List.of("a", "b", "c"));
        for (int i = 0; i < 100; i++) {
            game.proceedTurn();
        }
        FarthestCars farthestCars = game.getFarthestCars();

        int farthestDistance = farthestCars.getCars().getCars().get(0).getDistance();
        for (Car car : farthestCars.getCars().getCars()) {
            assertEquals(farthestDistance, car.getDistance());
        }

        for (Car car : game.getCars().getCars()) {
            assertTrue(
                    car.getDistance() < farthestDistance
                    || car.getDistance() == farthestDistance
                            && farthestCars.getCars().getCars().contains(car)
            );
        }
    }
}

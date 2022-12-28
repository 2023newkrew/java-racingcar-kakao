package racing.service;

import racing.model.Car;
import racing.repository.RacingCarRepository;

public class RacingService {
    public void turn() {
        for (Car car : RacingCarRepository.getCars()) {
            car.tryMove();
        }
    }
}

package racing.service;

import racing.model.Car;
import racing.repository.RacingCarRepository;

public class RacingService {
    private final RacingCarRepository racingCarRepository;

    public RacingService(RacingCarRepository racingCarRepository){
        this.racingCarRepository = racingCarRepository;
    }
    public void turn() {
        for (Car car : racingCarRepository.getCars()) {
            car.tryMove();
        }
    }
}

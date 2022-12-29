package racingcar.service;

import racingcar.domain.Car;
import racingcar.service.dto.CarResponse;
import racingcar.service.dto.RoundResult;
import racingcar.service.dto.FinalResult;
import racingcar.utils.RacingCarConverter;
import racingcar.utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private int round;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(List<Car> cars, int gameRound) {
        this.cars = cars;
        this.round = gameRound;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public RoundResult doNextRound() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateBetweenZeroAndNine());
        }
        round -= 1;

        List<CarResponse> carResponses = RacingCarConverter.toCarResponses(cars);
        return new RoundResult(carResponses);
    }

    public FinalResult selectWinners() {
        Car maxPositionCar = calculateMaxPositionCar();
        List<CarResponse> carResponses = cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::toResponse)
                .collect(Collectors.toList());

        return new FinalResult(carResponses);
    }

    public Car calculateMaxPositionCar() {
        return cars.stream()
                .max(Car::comparePosition)
                .orElseThrow();
    }

    public boolean isFinish() {
        return round == 0;
    }
}

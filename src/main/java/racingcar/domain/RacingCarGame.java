package racingcar.domain;

import racingcar.dto.CarInfo;
import racingcar.utils.RacingCarConverter;
import racingcar.utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final List<Car> cars;
    private int leftRound;

    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(List<CarInfo> carDtos, int gameRound) {
        this.cars = RacingCarConverter.toCars(carDtos);
        this.leftRound = gameRound;
        this.randomNumberGenerator = new RandomNumberGenerator(10);
    }

    public GameResult doNextRound() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generate();
            car.move(() ->  randomNumber >= Threshold.NORMAL_THRESHOLD.value());
        }
        leftRound--;

        List<CarInfo> intermediateResult = RacingCarConverter.toCarDtos(cars);
        return new GameResult(intermediateResult);
    }

    public GameResult selectWinners() {
        Car maxPositionCar = calculateMaxPositionCar();
        List<CarInfo> finalResult = cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::toDto)
                .collect(Collectors.toList());

        return new GameResult(finalResult);
    }

    public Car calculateMaxPositionCar() {
        return cars.stream()
                .max(Car::comparePosition)
                .orElseThrow();
    }

    public boolean isFinish() {
        return leftRound == 0;
    }
}
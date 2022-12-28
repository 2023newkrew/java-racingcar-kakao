package racingcar.domain;

import racingcar.dto.CarDto;
import racingcar.utils.RacingCarConverter;
import racingcar.utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private int round;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(List<CarDto> carDtos, int gameRound) {
        this.cars = RacingCarConverter.toCars(carDtos);
        this.round = gameRound;
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public GameResult doNextRound() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateBetweenZeroAndNine());
        }
        round--;

        List<CarDto> intermediateResult = RacingCarConverter.toCarDtos(cars);
        return new GameResult(intermediateResult);
    }

    public GameResult selectWinners() {
        Car maxPositionCar = calculateMaxPositionCar();
        List<CarDto> finalResult = cars.stream()
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
        return round == 0;
    }
}

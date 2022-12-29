package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.dto.RoundResult;
import racingcar.dto.FinalResult;
import racingcar.utils.RacingCarConverter;
import racingcar.utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private int round;
    private RandomNumberGenerator randomNumberGenerator;

    public RacingCarGame(List<CarDto> carDtos, int gameRound) {
        cars = RacingCarConverter.toCars(carDtos);
        round = gameRound;
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public RoundResult doNextRound() {
        for (Car car : cars) {
            car.move(randomNumberGenerator.generateBetweenZeroAndNine());
        }
        round -= 1;

        List<CarDto> carStatusList = RacingCarConverter.toCarDtos(cars);
        return new RoundResult(carStatusList);
    }

    public FinalResult selectWinners() {
        Car maxPositionCar = calculateMaxPositionCar();
        List<CarDto> carStatusList = cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::toDto)
                .collect(Collectors.toList());

        return new FinalResult(carStatusList);
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

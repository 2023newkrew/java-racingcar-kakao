package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarDTO;
import racingcar.domain.car.RandomMovingAction;
import racingcar.util.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars = new ArrayList<>();
    private final RacingTurn turn;

    public Racing(String nameInput, String turn) {
        makeCars(StringParser.parse(nameInput));
        this.turn = new RacingTurn(turn);
    }

    public static boolean isDuplicateNames(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream().map(Car::toDTO).collect(Collectors.toList());
    }

    public void makeCars(List<String> carNames) {
        if (isDuplicateNames(carNames)) throw new IllegalArgumentException("");

        for (String carName : carNames)
            this.cars.add(new Car(carName));
    }

    public List<CarDTO> proceedTurn() {
        this.cars.forEach(car -> car.move(new RandomMovingAction()));
        turn.proceed();

        return getCarDTOs();
    }

    public boolean isEnd() {
        return turn.isEnd();
    }

    public RacingWinner getWinners() {
        if (!isEnd()) throw new IllegalStateException();

        return new RacingWinner(getCarDTOs());
    }
}

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
    private int turn = 0;

    public static boolean isValidTurn(int turn) {
        return turn > 0;
    }

    public static boolean isDuplicateNames(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream().map(Car::toDTO).collect(Collectors.toList());
    }

    public void init(String nameInput, String turn) {
        makeCars(StringParser.parse(nameInput));

        setTurn(turn);
    }

    public void makeCars(List<String> carNames) {
        if (isDuplicateNames(carNames)) throw new IllegalArgumentException("");

        for (String carName : carNames)
            this.cars.add(new Car(carName));
    }

    private void setTurn(String turn) {
        int parsedTurn = StringParser.parseTurn(turn);

        if (!isValidTurn(parsedTurn)) throw new IllegalArgumentException();

        this.turn = parsedTurn;
    }

    public List<CarDTO> proceedTurn() {
        this.cars.forEach(car -> car.move(new RandomMovingAction()));
        turn--;

        return getCarDTOs();
    }

    public boolean isEnd() {
        return turn == 0;
    }

    public RacingWinner getWinners() {
        if (!isEnd()) throw new IllegalStateException();

        return new RacingWinner(getCarDTOs());
    }
}

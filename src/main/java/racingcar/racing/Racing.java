package racingcar.racing;

import racingcar.car.Car;
import racingcar.car.CarDTO;
import racingcar.car.RandomMovingAction;
import racingcar.util.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars = new ArrayList<>();
    StringJoiner joiner = new StringJoiner(System.getProperty("line.separator"));
    private int turn = 0;

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

    public static boolean isDuplicateNames(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    private void setTurn(String turn) {
        int parsedTurn = StringParser.parseTurn(turn);

        if (!isValidTurn(parsedTurn)) throw new IllegalArgumentException();

        this.turn = parsedTurn;
    }

    public static boolean isValidTurn(int turn) {
        return turn > 0;
    }

    public String startRace() {
        for (int i = 0; i < turn; i++) {
            proceedTurn();
        }

        joiner.add(String.join(" ", getWinners(getCarDTOs())));

        return joiner.toString();
    }

    private void proceedTurn() {
        this.cars.forEach(car -> car.move(new RandomMovingAction()));

        getCarDTOs().forEach(car -> joiner.add(car.toString()));
        joiner.add("");
    }

    public static List<String> getWinners(List<CarDTO> cars) {
        int maxPosition = cars.stream()
                .mapToInt(CarDTO::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(CarDTO::getName)
                .collect(Collectors.toList());
    }
}

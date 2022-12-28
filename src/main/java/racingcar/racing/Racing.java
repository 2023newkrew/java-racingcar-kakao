package racingcar.racing;

import racingcar.car.Car;
import racingcar.car.CarAction;
import racingcar.car.CarDTO;
import racingcar.util.RandomGenerator;
import racingcar.util.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private static final int THRESHOLD = 4;

    private final List<Car> cars = new ArrayList<>();
    private int turn = 0;

    public int getCarNo() {
        return cars.size();
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream().map(Car::toDTO).collect(Collectors.toList());
    }

    public void init(String nameInput, String turn) {
        makeCars(StringParser.parse(nameInput));

        setTurn(turn);

        startRace();
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

    private void startRace() {
        for (int i = 0; i < turn; i++) {
            proceedTurn();
        }
        printResult();
    }

    private void proceedTurn() {
        this.cars.forEach(car -> {
            CarAction carAction = getActionResult(RandomGenerator.generateOneDigit());
            car.move(carAction);
        });
        printTurn();
    }

    public CarAction getActionResult(int no) {
        if (no < THRESHOLD) return CarAction.STAY;

        return CarAction.FORWARD;
    }

    public void printTurn() {
        RacingUI.displayPosition(getCarDTOs());
    }


    public void printResult() {
        List<String> result = getWinners(getCarDTOs());
        RacingUI.displayWinner(result);
    }

    public List<String> getWinners(List<CarDTO> cars) {
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

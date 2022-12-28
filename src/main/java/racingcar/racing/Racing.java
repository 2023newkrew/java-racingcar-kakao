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
    private final List<Car> cars = new ArrayList<>();
    private int turn = 0;
    private final RacingUI racingUi = new RacingUI();
    private final RacingService racingService = new RacingService();

    public int getCarNo() {
        return cars.size();
    }

    public void printTurn() {
        racingUi.displayPosition(getCarDTOs());
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream().map(Car::toDTO).collect(Collectors.toList());
    }

    public void printResult() {
        List<String> result = racingService.getWinners(getCarDTOs());
        racingUi.displayWinner(result);
    }

    public void init(String nameInput) {
        makeCars(StringParser.parse(nameInput));

        int turn = racingService.validateTurn(racingUi.getTurn());
        setTurn(turn);

        startRace();
    }

    private void startRace() {
        for (int i = 0; i < turn; i++) {
            proceedTurn();
        }
        printResult();
    }

    private void proceedTurn() {
        this.cars.forEach(car -> {
            int randNo = RandomGenerator.generateOneDigit();
            CarAction carAction = racingService.getActionResult(randNo);
            car.move(carAction);
        });
        printTurn();
    }

    public void makeCars(List<String> carNames) {
        if (isDuplicateNames(carNames)) throw new IllegalArgumentException("");

        for (String carName : carNames)
            this.cars.add(new Car(carName));
    }

    private void setTurn(int turn) {
        this.turn = turn;
    }

    public static boolean isDuplicateNames(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }
}

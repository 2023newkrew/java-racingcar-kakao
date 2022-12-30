package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.car.CarAction;
import racingcar.car.CarDTO;
import racingcar.util.RandomGenerator;

public class Racing {

    private final List<Car> cars;
    private int turn;
    private final RacingUI racingUI;
    private final RacingService racingService;

    public Racing() {
        cars = new ArrayList<>();
        turn = 0;
        racingUI = new RacingUI();
        racingService = new RacingService();
    }

    public int getCarNo() {
        return cars.size();
    }

    public void printTurn() {
        racingUI.displayPosition(getCarDTOs());
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream().map(Car::toDTO).collect(Collectors.toList());
    }

    public void printResult() {
        List<String> result = racingService.getWinners(getCarDTOs());
        racingUI.displayWinner(result);
    }

    public void startGame() {
        List<String> names = racingService.validateName(racingUI.getNames());
        setCars(names);

        int turn = racingService.validateTurn(racingUI.getTurn());
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

    public void setCars(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    private void setTurn(int turn) {
        this.turn = turn;
    }
}

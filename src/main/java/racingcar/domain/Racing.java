package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDTO;
import racingcar.view.RacingUI;

public class Racing {

    private final List<Car> cars;
    private int turn;
    private final RacingUI racingUI;
    private final RacingService racingService;
    private final MovingStrategy movingStrategy = new RandomMovingStrategy();

    public Racing(List<String> names, int turn) {
        this.cars = names.stream().map(Car::new).collect(Collectors.toList());
        this.turn = turn;
        racingUI = new RacingUI();
        racingService = new RacingService();
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

    private void startRace() {
        for (int i = 0; i < turn; i++) {
            proceedTurn();
        }
        printResult();
    }

    private void proceedTurn() {
        this.cars.forEach(car -> car.move(movingStrategy));
        printTurn();
    }
}

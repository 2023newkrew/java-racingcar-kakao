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
    private final MovingStrategy movingStrategy;

    public Racing(List<Car> cars, int turn) {
        this(cars, turn, new RandomMovingStrategy());
    }

    public Racing(List<Car> cars, int turn, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.turn = turn;
        racingUI = new RacingUI();
        racingService = new RacingService();
        this.movingStrategy = movingStrategy;
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream().map(Car::toDTO).collect(Collectors.toList());
    }

    public void printResult() {
        List<String> result = racingService.getWinners(getCarDTOs());
        racingUI.displayWinner(result);
    }

    private void decreaseTurn() {
        this.turn--;
    }

    public void proceedTurn() {
        this.cars.forEach(car -> car.move(movingStrategy));
        decreaseTurn();
    }

    public boolean isRacing() {
        return this.turn > 0;
    }

    public List<Car> getRaceStatus() {
        return this.cars;
    }
}

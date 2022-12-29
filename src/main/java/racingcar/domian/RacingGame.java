package racingcar.domian;

import racingcar.ui.OutputUI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private int turn;

    public RacingGame(List<String> carNameList, int turn) {
        for (String carName : carNameList) {
            this.carList.add(new Car(carName, 0));
        }
        this.turn = turn;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTurn() {
        return turn;
    }

    public void play() {
        for(int i = 0; i < turn; i++){
            playTurn();
            OutputUI.printTurnResult(carList);
        }

        OutputUI.printGameResult(getWinners());
    }

    private List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return carList.stream()
                .filter(x -> x.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }


    private void playTurn() {
        for (Car car : carList) {
            car.moveCar();
        }
    }
}

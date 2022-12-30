package racingcar.step2.domain;

import racingcar.step2.utils.NameSplit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private final ArrayList<Car> cars;
    private final int totalTurn;
    private int currentTurn = 0;

    public RacingGame(String nameCsv) {
        this(nameCsv, 1);

    }

    public RacingGame(String nameCsv, int totalTurn) {
        cars = new ArrayList<>();
        for(String name : new NameSplit().NameCsvToArray(nameCsv)){
            cars.add(new Car(name));
        }
        this.totalTurn = totalTurn;
    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    public int getMaxPosition(){
        return Collections.max(cars).getPosition();
    }

    public String getWinners(){
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(p -> Objects.equals(p.getPosition(), maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public void race(){
        currentTurn++;
        for (Car car: cars) {
            car.move();
        }
    }

    public boolean isEnd(){
        if (currentTurn >= totalTurn){
            return true;
        }
        return false;
    }
}

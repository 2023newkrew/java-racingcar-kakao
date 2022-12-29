package racingcar.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private final ArrayList<Car> cars;

    public RacingGame(String nameCsv) {
        cars = new ArrayList<>();
        for(String name : new NameSplit().NameCsvToArray(nameCsv)){
            cars.add(new Car(name));
        }
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
}

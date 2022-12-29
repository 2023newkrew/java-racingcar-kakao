package racingcar.step2.domain;

import java.util.ArrayList;
import java.util.Collections;

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
        int max = Collections.max(cars).getPosition();
        return max;
    }
}

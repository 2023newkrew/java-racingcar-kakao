package racingcar.step2.domain;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> cars;

    public RacingGame(String nameCsv) {
        cars = new ArrayList<>();
        for(String name : new NameSplit().NameCsvToArray(nameCsv)){
            cars.add(new Car(name));
        }
    }


    public ArrayList<Car> getCars() throws CloneNotSupportedException {
        ArrayList<Car> copyCars = new ArrayList<>();
        for (Car car : cars){
            copyCars.add(car.clone());
        }
        return copyCars;
    }
}

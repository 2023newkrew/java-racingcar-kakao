package racing.repository;

import racing.model.Car;
import racing.model.Cars;

import java.util.List;

public class RacingCarRepository {
    private static final Cars cars = new Cars();

    public static void saveCars(List<Car> carList){
        cars.addCars(carList);
    }

    public static Cars getCars(){
        return cars;
    }
}

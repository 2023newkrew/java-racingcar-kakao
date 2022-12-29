package racing.repository;

import racing.model.Car;
import racing.model.Cars;

import java.util.List;

public class RacingCarRepository {
    private final Cars cars;

    public RacingCarRepository(){
        this.cars = new Cars();
    }

    public RacingCarRepository(List<Car> cars){
        this.cars = new Cars(cars);
    }
    public List<String> findAllWinnerCarName() {
        return cars.getWinnerCarName();
    }

    public List<String> findAllCarStatus(){
        return cars.getAllCarStatusStrings();
    }

    public void saveCars(List<Car> cars){
        this.cars.addCars(cars);
    }

    public Cars getCars(){
        return cars;
    }
}

package racingcar.util;

import racingcar.model.RacingCar;
import racingcar.service.RacingCars;

import java.util.ArrayList;

public class RacingCarsGenerator {
    public static RacingCars generate(String[] carsName) {
        ArrayList<RacingCar> temp = new ArrayList<>();
        for (String carName : carsName) {
            temp.add(new RacingCar(carName));
        }
        return new RacingCars(temp);
    }
}

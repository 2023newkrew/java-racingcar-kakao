package racingcar.step2.view;

import racingcar.step2.domain.Car;

import java.util.ArrayList;

public class RacingOutputView {

    public void printCars(ArrayList<Car> cars){
        for (Car car: cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}

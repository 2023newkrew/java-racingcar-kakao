package racingcar.view;

import racingcar.domain.Car;

public class ResultView {
    public static void printRacingStart() {
        System.out.println("*** 경주 시작 ***");
    }
    public static void printCars(Car[] cars) {
        for (Car car: cars) {
            System.out.println(car.displayCurrentPosition());
        }
        System.out.println();
    }
}

package racingcar.view;

import racingcar.domain.Car;

public class ResultView {
    public static void printRacingStart() {
        System.out.println("*** 경주 시작 ***");
    }
    public static void printCars(Car[] cars) {
        for (Car car: cars) {
            printCarNameAndPosition(car);
        }
        System.out.println();
    }

    private static void printCarNameAndPosition(Car car) {
        System.out.println(car.name() + " : -" + "-".repeat(car.position()));
    }
}

package racingcar.view;

import racingcar.domain.Car;

public class ResultView {
    public static void printRacingStart() {
        System.out.println("*** 경주 시작 ***");
    }

    public static void printCars(Car[] cars) {
        for (Car car : cars) {
            printCarNameAndPosition(car);
        }
        System.out.println();
    }

    private static void printCarNameAndPosition(Car car) {
        System.out.println(car.name() + " : -" + "-".repeat(car.position()));
    }

    public static void printWinners(Car[] totalWinners) {
        String winnersNames = String.join(", ", extractNamesFromCars(totalWinners));

        System.out.println("!!!!! 최종 결과 !!!!!");
        System.out.println(winnersNames + " 가 최종 우승하였습니다!");
    }

    private static String[] extractNamesFromCars(Car[] cars) {
        String[] names = new String[cars.length];

        for (int i = 0; i < cars.length; i++) {
            names[i] = cars[i].name();
        }

        return names;
    }
}

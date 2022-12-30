package mvc.view;

import mvc.domain.Car;
import mvc.domain.CarConverter;

import java.util.List;

public abstract class OutputView {
    public static void printInit(List<Car> carList) {
        System.out.println("\n실행 결과");
        printCars(carList);
    }

    public static void printCars(List<Car> carList) {
        for (Car car : carList) {
            printOneCar(car);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(CarConverter.carListToNameStr(winners) + "가 최종 우승했습니다.");
    }

    private static void printOneCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

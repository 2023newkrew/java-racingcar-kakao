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

    public void printRaceStart(ArrayList<Car> cars){
        System.out.println("실행 결과");
        printCars(cars);
    }

    public void printWinners(String winners){
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}

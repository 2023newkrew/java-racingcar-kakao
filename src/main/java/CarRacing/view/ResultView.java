package CarRacing.view;

import CarRacing.domain.Car;

import java.util.List;

public class ResultView {
    public static void printResult(Car[] cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(",", winners)+ "가 최종 우승했습니다.");
    }
}

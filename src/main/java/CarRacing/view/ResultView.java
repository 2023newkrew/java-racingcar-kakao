package CarRacing.view;

import CarRacing.domain.Car;

import java.util.List;

public class ResultView {
    public static void printResult(Car[] cars) {
        System.out.println("실행 결과");
        for (int index = 0; index < cars.length; index++) {
            System.out.println(cars[index]);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        for (int index = 0; index < winners.size() - 1; index++) {
            System.out.print(winners.get(index) + ", ");
        }
        System.out.println(winners.get(winners.size()-1) + "가 최종 우승했습니다.");
    }
}

package racing_car.view;

import racing_car.model.Car;
import racing_car.model.Cars;
import racing_car.model.Racer;

import java.util.Scanner;

public class GameView {

    private final Scanner sc = new Scanner(System.in);

    public String getCarNamesWithDelimiter() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return sc.next();
    }

    public int getPlayCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");

        return sc.nextInt();
    }

    public void printGameProcess(Cars all) {
        all.getCars().forEach(car -> System.out.printf("%s : %s\n", car.getRacer().getName(), displayDistance(car)));
        System.out.println();
    }

    private String displayDistance(Car car) {
        return "-".repeat(car.getDistance());
    }

    public void printGameResult(Cars winners) {
        String[] winnerNames = winners.getCars().stream()
                .map(Car::getRacer)
                .map(Racer::getName)
                .toArray(String[]::new);
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }
}

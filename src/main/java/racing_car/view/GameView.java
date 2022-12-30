package racing_car.view;

import racing_car.model.Car;
import racing_car.model.Racing;

import java.util.Arrays;
import java.util.Scanner;

public class GameView {
    static Scanner scanner = new Scanner(System.in);

    public static String getNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void printGameProcess(Car[] cars) {
        for (Car car: cars) {
            System.out.print(car.name() + " : " + "-".repeat(car.distance()) + "\n");
        }
        System.out.println();
    }

    public static void printGameResult(Car[] cars) {
        String[] winnerNames = Arrays.stream(cars).map(Car::name).toArray(String[]::new);
        System.out.println(String.join(", ", winnerNames) +  "가 최종 우승했습니다.");
    }
}

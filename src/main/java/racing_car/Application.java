package racing_car;

import racing_car.model.Car;
import racing_car.model.GameControl;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameControl gameControl = new GameControl();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();

        Car[] cars = Car.from(input);

        System.out.println("시도할 회수는 몇회인가요?");
        int iter = sc.nextInt();

        System.out.println("실행결과");
        for (int i = 0; i < iter; i++) {
            for (Car car: cars) {
                gameControl.carControl(car);
                System.out.print(car.getName() + " : " + car.showDistance() + "\n");
            }
            System.out.println();
        }

        Car[] winner = gameControl.getWinners(cars);
        String[] winnerNames = Arrays.stream(winner).map(Car::getName).toArray(String[]::new);
        System.out.println(String.join(", ", winnerNames) +  "가 최종 우승했습니다.");
    }
}

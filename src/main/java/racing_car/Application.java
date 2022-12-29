package racing_car;

import racing_car.model.Car;
import racing_car.model.GameControl;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameControl gameControl = new GameControl();
        Car[] cars = getCars(sc);
        int iter = getIter(sc);

        System.out.println("실행결과");
        for (int i = 0; i < iter; i++) {
            printGameProcess(gameControl, cars);
        }
        printGameResult(gameControl, cars);
    }

    private static Car[] getCars(Scanner sc) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();

        return Car.from(input);
    }

    private static int getIter(Scanner sc) {
        System.out.println("시도할 회수는 몇회인가요?");
        return sc.nextInt();
    }

    private static void printGameResult(GameControl gameControl, Car[] cars) {
        Car[] winner = gameControl.getWinners(cars);
        String[] winnerNames = Arrays.stream(winner).map(Car::name).toArray(String[]::new);
        System.out.println(String.join(", ", winnerNames) +  "가 최종 우승했습니다.");
    }

    private static void printGameProcess(GameControl gameControl, Car[] cars) {
        for (Car car: cars) {
            gameControl.carControl(car);
            System.out.print(car.name() + " : " + car.showDistance() + "\n");
        }
        System.out.println();
    }
}

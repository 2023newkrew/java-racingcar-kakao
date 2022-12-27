package racing_car;

import racing_car.model.Car;
import racing_car.model.Game;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(getCars());
        int playCount = getPlayCount();

        System.out.println("실행결과");
        for (; playCount > 0; --playCount) {
            game.moveAllCars();
            printGameProcess(game);
        }

        printGameResult(game);
    }

    private static Car[] getCars() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();

        return Car.from(input);
    }

    private static int getPlayCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");

        return sc.nextInt();
    }

    private static void printGameResult(Game game) {
        Car[] winner = game.getWinners();
        String[] winnerNames = Arrays.stream(winner).map(Car::getName).toArray(String[]::new);
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    private static void printGameProcess(Game game) {
        Arrays.stream(game.getCars()).forEach(car -> System.out.print(car.getName() + " : " + car.showDistance() + "\n"));
        System.out.println();
    }
}

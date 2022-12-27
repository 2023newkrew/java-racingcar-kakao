package racingCar;

import java.util.Scanner;

public class Main {
    public static Car[] namesToCars(String input) {
        String[] names = input.split(",");
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public static String carsToNames(Car[] cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car: cars) {
            sb.append(car.getName()).append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameString = sc.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int totalTurns = sc.nextInt();
        System.out.println("\n실행 결과");
        Car[] cars = Main.namesToCars(carNameString);
        Game game = new Game(totalTurns, cars);
        // 출력
        Car[] winners = game.findWinners();
        System.out.printf("%s가 최종 우승했습니다.\n", Main.carsToNames(winners));
    }
}

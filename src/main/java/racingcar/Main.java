package racingcar;

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

    private static Car[] getCars(){
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameString = sc.nextLine();
        return Main.namesToCars(carNameString);
    }

    private static int getTotalTurns() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        int totalTurns = sc.nextInt();
        return totalTurns;
    }

    public static void main(String[] args) {
        Car[] cars = getCars();
        int totalTurns = getTotalTurns();
        Game game = new Game(totalTurns, cars);

        System.out.println("\n실행 결과");
        game.printCars();
        while (!game.isEnd()) {
            game.play();
        }
        game.printWinners();
    }
}

package racingcar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String carNameStr = scanCarNameStr();
        int totalTurns = scanTotalTurns();
        Game game = new Game(totalTurns, carNameStr.split(","));

        System.out.println("\n실행 결과");
        game.printCars();
        while (!game.isEnd()) {
            game.play();
        }
        game.printWinners();
    }

    private static String scanCarNameStr() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameStr = sc.nextLine();
        return carNameStr;
    }

    private static int scanTotalTurns() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        int totalTurns = sc.nextInt();
        return totalTurns;
    }
}

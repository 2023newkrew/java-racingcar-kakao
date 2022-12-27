package com.racing;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        initNames(game, scanner);
        runCount(game, scanner);
        printWinner(game);
    }

    private static void printWinner(Game game) {
        for (Car car : game.getWinner()) {
            car.printCarName();
            System.out.print(" ");
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private static void runCount(Game game, Scanner scanner) {
        System.out.println("시도할 횟수는 몇회인가요?");
        int runCount = scanner.nextInt();
        System.out.println();
        System.out.println("실행 결과");
        game.run(runCount);
    }

    private static void initNames(Game game, Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        game.init(scanner.nextLine());
    }
}

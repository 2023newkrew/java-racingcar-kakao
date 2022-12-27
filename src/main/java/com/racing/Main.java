package com.racing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 기본 game 객체를 생성
        Game game = new Game();
        // 사용자 입력을 받을 준비
        Scanner scanner = new Scanner(System.in);
        // 자동차들의 이름 목록을 사용자 입력으로 받고 game을 초기화함
        initNames(game, scanner);
        // 게임의 진행횟수를 받고 game을 횟수만큼 진행시킴
        runCount(game, scanner);
        // game 결과를 출력함
        printWinner(game);
    }

    /**
     * 게임의 결과를 출력하는 메서드
     */
    private static void printWinner(Game game) {
        // 모든 승자의 이름을 출력
        for (Car car : game.getWinner()) {
            car.printCarName();
            System.out.print(" ");
        }
        System.out.println("가 최종 우승했습니다.");
    }

    /**
     * 사용자 입력으로부터 게임을 n회 진행시키는 메서드
     */
    private static void runCount(Game game, Scanner scanner) {
        System.out.println("시도할 횟수는 몇회인가요?");
        // n회의 게임 단계 진행횟수를 받음
        int runCount = scanner.nextInt();
        System.out.println();
        System.out.println("실행 결과");
        game.run(runCount);
    }

    /**
     * 사용자 입력으로부터 자동차의 이름 목록을 받는 메서드
     */
    private static void initNames(Game game, Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        // 초기화
        game.init(scanner.nextLine());
    }
}

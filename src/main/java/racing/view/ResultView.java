package racing.view;

import racing.domain.RacingGame;

public class ResultView {
    public static void printSetup(RacingGame racingGame) {
        System.out.println("\n실행 결과");
        printCars(racingGame);
    }

    public static void printCars(RacingGame racingGame) {
        System.out.println(racingGame + "\n");
    }

    public static void printWinners(RacingGame racingGame) {
        System.out.println(racingGame.getWinners() + "가 최종 우승했습니다.");
    }
}

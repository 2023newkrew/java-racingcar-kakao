package carracing.view;

import carracing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printInitialStatus(List<Car> racingPlayers) {
        System.out.println("\n실행 결과");
        printCurrentStatus(racingPlayers);
    }

    public static void printCurrentStatus(List<Car> racingPlayers) {
        for (Car racingPlayer : racingPlayers) {
            printRacingPlayerStatus(racingPlayer);
        }
        System.out.println();
    }

    private static void printRacingPlayerStatus(Car racingPlayer) {
        System.out.println(racingPlayer.getName() + " : " + "-".repeat(racingPlayer.getPosition()));
    }

    public static void printWinners(List<Car> winners) {
        String concatenatedName = getConcatenatedNameFromList(winners);
        System.out.println(concatenatedName + "가 최종 우승했습니다.");
    }

    private static String getConcatenatedNameFromList(List<Car> winners) {
        return winners.stream().map(Car::getName).collect(Collectors.joining(", "));
    }
}

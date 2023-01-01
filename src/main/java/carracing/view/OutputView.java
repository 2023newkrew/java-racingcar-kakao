package carracing.view;

import carracing.domain.RacingPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printInitialStatus(List<RacingPlayer> racingPlayers) {
        System.out.println("\n실행 결과");
        printCurrentStatus(racingPlayers);
    }

    public static void printCurrentStatus(List<RacingPlayer> racingPlayers) {
        for (RacingPlayer racingPlayer : racingPlayers) {
            printRacingPlayerStatus(racingPlayer);
        }
        System.out.println();
    }

    private static void printRacingPlayerStatus(RacingPlayer racingPlayer) {
        System.out.println(racingPlayer.getName() + " : " + "-".repeat(racingPlayer.getPosition()));
    }

    public static void printWinners(List<RacingPlayer> winners) {
        String concatenatedName = getConcatenatedNameFromList(winners);
        System.out.println(concatenatedName + "가 최종 우승했습니다.");
    }

    private static String getConcatenatedNameFromList(List<RacingPlayer> winners) {
        return winners.stream().map(RacingPlayer::getName).collect(Collectors.joining(", "));
    }
}

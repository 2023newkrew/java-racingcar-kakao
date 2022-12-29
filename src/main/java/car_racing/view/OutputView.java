package car_racing.view;

import car_racing.domain.RacingPlayer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printCurrentStatus(List<RacingPlayer> racingPlayers) {
        for (RacingPlayer racingPlayer : racingPlayers) {
            System.out.println(racingPlayer.toString());
        }
        System.out.println();
    }

    public static void printWinners(RacingPlayer[] winners) {
        String concatenatedName = getConcatenatedNameFromArray(winners);
        System.out.println(concatenatedName + "가 최종 우승했습니다.");
    }

    private static String getConcatenatedNameFromArray(RacingPlayer[] winners) {
        return Arrays.stream(winners)
                .map(RacingPlayer::getName)
                .collect(Collectors.joining(", "));
    }
}

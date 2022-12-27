package car_racing.view;

import car_racing.model.RacingPlayer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void askForNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void askForNumberOfTurns() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printCurrentStatus(List<RacingPlayer> racingPlayers) {
        for (RacingPlayer racingPlayer :
                racingPlayers) {
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

package carracing.view;

import carracing.model.RacingPlayer;

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
        racingPlayers.forEach((player) -> System.out.println(player.toString()));
        System.out.println();
    }

    public static void printResultTitle() {
        System.out.println();
        System.out.println("실행결과");
    }

    public static void printWinners(List<RacingPlayer> winners) {
        String concatenatedName = getConcatenatedNameFromArray(winners);
        System.out.println(concatenatedName + "가 최종 우승했습니다.");
    }

    private static String getConcatenatedNameFromArray(List<RacingPlayer> winners) {
        return winners.stream()
                .map(RacingPlayer::getName)
                .collect(Collectors.joining(", "));
    }
}

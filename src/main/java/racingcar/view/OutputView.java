package racingcar.view;

import racingcar.domain.car.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void printTurnResult(List<RacingCar> cars) {
        StringBuilder sb = new StringBuilder();
        for (RacingCar rc : cars) {
            sb.append(carPosToOutputText(rc));
        }
        System.out.println(sb);
    }

    private static String carPosToOutputText(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        String displayName = (racingCar.getCarName().getName()+"     ").substring(0,5);
        sb.append(displayName).append(" : ");
        for (int i = 0; i <= racingCar.getPos(); i++) {
            sb.append("-");
        }
        return sb.append("\n").toString();
    }

    public static void printGameResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printWinners(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnerNames.add(winner.getCarName().getName());
        }
        sb.append(String.join(", ", winnerNames));
        System.out.println(sb + " 가 최종 우승했습니다.");
    }

}

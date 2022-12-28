package racingcar.view;

import racingcar.controller.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public String carPosToOutputText(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        sb.append(racingCar.getName()).append(" : ");
        for (int i = 0; i <= racingCar.getPos(); i++) {
            sb.append("-");
        }
        return sb.append("\n").toString();
    }

    public void printTurnResult(List<RacingCar> cars) {
        StringBuilder sb = new StringBuilder();
        for (RacingCar rc : cars) {
            sb.append(carPosToOutputText(rc));
        }
        System.out.println(sb);
    }

    public void printGameResultMessage() {
        System.out.println("실행 결과");
    }

    public void printWinners(List<RacingCar> winners) {
        // pobi, honux가 최종 우승했습니다.
        StringBuilder sb = new StringBuilder();
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnerNames.add(winner.getName());
        }
        sb.append(String.join(", ", winnerNames));
        System.out.println(sb + "가 최종 우승했습니다.");
    }

}

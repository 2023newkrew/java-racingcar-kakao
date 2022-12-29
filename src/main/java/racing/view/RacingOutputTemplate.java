package racing.view;

import java.util.List;

public class RacingOutputTemplate {

    public void printResultString() {
        System.out.println("\n실행 결과");
    }

    public void printCurrentStatus(List<String> carStatusStrings){
        for(String carStatus : carStatusStrings){
            System.out.println(carStatus);
        }
        System.out.println();
    }

    public void printWinners(List<String> winnerCarNames) {
        String winners = String.join(", ", winnerCarNames);
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}

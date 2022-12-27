package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RacingGameView {

    private final Scanner scanner;

    public RacingGameView() {
        this.scanner = new Scanner(System.in);
    }

    public String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int receiveRoundToPlay(){
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void printRoundResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(Map<String, Integer> roundResult) {
        for (Map.Entry<String, Integer> entry : roundResult.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            printMoveStatus(entry.getValue());
            System.out.println();
        }
        System.out.println();
    }

    private void printMoveStatus(Integer move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
    }

    public void printWinners(List<String> winners) {
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.get(winners.size() - 1) + "가 최종 우승했습니다.");
    }
}

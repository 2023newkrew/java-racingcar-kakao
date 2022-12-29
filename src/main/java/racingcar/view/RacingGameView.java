package racingcar.view;

import racingcar.controller.response.CarRoundResultResponse;
import racingcar.controller.response.CarWinnerResponse;

import java.util.List;
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
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String userInput = scanner.nextLine();
            return Integer.valueOf(userInput);
        } catch (NumberFormatException exception) {
            System.out.println("숫자를 입력해주세요");
            return receiveRoundToPlay();
        }
    }

    public void printRoundResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<CarRoundResultResponse> carRoundResults) {
        for (CarRoundResultResponse carRoundResult : carRoundResults) {
            System.out.print(carRoundResult.getCarName() + " : ");
            printMoveStatus(carRoundResult.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    private void printMoveStatus(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
    }

    public void printWinners(List<CarWinnerResponse> winners) {
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i).getCarName() + ", ");
        }
        System.out.print(winners.get(winners.size() - 1).getCarName() + "가 최종 우승했습니다.");
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}

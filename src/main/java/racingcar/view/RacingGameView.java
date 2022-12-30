package racingcar.view;

import racingcar.controller.response.CarRoundResultResponse;
import racingcar.controller.response.CarWinnerResponse;

import java.util.List;
import java.util.Scanner;

public class RacingGameView {

    private static final String NEWLINE = "\n";
    private static final String CAR_NAME_POSITION_SEPARATOR = " : ";
    private static final String MULTIPLE_WINNERS_SEPARATOR = ", ";

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
            return Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            System.out.println("숫자를 입력해주세요");
            return receiveRoundToPlay();
        }
    }

    public void printRoundResultMessage() {
        String resultMessage = NEWLINE + "실행 결과";
        System.out.println(resultMessage);
    }

    public void printRoundResult(List<CarRoundResultResponse> carRoundResults) {
        for (CarRoundResultResponse carRoundResult : carRoundResults) {
            printSingleCarRoundResult(carRoundResult);
        }
        System.out.println();
    }

    private void printSingleCarRoundResult(CarRoundResultResponse carRoundResult) {
        String carRoundResultStringBuilder = carRoundResult.getCarName() +
                CAR_NAME_POSITION_SEPARATOR +
                generatePositionStatus(carRoundResult.getPosition()) +
                NEWLINE;
        System.out.print(carRoundResultStringBuilder);
    }

    private String generatePositionStatus(int position) {
        return "-".repeat(position);
    }

    public void printWinners(List<CarWinnerResponse> winners) {
        String winnerResult = generateWinnerResult(winners);
        System.out.print(winnerResult);
    }

    private String generateWinnerResult(List<CarWinnerResponse> winners) {
        StringBuilder winnerStringBuilder = new StringBuilder();
        int maxIndex = winners.size() - 1;
        for (int i = 0; i < maxIndex; i++) {
            winnerStringBuilder.append(winners.get(i).getCarName());
            winnerStringBuilder.append(MULTIPLE_WINNERS_SEPARATOR);
        }
        winnerStringBuilder.append(winners.get(maxIndex).getCarName());
        winnerStringBuilder.append("가 최종 우승했습니다.");
        return winnerStringBuilder.toString();
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}

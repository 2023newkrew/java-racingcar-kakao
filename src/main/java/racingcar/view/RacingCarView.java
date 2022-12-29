package racingcar.view;

import racingcar.domain.GameResult;
import racingcar.domain.RoundRecord;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.CarWinnerDto;

import java.util.List;
import java.util.Scanner;

public class RacingCarView {

    private static final Scanner sc = new Scanner(System.in);

    private RacingCarView() {
    }

    public static List<String> receiveCarNamesCsv() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();
        return List.of(carNames.split(","));
    }

    public static int receiveRunNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(sc.next());
    }

    public static void printWinners(List<CarWinnerDto> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        winners.forEach(winner -> {
            stringBuilder.append(winner.getName());
            stringBuilder.append(", ");
        });
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println("실행 결과");
        gameResult.getRoundRecords()
                .forEach(RacingCarView::printRoundRecord);
    }

    private static void printCarStatus(CarStatusDto carStatusDto) {
        String carStatusMessage = carStatusDto.getCarName() +
                " : " +
                "-".repeat(carStatusDto.getCarPosition());
        System.out.println(carStatusMessage);
    }

    private static void printRoundRecord(RoundRecord roundRecord) {
        roundRecord.getCarStatusList()
                .forEach(RacingCarView::printCarStatus);
        System.out.println();
    }
}

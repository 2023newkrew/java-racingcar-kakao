package racingcar.view;

import racingcar.domain.collection.GameResult;
import racingcar.domain.collection.RaceRecord;
import racingcar.domain.dto.RacingCarDto;

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

    public static void printWinners(List<RacingCarDto> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        winners.forEach(winner -> {
            stringBuilder.append(winner.getCarName());
            stringBuilder.append(", ");
        });
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println("실행 결과");
        gameResult.getRaceRecords()
                .forEach(RacingCarView::printRaceRecord);
    }

    private static void printCar(RacingCarDto racingCar) {
        String carStatusMessage = racingCar.getCarName() +
                " : " +
                "-".repeat(racingCar.getCarPosition());
        System.out.println(carStatusMessage);
    }

    private static void printRaceRecord(RaceRecord raceRecord) {
        raceRecord.getCars()
                .forEach(RacingCarView::printCar);
        System.out.println();
    }
}

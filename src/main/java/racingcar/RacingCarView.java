package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCarView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static RacingCarView create() {
        return new RacingCarView();
    }

    private RacingCarView() {

    }

    public String inputNameLine() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Integer count;
        do {
            count = tryInputCount();
        } while (Objects.isNull(count));
        return count;
    }

    private Integer tryInputCount() {
        try {
            return Integer.valueOf(SCANNER.nextLine());
        } catch (NumberFormatException ignore) {
            System.out.println("숫자를 입력하셔야 합니다.");
            return null;
        }
    }

    public void printResultText() {
        System.out.println("실행 결과");
    }

    public void printProgressResult(List<CarDto> result) {
        for (CarDto carDto : result) {
            System.out.printf("%s : %s", carDto.getName(), "-".repeat(carDto.getPosition()));
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<CarDto> winners) {
        System.out.println(getWinnersName(winners) + "가 최종 우승했습니다.");
    }

    private String getWinnersName(List<CarDto> winners) {
        return winners.stream()
                .map(CarDto::getName)
                .collect(Collectors.joining(", "));
    }

    public void printError(String message) {
        System.out.println(message);
        System.out.println("다시 입력해주세요.");
    }
}

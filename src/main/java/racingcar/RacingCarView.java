package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarView {

    private final Scanner sc;

    public RacingCarView() {
        sc = new Scanner(System.in);
    }

    public List<String> receiveCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();
        return List.of(carNames.split(","));
    }

    public int receiveRunNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(sc.next());
    }

    public void printWinners(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car winner : winners) {
            stringBuilder.append(winner.getName() + ", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    public void printGameResult(CarListManager carListManager) {
        System.out.println(carListManager);
    }
}

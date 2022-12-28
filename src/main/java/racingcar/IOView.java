package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IOView {

    private Scanner scanner;

    public IOView() {
        this.scanner = new Scanner(System.in);
    }
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return parseCarNames(scanner.nextLine());
    }

    public List<String> parseCarNames(String s) {
        List<String> carNames = Arrays.asList(s.split(","));
        for(int i=0; i<carNames.size(); i++) {
            carNames.set(i,(carNames.get(i)+"     ").substring(0,5));
        }
        return carNames;
    }

    public int inputFinalTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = "a";
        while(!input.matches("[0-9]+")) {
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    public String carPosToOutputText(Car racingCar) {
        StringBuilder sb = new StringBuilder();
        sb.append(racingCar.getName()).append(" : ");
        for(int i = 0; i<=racingCar.getPosition(); i++) {
            sb.append("-");
        }
        return sb.append("\n").toString();
    }

    public void printTurnResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for(Car rc : cars) {
            sb.append(carPosToOutputText(rc));
        }
        System.out.println(sb);
    }

    public void printGameResultMessage() {
        System.out.println("실행 결과");
    }

    public void printWinners(List<Car> winners) {
        // pobi, honux가 최종 우승했습니다.
        StringBuilder sb = new StringBuilder();
        List<String> winnerNames = new ArrayList<>();
        for(Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        sb.append(String.join(", ",winnerNames));
        System.out.println(sb+"가 최종 우승했습니다.");
    }

}

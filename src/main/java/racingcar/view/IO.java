package racingcar.view;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IO {

    private Scanner scanner;
    static final String REGEX_INTEGER = "[0-9]+";

    public IO() {
        this.scanner = new Scanner(System.in);
    }

    public String validateCarName(String name) {
        return (name + "     ").substring(0, 5);
    }

    public List<String> parseCarNames(String names) {
        List<String> carNames = Arrays.asList(names.split(","));
        for (int i = 0; i < carNames.size(); i++) {
            carNames.set(i, this.validateCarName(carNames.get(i)));
        }
        return carNames;
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return this.parseCarNames(scanner.nextLine());
    }

    public int inputTurnIteration() {
        String turnIteration = "";
        while (turnIteration.isEmpty() || !turnIteration.matches(IO.REGEX_INTEGER)) {
            System.out.println("시도할 회수는 몇회인가요?");
            turnIteration = scanner.nextLine();
        }
        return Integer.parseInt(turnIteration);
    }

    public String generateCarPositionText(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i <= car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.append("\n").toString();
    }

    public void outputTurnResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(this.generateCarPositionText(car));
        }
        System.out.println(sb);
    }

    public void outputGameResultMessage() {
        System.out.println("실행 결과");
    }

    public void outputWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        sb.append(String.join(", ", winnerNames));
        System.out.println(sb.append("가 최종 우승했습니다."));
    }

}

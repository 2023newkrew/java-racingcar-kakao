package racingcar.view;

import racingcar.domain.RacingCars;

import java.util.Scanner;

public class RacingGameInputView {

    private final Scanner scanner;

    public RacingGameInputView() {
        this.scanner = new Scanner(System.in);
    }

    public RacingCars readRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.next();
        return new RacingCars(input.split(","));
    }

    public int readRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}

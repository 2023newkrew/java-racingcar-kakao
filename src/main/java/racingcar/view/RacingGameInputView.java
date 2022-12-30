package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameInputView {

    private final Scanner scanner;

    public RacingGameInputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<RacingCar> readRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.next();
        return convertToRacingCars(input.split(","));
    }

    public void close() {
        scanner.close();
    }

    private List<RacingCar> convertToRacingCars(String[] racingCarNames) {
        return Arrays.stream(racingCarNames)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public int readRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}

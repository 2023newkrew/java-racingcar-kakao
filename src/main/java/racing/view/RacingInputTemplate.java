package racing.view;

import racing.service.RacingValidator;

import java.util.Scanner;

public class RacingInputTemplate {
    private final Scanner scanner;
    private final RacingValidator racingValidator;

    public RacingInputTemplate(){
        scanner = new Scanner(System.in);
        racingValidator = new RacingValidator();
    }

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public Integer inputAttempt(){
        int attempt;
        System.out.println("시도할 횟수는 몇회인가요?");
        attempt = scanner.nextInt();

        racingValidator.attemptValidate(attempt);
        return attempt;
    }
}

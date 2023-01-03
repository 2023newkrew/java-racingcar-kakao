package racing.view;

import racing.exception.ErrorCode;
import racing.exception.RacingException;

import java.util.Scanner;

public class RacingInputTemplate {
    private final Scanner scanner;

    public RacingInputTemplate(){
        this(new Scanner(System.in));
    }

    public RacingInputTemplate(Scanner scanner){
        this.scanner = scanner;
    }

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public Integer inputAttempt(){
        String attempt;
        System.out.println("시도할 횟수는 몇회인가요?");
        attempt = scanner.nextLine().trim();

        attemptValidate(attempt);
        return Integer.parseInt(attempt);
    }

    private void attemptValidate(String attempt){
        try{
            int attemptNum = Integer.parseInt(attempt);
            if(attemptNum < 0){
                throw new RacingException(ErrorCode.NEGATIVE_ATTEMPT);
            }
        }catch (NumberFormatException numberFormatException){
            throw new RacingException(ErrorCode.NOT_IN_NUMBER_FORMAT);
        }


    }
}

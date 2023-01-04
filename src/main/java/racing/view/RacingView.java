package racing.view;

import racing.exception.ErrorCode;
import racing.exception.RacingException;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.Scanner;

public class RacingView {
    private final Scanner scanner;

    public RacingView(){
        scanner = new Scanner(System.in);
    }

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public Integer inputAttempt(){
        int attempt;
        System.out.println("시도할 횟수는 몇회인가요?");
        attempt = scanner.nextInt();

        if(attempt < 0) {
            throw new RacingException(ErrorCode.NEGATIVE_ATTEMPT);
        }
        return attempt;
    }

    public void printResultString() {
        System.out.println("\n실행 결과");
    }

    public void printRacingStatus(Cars cars){
        for(Car car : cars){
            System.out.println(car);
        }
        System.out.println();
    }

    public void printWinners(String winnerCarNames) {
        System.out.println(winnerCarNames + "가 최종 우승했습니다.");
    }
}

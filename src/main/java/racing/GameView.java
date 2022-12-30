package racing;

import java.util.List;


import java.util.Scanner;
import racing.domain.ImmutableCar;

import static racing.util.PrintUtils.*;


public class GameView {

    private final Scanner scanner;

    private static final String REQUEST_CAR_INPUT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_TRY_NUM_INPUT = "시도할 회수는 몇회인가요?";

    public GameView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] receiveCarNamesFromUser() {
        System.out.println(REQUEST_CAR_INPUT);
        return scanner.nextLine().split(",");
    }

    public int receiveTryCountFromUser() {
        System.out.println(REQUEST_TRY_NUM_INPUT);
        return scanner.nextInt();
    }
    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printStatus(List<ImmutableCar> cars) {
        cars.forEach(this::printCarStatus);
        System.out.println();
    }

    private void printCarStatus(ImmutableCar car) {
        System.out.println(car.getName() + " : " + getHyphen(car.getPosition()));
    }

    public void printFinish(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + " 가 최종 우승했습니다.");
    }
}

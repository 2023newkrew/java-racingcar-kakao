package racing.view;

import racing.domain.Simulator;

import java.util.Random;
import java.util.Scanner;

public class RacingView {
    static Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println("경주 할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputTimes() {
        System.out.println("시도 할 회수는 몇 회 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public void printResults(Simulator simulator) {
        System.out.println("\n실행 결과");
        System.out.println(simulator.getProgress() + "\n");
        System.out.println(simulator.winners() + "가 최종 우승했습니다.");
    }
}

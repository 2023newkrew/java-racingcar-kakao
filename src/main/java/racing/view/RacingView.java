package racing.view;

import racing.domain.Simulator;

import java.util.Scanner;

public class RacingView {
    static Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public int inputTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public void printStartSimulator(Simulator simulator) {
        System.out.println("\n실행 결과");
        printSimulator(simulator);
    }

    public void printSimulator(Simulator simulator) {
        System.out.println(simulator + "\n");
    }

    public void printWinners(Simulator simulator) {
        System.out.println(simulator.winners() + "가 최종 우승했습니다.");
    }
}

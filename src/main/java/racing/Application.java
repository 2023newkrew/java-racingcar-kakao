package racing;

import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);

    public static void run(String names, int times) {
        Simulator simulator = new Simulator();
        simulator.create(names);

        System.out.println("\n실행 결과");
        System.out.println(simulator + "\n");
        for (int i = 0; i < times; i++) {
            simulator.run(new Random());
            System.out.println(simulator + "\n");
        }

        System.out.println(simulator.winners() + "가 최종 우승했습니다.");
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int times = Integer.parseInt(scanner.nextLine());

        run(names, times);
    }
}

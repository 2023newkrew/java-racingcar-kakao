package racing;

import java.util.Random;

public class Runner {
    public void run(String names, int times) {
        Simulator simulator = new Simulator();
        simulator.create(names);

        System.out.println("\n실행 결과");
        System.out.println(simulator + "\n");
        for (int i = 0; i < times; i++) {
            simulator.run(new Random());
            System.out.println(simulator + "\n");
        }

        System.out.println(simulator.getWinners() + "가 최종 우승했습니다.");
    }
}

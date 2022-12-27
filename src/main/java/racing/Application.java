package racing;

import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int times = Integer.parseInt(scanner.nextLine());

        Runner runner = new Runner();
        runner.run(names, times);
    }
}

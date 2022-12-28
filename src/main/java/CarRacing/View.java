package CarRacing;

import java.util.List;
import java.util.Scanner;

public class View {
    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        return inputString;
    }

    public int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        String inputCount = scanner.nextLine();

        return Integer.parseInt(inputCount);
    }

    public void printText() {
        System.out.println("실행 결과");
    }

    public void printResult(Car[] cars) {
        for (int index = 0; index < cars.length; index++) {
            System.out.println(cars[index]);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        for (int index = 0; index < winners.size() - 1; index++) {
            System.out.print(winners.get(index) + ", ");
        }
        System.out.println(winners.get(winners.size()-1) + "가 최종 우승했습니다.");
    }
}

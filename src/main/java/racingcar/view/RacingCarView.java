package racingcar.view;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingCarView {

    public static List<String> inputCarNames() throws RuntimeException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        List<String> names = Arrays.asList(sc.nextLine().split(","));

        checkCarName(names);
        return names;
    }

    private static void checkCarName(List<String> names) throws RuntimeException {
        names.forEach(s -> {
            if (s == null || s.length() == 0) throw new IllegalArgumentException();
            if (s.length() > 5) throw new IllegalArgumentException();
        });
    }

    public static int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return (new Scanner(System.in)).nextInt();
    }

    public static void printResultOfCars(List<Car> cars) {
        cars.forEach(RacingCarView::printResultOfACar);
        System.out.println();
    }

    private static void printResultOfACar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getDistance(); i++)
            System.out.print("-");
        System.out.println();
    }

    public static void resultMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        winners.forEach(w -> sb.append(w).append(", "));
        sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}

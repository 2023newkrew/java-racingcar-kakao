package racingcar;

import javax.management.RuntimeMBeanException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingCarView {

    public List<String> inputCarNames() throws RuntimeException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분).");
        Scanner sc = new Scanner(System.in);
        List<String> names = Arrays.asList(sc.nextLine().split(","));

        checkCarName(names);
        return names;
    }

    private void checkCarName(List<String> names) throws RuntimeException {
        names.forEach(s -> {
            if(s.length() > 5) throw new RuntimeException();
        });
    }

    public int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return (new Scanner(System.in)).nextInt();
    }

    public void printResultOfCars(List<Car> cars){
        cars.forEach(this::printResultOfACar);
    }

    public void printResultOfACar(Car car){
        System.out.print(car.getName() + " : ");
        for(int i = 0; i < car.getDistance(); i++)
            System.out.print("-");
        System.out.println();
    }

    public void resultMessage() {
        System.out.println("실행 결과");
    }

    public void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        winners.forEach(w -> {
            sb.append(w).append(", ");
        });
        sb.delete(sb.length()-2, sb.length()-1);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }
}

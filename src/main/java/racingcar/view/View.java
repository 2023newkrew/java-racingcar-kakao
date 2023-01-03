package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class View {
    public void printInputNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printInputRoundNumberMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRoundResult(List<Car> roundResult) { //라운드의 결과를 출력한다
        for (Car car : roundResult) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) { //경기의 승자를 출력한다
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
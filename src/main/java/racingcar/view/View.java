package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class View {
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
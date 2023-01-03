package mvc.view;

import mvc.domain.Car;

import java.util.List;

public class OutputView {
    public void printInit(List<Car> carList) {
        System.out.println("\n실행 결과");
        printCars(carList);
    }

    public void printCars(List<Car> carList) {
        for (Car car : carList) {
            printOneCar(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.println(extractCarNameStr(winners) + "가 최종 우승했습니다.");
    }

    private void printOneCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private String extractCarNameStr(List<Car> carList) {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.getName()).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

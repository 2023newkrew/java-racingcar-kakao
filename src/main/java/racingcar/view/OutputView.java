package racingcar.view;

import java.util.List;

public class OutputView {
    public void printStartMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printAskRunCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRunResult(List<String> carResults) {
        System.out.println("실행 결과");
        printEachRunResult(carResults);
    }

    private void printEachRunResult(List<String> carResults) {

    }
}

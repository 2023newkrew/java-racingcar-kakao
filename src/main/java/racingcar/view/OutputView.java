package racingcar.view;

public class OutputView {

    private static final String RESULT_TITLE = "\n실행 결과";

    public void print(String... results) {
        for (String result : results) {
            System.out.println(result);
        }
    }

    public void printInitialStatus(String result) {
        print(RESULT_TITLE, result);
    }

}

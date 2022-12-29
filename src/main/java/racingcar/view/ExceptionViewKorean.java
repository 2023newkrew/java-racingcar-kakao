package racingcar.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ExceptionViewKorean implements ExceptionView {

    private static final String[] EXCEPTION_NAME
            = {"InvalidInputException", "InvalidRacingConditionException", "NumberFormatException"};
    private static final String[][] ERROR_MESSAGE = {
            {"알 수 없는 오류가 발생했습니다.",
            "이름의 길이는 1 이상 5 이하여야 합니다.",
            "차는 두 대 이상이어야 합니다.",
            "차의 이름은 중복될 수 없습니다.",
            "시도 횟수는 양의 정수여야 합니다."},

            {"알 수 없는 오류가 발생했습니다.",
            "이미 경기가 끝났습니다.",
            "경기가 아직 끝나지 않았습니다.",
            "라운드 횟수는 1 이상이어야 합니다.",
            "경기에 참여하는 차의 개수는 2개 이상이어야 합니다.",
            "중복된 차가 있습니다."},

            {"올바른 형식으로 입력하세요."},

            {"알 수 없는 오류가 발생했습니다."} // not found
    };
    private final PrintStream errorStream;

    public ExceptionViewKorean(PrintStream errorStream){
        this.errorStream = errorStream;
    }
    @Override
    public void errorHandling(Exception e) {
        int exceptionIndex = getExceptionIndex(e);
        int errorMessageIndex;
        if (exceptionIndex == EXCEPTION_NAME.length){
            errorMessageIndex = 0;
        }
        else{
            errorMessageIndex = getErrorMessageIndex(e);
        }
        errorStream.println(ERROR_MESSAGE[exceptionIndex][errorMessageIndex]);
    }

    private int getExceptionIndex(Exception e){
        int[] s = IntStream.range(0,EXCEPTION_NAME.length)
                        .filter(index->e.getClass().toString().endsWith(EXCEPTION_NAME[index]))
                        .toArray();
        if (s.length == 0){ // not found;
            return EXCEPTION_NAME.length;
        }
        return s[0];
    }

    private int getErrorMessageIndex(Exception e){
        int index;
        try {
            index = Integer.parseInt(e.getMessage().split("\\:")[0].strip());
        } catch(Exception exception){
            index = 0;
        }
        return index;
    }
}

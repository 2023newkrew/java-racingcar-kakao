package racingcar.view;

public class Parser {
    private static final String NOTICE_PARSER_ERROR = "정수로 변환될 수 없는 문자열입니다.";
    public static final int INTEGER_PARSER_ERROR = -1;
    public static int parseInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println(NOTICE_PARSER_ERROR);
            return INTEGER_PARSER_ERROR;
        }
        return Integer.parseInt(input);
    }
}

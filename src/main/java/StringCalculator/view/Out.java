package stringCalculator.view;

public class Out {

    private final static String INPUT_STRING_REQUEST = "문자열을 입력해주세요. : ";
    private final static String BLANK_OR_NULL_RESPONSE = "합은 0입니다.";

    public static void printText(String msg) {
        System.out.println(msg);
    }

    public static void printInputStringRequest() {
        printText(INPUT_STRING_REQUEST);
    }

    public static void printBlankOrNullResponse() {
        printText(BLANK_OR_NULL_RESPONSE);
    }

    public static void printResult(int result) {
        printText("합은 " + result + "입니다.");
    }

}

/**
 * 사용자 입력이 허용되는 것인지 확인한다
 * 허용되지 않은 인풋은 안내 메시지를 출력한다
 */
package racingcar.utils;

public class Validate {
    public static boolean validateCarNames(String nameInput) {
        return lengthLessThan5(nameInput);
    }

    public static boolean validateRoundNumber(String roundNumInput) {
        return isPositiveInteger(roundNumInput);
    }

    private static boolean lengthLessThan5(String input) {
        String[] nameArr = input.split(",");
        boolean flag = true;
        for (String name : nameArr) {
            flag &= (name.length() <= 5 && name.length() > 0);
        }
        return flag;
    }

    private static boolean isPositiveInteger(String input) {
        try {
            int _input = Integer.parseInt(input);
            return isPositive(_input);
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static boolean isPositive(int input) {
        return input > 0;
    }
}
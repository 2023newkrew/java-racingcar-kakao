/**
 * 사용자 입력이 허용되는 것인지 확인한다
 * 허용되지 않은 인풋은 안내 메시지를 출력한다
 */
package racingcar;

public class Validate {
    public static boolean validateCarNames(String nameInput) {
        boolean flag = lengthLessThan5(nameInput);
        if (!flag) {
            System.out.println("자동차의 이름은 길이 1 이상 5 이하여야 합니다");
        }
        return flag;
    }

    public static boolean validateRoundNumber(String roundNumInput) {
        boolean flag = isPositiveInteger(roundNumInput);
        if (!flag) {
            System.out.println("1 이상의 정수를 입력해주세요");
        }
        return flag;
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

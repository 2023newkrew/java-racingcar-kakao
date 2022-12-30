package calculator.domain;

import static calculator.constant.MessageConstant.NEGATIVE_NUMBER_EXCEPTION;

public class Number {

    int number;

    public Number(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

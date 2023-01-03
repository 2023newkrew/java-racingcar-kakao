package racing_car.util;

import java.util.Objects;

public class Util {

    static public void validateName(String input) {
        if (input.length() < 1){
            throw new RuntimeException("이름은 한글자 이상이어야 합니다.");
        }
        if (input.length() > 5){
            throw new RuntimeException("이름은 다섯글자 이하여야 합니다.");
        }
    }

}

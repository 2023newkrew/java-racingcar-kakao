package str_calc.model;

import java.util.ArrayList;
import java.util.List;

public class IntegerConverter {
    private static int toInt(String token) {
        if ("".equals(token) || token == null) {
            return 0;
        }
        int intValue = Integer.parseInt(token);
        if (intValue < 0) throw new RuntimeException("음수를 입력할 수 없습니다.");
        return intValue;
    }

    public static List<Integer> toIntList(List<String> splitText) {
        List<Integer> intList = new ArrayList<>();
        for (String token : splitText) {
            intList.add(toInt(token));
        }
        return intList;
    }
}

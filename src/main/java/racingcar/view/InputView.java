package racingcar.view;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import stringutils.StringUtils;

public class InputView {

    private static final int MAXIMUM_LENGTH = 5;
    private static final Scanner scanner = new Scanner(System.in);


    public Set<String> inputName() {
        String[] names = scanner.nextLine().split(",");
        Set<String> resultNames = new LinkedHashSet<>();
        for (String name : names) {
            validate(name);
            isDuplicate(resultNames, name);
            resultNames.add(name);
        }
        return resultNames;
    }

    public int inputRunCount() {
        return scanner.nextInt();
    }

    private void validate(String name) {
        if (StringUtils.checkNullOrBlankReturnBoolean(name)) {
            throw new IllegalArgumentException("이름은 널이거나, 공백일수 없습니다.");
        }
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자가 넘을 수 없습니다.");
        }
    }

    private void isDuplicate(Set<String> names, String name) {
        if (names.contains(name)) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }
}

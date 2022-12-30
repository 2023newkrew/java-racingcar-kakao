package racingcar.view;

import static racingcar.view.InputViewErrorMessage.INPUT_NAME_DUPLICATE_EXCEPTION;
import static racingcar.view.InputViewErrorMessage.INPUT_NAME_LENGTH_EXCEPTION;
import static racingcar.view.InputViewErrorMessage.INPUT_NAME_NULL_OR_BLANK_ERROR_MESSAGE;

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
            throw new IllegalArgumentException(INPUT_NAME_NULL_OR_BLANK_ERROR_MESSAGE);
        }
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(INPUT_NAME_LENGTH_EXCEPTION);
        }
    }

    private void isDuplicate(Set<String> names, String name) {
        if (names.contains(name)) {
            throw new IllegalArgumentException(INPUT_NAME_DUPLICATE_EXCEPTION);
        }
    }
}

package racingcar.model;

public class NameStringVerify {
    private static final String DEFAULT_DELIMETER = ",";

    public static void veirfyNameString(String nameStr) {
        if (nameStr == null || nameStr.isBlank()) {
            throw new IllegalArgumentException("There should be at least 1 car name in string");
        }
    }
}

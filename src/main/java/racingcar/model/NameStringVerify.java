package racingcar.model;

public class NameStringVerify {
    private static final String DEFAULT_DELIMITER = ",";

    public static void verifyNameString(String nameStr) {
        verifyBlankNameString(nameStr);
        verifyEachCarName(nameStr);
    }

    private static void verifyBlankNameString(String nameStr) {
        if (nameStr == null || nameStr.isBlank()) {
            throw new IllegalArgumentException("There should be at least 1 car name in string");
        }
    }

    private static void verifyEachCarName(String nameStr) {
        final String[] nameArray = nameStr.split(DEFAULT_DELIMITER, -1);

        for (String name : nameArray) {
            CarNameVerify.verifyCarName(name);
        }
    }
}

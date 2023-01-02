package racingcar.model;

public class NameStringVerify {
    private static final String DEFAULT_DELIMETER = ",";

    public static void verifyNameString(String nameStr) {
        if (nameStr == null || nameStr.isBlank()) {
            throw new IllegalArgumentException("There should be at least 1 car name in string");
        }

        final String[] nameArray = nameStr.split(DEFAULT_DELIMETER, -1);

        for (String name : nameArray) {
            CarNameVerify.verifyCarName(name);
        }
    }
}

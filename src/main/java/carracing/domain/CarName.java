package carracing.domain;

public class CarName {
    private final static int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new RuntimeException("Name length should be longer than 0");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("Name length should be shorter than 6");
        }
    }

    public String getName() {
        return this.name;
    }
}

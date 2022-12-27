package racing.domain;

public class Name {

    private String name;

    private static final int MAX_LENGTH = 5;
    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new RuntimeException();
        }
    }

    public String getName() {
        return name;
    }
}

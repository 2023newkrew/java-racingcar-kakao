package racingcar;

public class Engine {
    public static final Engine defaultEngine = new Engine();

    private Engine() {
    }

    public boolean moveOrStop() {
        return false;
    }
}

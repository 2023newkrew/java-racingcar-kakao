package CarRacing.domain;

public class RacingLog {
    private String name;
    private int position;

    public RacingLog(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

package racingcar;

public class Position implements Comparable{
    private int val;

    public Position() {
        this.val = 1;
    }

    public void print(String carName) {
        System.out.println(carName + " : " + "-".repeat(this.val));
    }

    public void proceed() {
        this.val++;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Position)) {
            throw new RuntimeException();
        }
        return val - ((Position)o).val;
    }
}

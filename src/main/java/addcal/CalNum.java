package addcal;

public class CalNum {
    private int num;

    public CalNum(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수를 포함하면 안된다.");
        }
        this.num = num;
    }

    public void printNum() {
        System.out.println(num);
    }

    public int getNum() {
        return num;
    }

    public void add(CalNum operand) {
        num += operand.getNum();
    }
}

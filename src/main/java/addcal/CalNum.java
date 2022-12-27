package addcal;

public class CalNum {
    private int num;

    public CalNum(int num) {
        this.num = num;
    }

    public void printNum(){
        System.out.println(num);
    }
    public int getNum(){
        return num;
    }

    public void add(CalNum operand){
        num += operand.getNum();
    }

    public boolean Valid() {
        if (num < 0) return false;
        return true;
    }
}

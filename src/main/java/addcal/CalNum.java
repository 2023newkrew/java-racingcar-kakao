package addcal;

public class CalNum {
    private int num;

    public CalNum(int num) {
        this.num = num;
    }

<<<<<<< HEAD
    public void printNum() {
        System.out.println(num);
    }

    public int getNum() {
        return num;
    }

    public void add(CalNum operand) {
=======
    public void printNum(){
        System.out.println(num);
    }
    public int getNum(){
        return num;
    }

    public void add(CalNum operand){
>>>>>>> cfa8a91 (feat: Car)
        num += operand.getNum();
    }

    public boolean Valid() {
        if (num < 0) return false;
        return true;
    }
}

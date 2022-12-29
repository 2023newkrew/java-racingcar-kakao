package stringadder;

public class NumAdder {
    public static int add(int[] numArr) {
        int sum = 0;
        for (int num : numArr) {
            sum += num;
        }
        return sum;
    }
}

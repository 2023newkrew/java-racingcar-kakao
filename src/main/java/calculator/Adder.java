package calculator;

public class Adder {

    public static int run(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        return result;
    }
}

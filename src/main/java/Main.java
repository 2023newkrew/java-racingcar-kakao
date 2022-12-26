import java.util.Scanner;

public class Main {
    public static String inputString() {
        System.out.print("문자열을 입력해주세요. : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.startsWith("//")) {
            String input_2 = scanner.nextLine();
            input += "\n" + input_2;
        }
        return input;
    }

    public static boolean textException(String inputString) {
        if(inputString == null) return false;
        if(inputString.isEmpty()) return false;
        return true;
    }
}

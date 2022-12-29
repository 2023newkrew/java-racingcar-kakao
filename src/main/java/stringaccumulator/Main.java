package stringaccumulator;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();
        SeparatorParser parser = SeparatorParser.from(input);
        StringSplitter stringSplitter = StringSplitter.from(parser.parseSeparator());
        StringAccumulator stringAccumulator = StringAccumulator.from(stringSplitter);
        long sum = stringAccumulator.accumulate(parser.parseContent());
        System.out.println(sum);
    }
}

package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static String nameStringInput() throws IOException {
        String text;

        Output.printNoticeNameString();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        text = reader.readLine().replace("\\n","\n");

        return text;
    }

    public static int turnInput() throws IOException {
        String text;

        Output.printNoticeTurn();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        text = reader.readLine().replace("\\n","\n");

        return Integer.parseInt(text);
    }
}

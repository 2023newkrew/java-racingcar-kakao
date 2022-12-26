package str_calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOView {
    private BufferedReader br;

    public IOView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputText() {
        System.out.print("텍스트를 입력해주세요 : ");
        String text = null;
        try {
            text = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    public void printSum(int sum) {
        System.out.println("결과 : " + sum);
    }
}

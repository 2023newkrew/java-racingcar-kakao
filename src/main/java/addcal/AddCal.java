package addcal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCal {
    public String separator;
    private String processedInputString;

    public List<CalNum> calNumList;
    public CalNum resultNum;

    public AddCal(String inputString) {
        separator = parseCustomSeparator(inputString);
        calNumList = new ArrayList();
        calNumList = parse(processedInputString);
        resultNum = new CalNum(0);
    }


    public List<CalNum> parse(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            CalNum calnum = new CalNum(0);
            calNumList.add(calnum);
            return calNumList;
        }
        for (String num : inputString.split(separator)) {
            CalNum calnum = new CalNum(Integer.parseInt(num));
            calNumList.add(calnum);
        }
        return calNumList;
    }

    public boolean calNumListValid() {
        boolean flag = true;
        for (CalNum num : calNumList) {
            flag &= num.checkValid();
        }
        return flag;
    }

    public String parseCustomSeparator(String inputString) {
        //inputString = "//a\n1a2a3a4a5";
        inputString = inputString.replaceAll("\\n", "\n");
        if (inputString.equals("//a\n1a2a3a4a5")) {
            System.out.println("same");
        } else {
            System.out.println("89078");
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        String customSeparator = ",|;";
        processedInputString = inputString;
        if (m.find()) {
            customSeparator = m.group(1);
            processedInputString = m.group(2);
        }
        return customSeparator;
    }

    public void printResult() {
        System.out.print("result: ");
        resultNum.printNum();
    }

    public void add() {
        for (CalNum num : calNumList) {
            resultNum.add(num);
        }
    }


}

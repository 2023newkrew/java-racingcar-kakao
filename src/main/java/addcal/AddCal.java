package addcal;
<<<<<<< HEAD

=======
>>>>>>> cfa8a91 (feat: Car)
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
        separator = CustomSeparatorParse(inputString);
        calNumList = new ArrayList();
        calNumList = Parse(processedInputString);
        resultNum = new CalNum(0);
    }


    public List<CalNum> Parse(String inputString) {
<<<<<<< HEAD
        if (inputString == null || inputString.isEmpty()) {
=======
        if(inputString == null || inputString.isEmpty()) {
>>>>>>> cfa8a91 (feat: Car)
            CalNum calnum = new CalNum(0);
            calNumList.add(calnum);
            return calNumList;
        }
<<<<<<< HEAD
        for (String num : inputString.split(separator)) {
=======
        for(String num : inputString.split(separator)){
>>>>>>> cfa8a91 (feat: Car)
            CalNum calnum = new CalNum(Integer.parseInt(num));
            calNumList.add(calnum);
        }
        return calNumList;
    }
<<<<<<< HEAD

    public boolean calNumListValid() {
        boolean flag = true;
        for (CalNum num : calNumList) {
=======
    public boolean calNumListValid(){
        boolean flag = true;
        for (CalNum num : calNumList){
>>>>>>> cfa8a91 (feat: Car)
            flag &= num.Valid();
        }
        return flag;
    }

    public String CustomSeparatorParse(String inputString) {
        //inputString = "//a\n1a2a3a4a5";
<<<<<<< HEAD
        inputString = inputString.replaceAll("\\n", "\n");
        if (inputString.equals("//a\n1a2a3a4a5")) {
            System.out.println("same");
        } else {
=======
        inputString = inputString.replaceAll("\\n","\n");
        if(inputString.equals("//a\n1a2a3a4a5")) {
            System.out.println("same");
        }
        else {
>>>>>>> cfa8a91 (feat: Car)
            System.out.println("89078");
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        String customSeparator = ",|;";
        processedInputString = inputString;
<<<<<<< HEAD
        if (m.find()) {
=======
        if(m.find()) {
>>>>>>> cfa8a91 (feat: Car)
            customSeparator = m.group(1);
            processedInputString = m.group(2);
        }
        return customSeparator;
    }
<<<<<<< HEAD

    public void CalculatorInput() {

    }

    public void printResult() {
        System.out.print("result: ");
        resultNum.printNum();
    }

    public void Add() {
=======
    public void CalculatorInput(){

    }
    public void printResult(){
        System.out.print("result: ");
        resultNum.printNum();
    }
    public void Add(){
>>>>>>> cfa8a91 (feat: Car)
        for (CalNum num : calNumList) {
            resultNum.add(num);
        }
    }


}

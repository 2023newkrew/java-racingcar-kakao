package com.calc;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    private final String text;

    public Parser(String text) {
        this.text = text;
    }

    public Expression checkNull() {
        if (this.text == null) {
            return new Expression(new ArrayList<>(), new ArrayList<>(), ""); // 0이 나오는 값
        }
        if (this.text.isEmpty()) {
            return new Expression(new ArrayList<>(), new ArrayList<>(), ""); // 0이 나오는 값
        }
        return null;
    }

    public String separateHeader() {
        Matcher m = Pattern.compile("//(.)\n(.*)")
                .matcher(this.text);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    public String separateBody() {
        Matcher m = Pattern.compile("//(.)\n(.*)")
                .matcher(this.text);
        if (m.find()) {
            return m.group(2);
        }
        return this.text;
    }
    public Expression parsing() {

        Expression nullCheck = checkNull();
        if (nullCheck != null) return nullCheck;

        // //;\n 1:2:3 -> 헤더 분리
        String header = separateHeader();
        String body = separateBody();

        // method
        ArrayList<Separator> arrSep = getSeparators(body);

        // method
        ArrayList<Integer> splitValues = getSplitValues(body, arrSep);


        return new Expression(splitValues, arrSep, header);
    }

    private ArrayList<Integer> getSplitValues(String body, ArrayList<Separator> arrSep) {
        String sepRegex = changeToString(arrSep);

        String[] splitValues = body.split(sepRegex);
        return changeToArray(splitValues);
    }

    private ArrayList<Separator> getSeparators(String body) {
        ArrayList<Separator> arrSep = new ArrayList<>(); // arrSep = 사용한 구분자들
        for(int i = 0; i< body.length(); i++){
            arrSep.add(checkNumber(body.charAt(i)));
        }
        arrSep.removeIf(Objects::isNull);
        return arrSep;
    }

    public Separator checkNumber(char c){
        if(Character.isDigit(c)) return null;
        return new Separator(String.valueOf(c));
    }

    public String changeToString(ArrayList<Separator> separators){
        String sep = "";
        for(Separator separator : separators){
            sep += separator.toString() + "|";
        }
        return sep.equals("") ? sep : sep.substring(0, sep.length() - 1);
    }

    public ArrayList<Integer> changeToArray(String[] arr){
        ArrayList<Integer> ret = new ArrayList<>();
        for(String str : arr){
            ret.add(Integer.parseInt(str));
        }
        return ret;
    }
}

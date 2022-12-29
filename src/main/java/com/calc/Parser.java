package com.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        List<Separator> arrSep = getSeparators(body);

        // method
        List<Integer> splitValues = getSplitValues(body, arrSep);


        return new Expression(splitValues, arrSep, header);
    }

    private List<Integer> getSplitValues(String body, List<Separator> arrSep) {
        String sepRegex = changeToString(arrSep);

        String[] splitValues = body.split(sepRegex);
        return changeToArray(splitValues);
    }

    private List<Separator> getSeparators(String body) {
        return body.chars()
                .mapToObj(this::checkNumber)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Separator checkNumber(int c){
        if(Character.isDigit(c)) return null;
        return new Separator(String.valueOf(c));
    }

    public String changeToString(List<Separator> separators){
        return separators.stream()
                .map(Separator::toString)
                .collect(Collectors.joining("|"));
    }

    public List<Integer> changeToArray(String[] arr){
        return Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}

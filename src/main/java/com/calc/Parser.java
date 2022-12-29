package com.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {

    public Expression checkNull(String text) {
        if (text == null) {
            return Expression.createEmpty();
        }
        if (text.isEmpty()) {
            return Expression.createEmpty();
        }
        return null;
    }

    private String separateHeader(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)")
                .matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    private String separateBody(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)")
                .matcher(text);
        if (m.find()) {
            return m.group(2);
        }
        return text;
    }

    private List<Separator> parseSeparator(String text){
        return getSeparators(separateBody(text));
    }

    private List<Integer> splitValues(String text, List<Separator> arrSep){
        return getSplitValues(separateBody(text), arrSep);
    }

    public Expression parsing(String text) {

        checkNull(text);

        List<Separator> arrSep = parseSeparator(text);
        List<Integer> splitValues = splitValues(text, arrSep);

        return new Expression(splitValues, arrSep, separateHeader(text));
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

    private Separator checkNumber(int c){
        if(Character.isDigit(c)) return null;
        return new Separator(String.valueOf(c));
    }

    private String changeToString(List<Separator> separators){
        return separators.stream()
                .map(Separator::toString)
                .collect(Collectors.joining("|"));
    }

    private List<Integer> changeToArray(String[] arr){
        return Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}

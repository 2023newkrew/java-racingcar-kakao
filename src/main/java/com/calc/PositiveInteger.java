package com.calc;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositiveInteger implements Expression {
    public static final Pattern REGEX_PATTERN = Pattern.compile("^[1-9][0-9]*");
    public static final Parser PARSER = new Parser();
    private final int rawValue;

    public PositiveInteger(int rawValue) {
        if (rawValue <= 0) {
            throw new RuntimeException("must be positive integer");
        }
        this.rawValue = rawValue;
    }

    public static Map.Entry<Expression, String> parse(LanguageContext languageContext, String input) {
        return PARSER.parse(languageContext, input);
    }

    @Override
    public ExprKind kind() {
        return ExprKind.PositiveInteger;
    }

    @Override
    public int calculate() {
        return rawValue;
    }

    @Override
    public String toString() {
        return Integer.toString(rawValue);
    }

    public static class Parser implements com.calc.Parser {
        @Override
        public Map.Entry<Expression, String> parse(LanguageContext languageContext, String input) {
            Matcher matcher = REGEX_PATTERN.matcher(input);
            if (!matcher.find()) {
                throw new RuntimeException("not positive integer");
            }
            return Map.entry(new PositiveInteger(Integer.parseInt(matcher.group())), input.substring(matcher.end()));
        }
    }
}

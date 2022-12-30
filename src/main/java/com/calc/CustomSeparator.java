package com.calc;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Expression {
    public static final Parser PARSER = new Parser();
    private final Set<Character> separators;
    private final Expression value;

    public CustomSeparator(Set<Character> separators, Expression value) {
        this.separators = separators;
        this.value = value;
    }


    public static Map.Entry<Expression, String> parse(LanguageContext languageContext, String input) {
        return PARSER.parse(languageContext, input);
    }

    private static Map.Entry<Expression, String> parseBinOpOrValue(LanguageContext languageContext, String input) {
        Map.Entry<Expression, String> result;
        try {
            result = Separator.parse(languageContext, input);
        } catch (Exception e) {
            result = PositiveInteger.parse(languageContext, input);
        }
        return result;
    }

    @Override
    public ExprKind kind() {
        return ExprKind.CustomSeparator;
    }

    @Override
    public int calculate() {
        return this.value.calculate();
    }


    public static class Parser implements com.calc.Parser {
        public static final Pattern REGEX_PATTERN = Pattern.compile("^//(.)+\n");

        @Override
        public Map.Entry<Expression, String> parse(LanguageContext languageContext, String input) {
            Matcher matcher = REGEX_PATTERN.matcher(input);
            if (!matcher.find()) {
                throw new RuntimeException("not custom separator");
            }
            Set<Character> separators = new HashSet<>();
            for (char c : matcher.group(1)
                    .toCharArray()) {
                separators.add(c);
            }
            languageContext = new LanguageContext(languageContext, separators);
            input = input.substring(matcher.end());
            //
            Map.Entry<Expression, String> result = parseBinOpOrValue(languageContext, input);
            return Map.entry(new CustomSeparator(separators, result.getKey()), result.getValue());
        }
    }
}

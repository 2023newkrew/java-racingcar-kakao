package com.calc;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Separator implements Expression {
    public static final Parser PARSER = new Parser();
    public static final OrParser RIGHT_PARSER = new OrParser(List.of(
            Separator.PARSER,
            PositiveInteger.PARSER
    ));

    private final Expression rawLeftExpr;
    private final char separator;
    private final Expression rawRightExpr;

    public Separator(Expression rawLeftExpr, char separator, Expression rawRightExpr) {
        if (Objects.isNull(rawLeftExpr) || Objects.isNull(rawRightExpr)) {
            throw new RuntimeException("separator left and right expr must not null");
        }
        this.rawLeftExpr = rawLeftExpr;
        this.separator = separator;
        this.rawRightExpr = rawRightExpr;
    }

    public static Map.Entry<Expression, String> parse(LanguageContext languageContext, String input) {
        return PARSER.parse(languageContext, input);
    }

    @Override
    public ExprKind kind() {
        return ExprKind.Separator;
    }

    @Override
    public int calculate() {
        return rawLeftExpr.calculate() + rawRightExpr.calculate();
    }

    @Override
    public String toString() {
        return Objects.toString(rawLeftExpr) + separator + Objects.toString(rawRightExpr);
    }

    public static class Parser implements com.calc.Parser {
        @Override
        public Map.Entry<Expression, String> parse(LanguageContext languageContext, String input) {
            Map.Entry<Expression, String> left = PositiveInteger.parse(languageContext, input);
            char sep = left.getValue()
                    .charAt(0);
            if (!languageContext.isAllowedSeparator(sep)) {
                throw new RuntimeException("not allowed separator");
            }
            Map.Entry<Expression, String> right = RIGHT_PARSER.parse(languageContext, left.getValue()
                    .substring(1));
            return Map.entry(
                    new Separator(left.getKey(), sep, right.getKey()),
                    right.getValue()
            );
        }
    }
}

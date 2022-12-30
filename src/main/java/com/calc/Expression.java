package com.calc;

import java.util.Map;

public interface Expression {
    static Expression parse(String input) {
        LanguageContext languageContext = new LanguageContext();
        Map.Entry<Expression, String> result = parseCustomOrExpr(input, languageContext);
        if (!result.getValue()
                .isEmpty()) {
            throw new RuntimeException("remain string");
        }
        return result.getKey();
    }

    private static Map.Entry<Expression, String> parseCustomOrExpr(String input, LanguageContext languageContext) {
        Map.Entry<Expression, String> result;
        try {
            result = CustomSeparator.parse(languageContext, input);
        } catch (Exception e) {
            result = Separator.parse(languageContext, input);
        }
        return result;
    }

    ExprKind kind();

    //
    int calculate();

    enum ExprKind {
        Separator,
        CustomSeparator,
        PositiveInteger
    }
}

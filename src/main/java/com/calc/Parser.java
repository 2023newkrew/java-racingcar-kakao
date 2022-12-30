package com.calc;

import java.util.Map;

public interface Parser {

    Map.Entry<Expression, String> parse(LanguageContext languageContext, String input);
}

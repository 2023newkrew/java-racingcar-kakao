package com.calc;

public interface Expression {

    Kind kind();

    //
    int calculate();

    enum Kind {
        Separator,
        CustomSeparator,
        PositiveInteger
    }
}

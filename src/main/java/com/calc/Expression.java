package com.calc;

import java.util.List;

public class Expression {

    public final List<Integer> values;
    public final List<Separator> separators;
    public final String allowSep;

    public Expression(List<Integer> values, List<Separator> separators, String allowSep) {
        this.values = values;// separators; // Parser 만들어서 넘기는걸로
        this.separators = separators;// separators; // Parser 만들어서 넘기는걸로
        this.allowSep = allowSep; // Parser
    }

    public void checkSeparators(){
        for(Separator sep : separators){
            sep.checkDefaultSep();
            sep.checkCustomSep(this.allowSep);
        }
    }

    public void checkValues() {
        values.forEach(this::checkPositiveInteger);
    }

    public void checkPositiveInteger(int value){
        if(value < 0){
            throw new RuntimeException("positive integer");
        }
    }

    public int sumValues(){
        return this.values.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

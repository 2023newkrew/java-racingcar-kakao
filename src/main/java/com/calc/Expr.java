package com.calc;

import java.util.List;

public class Expr {

    public final List<Integer> values;
    public final List<Separator> separators;
    public final String allowSep;

    public Expr(List<Integer> values, List<Separator> separators, String allowSep) {
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
        for(Integer value : values){
            checkPositiveInteger(value);
        }
    }

    public void checkPositiveInteger(int value){
        if(value < 0){
            throw new RuntimeException("positive integer");
        }
    }

    public int sumValues(){
        int sum = 0;
        for(int value: this.values){
            sum += value;
        }
        return sum;
    }
}

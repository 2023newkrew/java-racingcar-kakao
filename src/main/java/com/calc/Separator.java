package com.calc;

public class Separator {
    private final String sep;

    public Separator(String sep) {
        this.sep = sep;
    }

    public void checkDefaultSep(){
        if(!(this.sep.equals(",") || this.sep.equals(":"))){
            throw new RuntimeException("default");
        }
    }


    public void checkCustomSep(String allowSep){
        if(!allowSep.contains(this.sep)){
            throw new RuntimeException("custom");
        }
    }


    @Override
    public String toString() {
        return sep;
    }
}

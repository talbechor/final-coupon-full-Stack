package com.jb.couponsprojectteam.beans;

public enum Categories {
    FOOD("FOOD"),
    ELECTRICITY("ELECTRICITY"),
    RESTAURANT("RESTAURANT"),
    VACATION("VACATION");

    private String name;
    Categories(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    private final int value = ordinal() + 1;

    public int getValue() {
        return value;
    }

}

package com.dobleadev.moneyconverter.modules;

public class Currency {
    String type;
    String name;

    public Currency(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return getType();
    }
}

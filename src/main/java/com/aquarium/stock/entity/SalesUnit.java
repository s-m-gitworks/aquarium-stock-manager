package com.aquarium.stock.entity;

/**
 * 生体の単位を管理するenum
 */
public enum SalesUnit {
    INDIVIDUAL("匹"),
    PAIR("ペア"),
    TRIO("トリオ");

    private final String displayName;

    SalesUnit(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
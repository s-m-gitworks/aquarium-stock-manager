package com.aquarium.stock.entity;

/**
 * 生体の状態を管理するenum
 */
public enum ArrivalStatus {
    NORMAL("正常"),
    SICK("病気"),
    QUARANTINE("検疫中");

    private final String displayName;

    ArrivalStatus(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}

package com.aquarium.stock.entity;

public enum LossReason {
    DEAD_ON_ARRIVAL("死着"),
    DISEASE("病気"),
    JUMPED_OUT("飛び出し"),
    POOR_MANAGEMENT("管理不足"),
    UNKNOWN("原因不明"),
    OTHER("その他");

    private final String displayName;

    LossReason(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}

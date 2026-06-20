package com.aquarium.stock.entity;

public enum LossReason {
    //** 死着 */
    DEAD_ON_ARRIVAL,
    /** 病気 */
    DISEASE,
    /** 飛び出し */
    JUMPED_OUT,
    /** 管理不足 */
    POOR_MANAGEMENT,
    /** 原因不明 */
    UNKNOWN,
    /** その他 */
    OTHER
}

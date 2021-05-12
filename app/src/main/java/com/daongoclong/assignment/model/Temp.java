package com.daongoclong.assignment.model;

public class Temp {
    private float Value;
    private String Unit;
    private int UnitType;

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        this.Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        this.Unit = unit;
    }

    public int getUnitType() {
        return UnitType;
    }

    public void setUnitType(int unitType) {
        this.UnitType = unitType;
    }
}

package com.henninghall.picker.wheelFunctions;

import com.henninghall.picker.wheels.Wheel;

public class SetDividerHeight implements WheelFunction {
    private final int height;

    public SetDividerHeight(int height) {
        this.height = height;
    }

    @Override
    public void apply(Wheel wheel) {
        wheel.picker.setDividerHeight(height);
    }
}

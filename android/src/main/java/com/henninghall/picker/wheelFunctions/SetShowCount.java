package com.henninghall.picker.wheelFunctions;

import com.henninghall.picker.wheels.Wheel;

public class SetShowCount implements WheelFunction {

    private final int count;

    public SetShowCount(int count) {
        this.count = count;
    }

    @Override
    public void apply(Wheel wheel) {
        wheel.picker.setShownCount(this.count);
    }
}



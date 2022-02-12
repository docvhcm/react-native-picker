package com.henninghall.picker.wheelFunctions;

import com.henninghall.picker.wheels.Wheel;

public class Refresh implements WheelFunction {

    @Override
    public void apply(Wheel wheel) {
        wheel.refresh();
    }
}



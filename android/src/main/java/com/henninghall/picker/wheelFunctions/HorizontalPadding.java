package com.henninghall.picker.wheelFunctions;

import com.henninghall.picker.wheels.Wheel;

import java.util.Calendar;

public class HorizontalPadding implements WheelFunction {

    @Override
    public void apply(Wheel wheel) {
        wheel.setHorizontalPadding();
    }
}



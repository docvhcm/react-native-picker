package com.henninghall.picker.wheelFunctions;

import android.view.View;

import com.henninghall.picker.wheels.Wheel;

public class Hide implements WheelFunction {

    @Override
    public void apply(Wheel wheel) {
        wheel.picker.setVisibility(View.GONE);
    }
}



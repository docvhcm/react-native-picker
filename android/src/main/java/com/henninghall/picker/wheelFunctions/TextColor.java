package com.henninghall.picker.wheelFunctions;

import android.graphics.Color;

import com.henninghall.picker.wheels.Wheel;

public class TextColor implements WheelFunction {

    private final String color;

    public TextColor(String color) {
        this.color = color;
    }

    @Override
    public void apply(Wheel wheel) {
        wheel.picker.setTextColor(color);
    }
}



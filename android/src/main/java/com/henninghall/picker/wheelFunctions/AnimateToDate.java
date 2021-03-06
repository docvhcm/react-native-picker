package com.henninghall.picker.wheelFunctions;

import com.henninghall.picker.wheels.Wheel;

import java.util.Calendar;
import java.util.Date;

public class AnimateToDate implements WheelFunction {

    private Calendar date;

    public AnimateToDate(Calendar date) {
        this.date = date;
    }

    @Override
    public void apply(Wheel wheel) {
        wheel.animateToDate(date);
    }
}



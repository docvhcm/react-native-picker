package com.henninghall.picker.wheelFunctions;

import com.henninghall.picker.pickers.Picker;
import com.henninghall.picker.ui.WheelChangeListener;
import com.henninghall.picker.wheels.Wheel;

import cn.carbswang.android.numberpickerview.library.NumberPickerView;

public class AddOnChangeListener implements WheelFunction {

    private final WheelChangeListener onChangeListener;

    public AddOnChangeListener(WheelChangeListener onChangeListener){
        this.onChangeListener = onChangeListener;
    }

    @Override
    public void apply(final Wheel wheel) {
        wheel.picker.setOnValueChangedListener(new Picker.OnValueChangeListener() {
            @Override
            public void onValueChange() {
                onChangeListener.onChange(wheel);
            }
        });
    }
}



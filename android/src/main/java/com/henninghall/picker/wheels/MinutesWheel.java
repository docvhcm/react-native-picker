package com.henninghall.picker.wheels;

import android.graphics.Paint;

import com.henninghall.picker.pickers.Picker;
import com.henninghall.picker.State;
import com.henninghall.picker.Utils;
import com.henninghall.picker.models.Mode;

import java.util.ArrayList;
import java.util.Calendar;

public class MinutesWheel extends Wheel {

    public MinutesWheel(Picker picker, State id) {
        super(picker, id);
    }

    @Override
    public ArrayList<String> getValues() {
        Calendar cal = Calendar.getInstance();
        ArrayList<String> values = new ArrayList<>();

        cal.set(Calendar.MINUTE, 0);
        for(int i=0; i<60; i = i + state.getMinuteInterval()) {
            values.add(format.format(cal.getTime()));
            cal.add(Calendar.MINUTE, state.getMinuteInterval());
        }

        return values;
    }

    @Override
    public boolean visible() {
        return state.getMode() != Mode.date;
    }

    @Override
    public boolean wrapSelectorWheel() {
        return true;
    }

    @Override
    public String getFormatPattern() {
        return "mm";
    }

    @Override
    public Paint.Align getTextAlign() {
        return state.derived.hasOnly2Wheels() ? Paint.Align.LEFT : Paint.Align.RIGHT;
    }

}

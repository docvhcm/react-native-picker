package com.henninghall.date_picker.wheels;

import android.graphics.Paint;

import java.util.*;
import com.facebook.react.bridge.ReadableArray;
import com.henninghall.date_picker.*;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.pickers.Picker;
import com.henninghall.date_picker.wheelFunctions.HorizontalPadding;

public class ArrayWheel extends Wheel
{
    public ArrayWheel(final Picker picker, final State id) {
        super(picker, id);
    }

    @Override
    public ArrayList<String> getValues() {
      ReadableArray items = state.getItems();
      ArrayList<String> values = new ArrayList<>();
      int size = items.size();      
      for (int i = 0; i < size; ++i) {        
        values.add(items.getString(i));
      }
      return values;
    }

    @Override
    public boolean visible() {
        return state.getMode() == Mode.array;
    }

    @Override
    public boolean wrapSelectorWheel() {
        return true;
    }

    @Override
    public String getFormatPattern() {
        return "yyyy";
    }

    @Override
    public Paint.Align getTextAlign() {
        return Paint.Align.LEFT;
    }

    @Override
    public int getHorizontalPadding() {
        return 1;
    }


}
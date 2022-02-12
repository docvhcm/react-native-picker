package com.henninghall.picker.wheels;

import android.graphics.Paint;

import java.util.*;
import com.facebook.react.bridge.ReadableArray;
import com.henninghall.picker.*;
import com.henninghall.picker.models.Mode;
import com.henninghall.picker.pickers.Picker;
import com.henninghall.picker.wheelFunctions.HorizontalPadding;

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
        String item = items.getString(i);
        if(item != null && !item.isEmpty()) {
          values.add(item);
        } else {
          values.add("Item " + i);
        }
        
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
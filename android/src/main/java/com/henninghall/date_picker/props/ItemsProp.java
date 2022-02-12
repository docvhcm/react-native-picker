package com.henninghall.date_picker.props;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;

public class ItemsProp extends Prop<ReadableArray> {
    public static final String name = "items";
    
    @Override
    public ReadableArray toValue(Dynamic value){
      return value.asArray();
    }

}

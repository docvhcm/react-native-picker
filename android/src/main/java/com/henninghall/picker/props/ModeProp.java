package com.henninghall.picker.props;

import com.facebook.react.bridge.Dynamic;
import com.henninghall.picker.models.Mode;

public class ModeProp extends Prop<Mode> {
    public static final String name = "mode";

    @Override
    public Mode toValue(Dynamic value){
        return Mode.valueOf(value.asString());
    }
}

package com.henninghall.picker.props;

import com.facebook.react.bridge.Dynamic;
import com.henninghall.picker.models.Variant;

public class VariantProp extends Prop<Variant> {
    public static final String name = "androidVariant";

    @Override
    public Variant toValue(Dynamic value){
        return Variant.valueOf(value.asString());
    }

}
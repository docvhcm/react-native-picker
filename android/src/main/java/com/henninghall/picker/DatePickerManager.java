package com.henninghall.picker;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.henninghall.picker.props.DividerHeightProp;
import com.henninghall.picker.props.Is24hourSourceProp;
import com.henninghall.picker.props.VariantProp;
import com.henninghall.picker.props.DateProp;
import com.henninghall.picker.props.FadeToColorProp;
import com.henninghall.picker.props.LocaleProp;
import com.henninghall.picker.props.MaximumDateProp;
import com.henninghall.picker.props.MinimumDateProp;
import com.henninghall.picker.props.MinuteIntervalProp;
import com.henninghall.picker.props.ModeProp;
import com.henninghall.picker.props.TextColorProp;
import com.henninghall.picker.props.UtcProp;
import com.henninghall.picker.props.ItemsProp;


import java.lang.reflect.Method;
import java.util.Map;

public class DatePickerManager extends SimpleViewManager<PickerView>  {

  private static final String REACT_CLASS = "DatePickerManager";
  private static final int SCROLL = 1;

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public PickerView createViewInstance(ThemedReactContext context) {
    return new PickerView(new LinearLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
    ));
  }

  @ReactPropGroup(names = { DateProp.name, ModeProp.name, LocaleProp.name, MaximumDateProp.name,
          MinimumDateProp.name, FadeToColorProp.name, TextColorProp.name, UtcProp.name, MinuteIntervalProp.name,
          VariantProp.name, DividerHeightProp.name, Is24hourSourceProp.name, ItemsProp.name
  })
  public void setProps(PickerView view, int index, Dynamic value) {
    updateProp("setProps", view, index, value);
  }

  @ReactPropGroup(names = {"height"}, customType = "Style")
  public void setStyle(PickerView view, int index, Dynamic value) {
    updateProp("setStyle", view, index, value);
  }

  @Override
  public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of("scroll", SCROLL);
  }

  @Override
  protected void onAfterUpdateTransaction(PickerView pickerView) {
   super.onAfterUpdateTransaction(pickerView);
     try{
       pickerView.update();
     }
     catch (Exception e){
       e.printStackTrace();
     }
  }

  public void receiveCommand(final PickerView view, int command, final ReadableArray args) {
    if (command == SCROLL) {
      int wheelIndex = args.getInt(0);
      int scrollTimes = args.getInt(1);
      view.scroll(wheelIndex, scrollTimes);
    }
  }

  public Map getExportedCustomBubblingEventTypeConstants() {
    return MapBuilder.builder()
            .put("dateChange", MapBuilder.of("phasedRegistrationNames",
                    MapBuilder.of("bubbled", "onChange")
                    )
            ).build();
  }

  private void updateProp(String methodName, PickerView view, int index, Dynamic value){
    String[] propNames = getMethodAnnotation(methodName).names();
    String propName = propNames[index];
    view.updateProp(propName, value);
  }

  private ReactPropGroup getMethodAnnotation(String methodName) {
    Method[] methods = this.getClass().getMethods();
    Method method = null;
    for (Method m : methods) {
      if (m.getName().equals(methodName))
        method = m;
    }
    return method.getAnnotation(ReactPropGroup.class);
  }

}



package com.henninghall.picker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.facebook.react.bridge.Dynamic;
import com.henninghall.picker.props.DividerHeightProp;
import com.henninghall.picker.props.Is24hourSourceProp;
import com.henninghall.picker.props.MaximumDateProp;
import com.henninghall.picker.props.MinimumDateProp;
import com.henninghall.picker.props.MinuteIntervalProp;
import com.henninghall.picker.props.UtcProp;
import com.henninghall.picker.props.VariantProp;
import com.henninghall.picker.props.DateProp;
import com.henninghall.picker.props.FadeToColorProp;
import com.henninghall.picker.props.HeightProp;
import com.henninghall.picker.props.LocaleProp;
import com.henninghall.picker.props.ModeProp;
import com.henninghall.picker.props.TextColorProp;
import com.henninghall.picker.ui.UIManager;
import com.henninghall.picker.ui.Accessibility;

import java.util.ArrayList;

public class PickerView extends RelativeLayout {


    private final ViewGroup.LayoutParams layoutParams;
    private UIManager uiManager;
    private State state = new State();
    private ArrayList<String> updatedProps = new ArrayList<>();

    public PickerView(ViewGroup.LayoutParams layoutParams) {
        super(DatePickerPackage.context);
        this.layoutParams = layoutParams;
    }

    public void update() {

        if (didUpdate(VariantProp.name)) {
            this.removeAllViewsInLayout();
            LinearLayout layout = new LinearLayout(getContext());
            LayoutInflater.from(getContext()).inflate(state.derived.getRootLayout(), layout);
            this.addView(layout, layoutParams);
            uiManager = new UIManager(state, this);
        }

        if (didUpdate(FadeToColorProp.name)) {
            uiManager.updateFadeToColor();
        }

        if (didUpdate(TextColorProp.name)) {
            uiManager.updateTextColor();
        }

        if (didUpdate(ModeProp.name, VariantProp.name, Is24hourSourceProp.name)) {
            uiManager.updateWheelVisibility();
        }

        if (didUpdate(HeightProp.name)) {
            uiManager.updateHeight();
        }

        if (didUpdate(DividerHeightProp.name)) {
            uiManager.updateDividerHeight();
        }

        if (didUpdate(ModeProp.name, LocaleProp.name, VariantProp.name, Is24hourSourceProp.name)) {
            uiManager.updateWheelOrder();
        }

        if (didUpdate(ModeProp.name)) {
            uiManager.updateWheelPadding();
        }

        if (didUpdate(DateProp.name, HeightProp.name, LocaleProp.name,
                MaximumDateProp.name, MinimumDateProp.name, MinuteIntervalProp.name, ModeProp.name,
                UtcProp.name, VariantProp.name
        )) {
            uiManager.updateDisplayValues();
        }

        if (didUpdate(LocaleProp.name)) {
            Accessibility.setLocale(state.getLocale());
        }

        uiManager.setWheelsToDate();

        updatedProps = new ArrayList<>();
    }

    private boolean didUpdate(String... propNames) {
        for (String propName : propNames) {
            if (updatedProps.contains(propName)) return true;
        }
        return false;
    }

    public void updateProp(String propName, Dynamic value) {
        state.setProp(propName, value);
        updatedProps.add(propName);
    }

    public void scroll(int wheelIndex, int scrollTimes) {
        uiManager.scroll(wheelIndex, scrollTimes);
    }

    public String getDate() {
        return state.derived.getLastDate();
    }

    private final Runnable measureAndLayout = new Runnable() {
        @Override
        public void run() {
            measure(
                    MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY));
            layout(getLeft(), getTop(), getRight(), getBottom());
        }
    };

    @Override
    public void requestLayout() {
        super.requestLayout();
        post(measureAndLayout);
    }


}

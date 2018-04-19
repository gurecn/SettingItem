package com.devdroid.itemsetting.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.devdroid.itemsetting.R;
import com.devdroid.itemsetting.listener.OnSwitchViewChangeListener;

/**
 * 设置条目复选框
 * @see OnSwitchViewChangeListener 监听点击事件
 * User:Gaolei  gurecn@gmail.com
 * Date:2017/12/12
 * I'm glad to share my knowledge with you all.
 */
public class SwitchViewSettingsView extends LinearLayout {

    private TextView mTvCheckBoxSeekBarName;
    private TextView mTvCheckBoxSummary;
    private SwitchView mCheckBox;

    public SwitchViewSettingsView(Context context) {
        super(context);
        initLayout();
    }

    public SwitchViewSettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout();
        initAttributeSrt(context, attrs);
    }

    public SwitchViewSettingsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
        initAttributeSrt(context, attrs);
    }

    private void initLayout() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_check_box_settings, null);
        addView(rootView);
        mTvCheckBoxSeekBarName = (TextView) rootView.findViewById(R.id.tv_view_radio_name);
        mTvCheckBoxSummary = (TextView) rootView.findViewById(R.id.tv_view_check_box_summary);
        mCheckBox = (SwitchView) rootView.findViewById(R.id.radio_view_check_box);
    }
    private void initAttributeSrt(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SwitchViewSettingsView);
        String itemName = ta.getString(R.styleable.SwitchViewSettingsView_itemCheckBoxName);
        this.setCheckBoxName(itemName);
        String itemSummary= ta.getString(R.styleable.SwitchViewSettingsView_itemCheckBoxSummary);
        this.setCheckBoxSummary(itemSummary);
        boolean itemChecked = ta.getBoolean(R.styleable.SwitchViewSettingsView_itemCheckBoxChecked, false);
        this.setCheckBoxChecked(itemChecked);
        boolean itemClickable = ta.getBoolean(R.styleable.SwitchViewSettingsView_itemCheckBoxClickable, true);
        if(!itemClickable) {
            this.setClickable(itemClickable);
            mCheckBox.setClickable(itemClickable);
        }
    }
    public void setCheckBoxName(String checkBoxName){
        if(mTvCheckBoxSeekBarName != null) {
            mTvCheckBoxSeekBarName.setText(checkBoxName);
            mTvCheckBoxSeekBarName.setTextSize(16);
        }
    }
    
    public String getCheckBoxName(){
        String checkBoxName = "";
        if(mTvCheckBoxSeekBarName != null) {
            checkBoxName = mTvCheckBoxSeekBarName.getText().toString();
        }
        return checkBoxName;
    }

    public void setCheckBoxSummary(String checkBoxSummary){
        if(mTvCheckBoxSummary != null) {
            if(!TextUtils.isEmpty(checkBoxSummary)) {
                mTvCheckBoxSummary.setText(checkBoxSummary);
                mTvCheckBoxSummary.setTextSize(14);
                mTvCheckBoxSummary.setVisibility(View.VISIBLE);
            } else {
                mTvCheckBoxSummary.setVisibility(View.GONE);
            }
        }
    }
    
    public String getCheckBoxSummary(){
        String checkBoxSummary = "";
        if(mTvCheckBoxSummary != null) {
            checkBoxSummary = mTvCheckBoxSummary.getText().toString();
        }
        return checkBoxSummary;
    }

    public void setCheckBoxChecked(boolean checkStatus){
        if(mCheckBox != null) {
            mCheckBox.setChecked(checkStatus);
        }
    }
    

    public boolean isCheckBoxChecked(){
       return mCheckBox.isChecked();
    }

    public void setCheckBoxOnCheckedChangeListener(final OnSwitchViewChangeListener listener){
        if(mCheckBox != null && mCheckBox.isClickable()) {
            mCheckBox.setOnChangedListener(new SwitchView.OnChangedListener() {
                @Override
                public void OnChanged(SwitchView wiperSwitch, boolean checkState) {
                    listener.onCheckedChanged(SwitchViewSettingsView.this, wiperSwitch, checkState);
                }
            });
//            if(!mCheckBox.isClickable())return;
//           this.setOnClickListener(new OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                   if(mCheckBox.isChecked()){
//                       mCheckBox.setChecked(false);
//                   } else {
//                       mCheckBox.setChecked(true);
//                   }
//               }
//           });
        }
    }
}

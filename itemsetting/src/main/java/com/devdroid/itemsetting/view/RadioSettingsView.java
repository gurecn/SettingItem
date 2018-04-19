package com.devdroid.itemsetting.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.devdroid.itemsetting.R;
import com.devdroid.itemsetting.listener.OnRadioCheckedChangeListener;


/**
 * 单选条目
 * User:Gaolei  gurecn@gmail.com
 * Date:2017/12/26
 * I'm glad to share my knowledge with you all.
 */
public class RadioSettingsView  extends LinearLayout {
	
	private TextView mTvCheckBoxSeekBarName;
	private CheckBox mCheckBox;
	
	public RadioSettingsView(Context context) {
		super(context);
		initLayout();
	}
	
	public RadioSettingsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initLayout();
		initAttributeSrt(context, attrs);
	}
	
	public RadioSettingsView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initLayout();
		initAttributeSrt(context, attrs);
	}
	
	private void initLayout() {
		View rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_radio_settings, null);
		addView(rootView);
		mTvCheckBoxSeekBarName = (TextView) rootView.findViewById(R.id.tv_view_radio_name);
		mCheckBox = (CheckBox) rootView.findViewById(R.id.radio_view_check_box);
	}
	private void initAttributeSrt(Context context, AttributeSet attrs) {
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RadioSettingsView);
		String itemName = ta.getString(R.styleable.RadioSettingsView_itemRadioName);
		this.setCheckBoxName(itemName);
		boolean itemChecked = ta.getBoolean(R.styleable.RadioSettingsView_itemRadioChecked, false);
		this.setRadioChecked(itemChecked);
		boolean itemClickable = ta.getBoolean(R.styleable.RadioSettingsView_itemRadioClickable, true);
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
	
	public void setRadioChecked(boolean checkStatus){
		if(mCheckBox != null) {
			mCheckBox.setChecked(checkStatus);
		}
	}
	
	public boolean isRadioChecked(){
		boolean isChecked = false;
		if(mCheckBox != null) {
			isChecked = mCheckBox.isChecked();
		}
		return isChecked;
	}
	
	public void setRadioOnCheckedChangeListener(final OnRadioCheckedChangeListener listener){
		if(mCheckBox != null) {
			mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					listener.onCheckedChanged(RadioSettingsView.this, buttonView, isChecked);
				}
			});
			if(!mCheckBox.isClickable())return;
			this.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if(mCheckBox.isChecked()){
						mCheckBox.setChecked(false);
					} else {
						mCheckBox.setChecked(true);
					}
				}
			});
		}
	}
}
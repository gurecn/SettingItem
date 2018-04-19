package com.devdroid.itemsetting.listener;

import android.widget.CompoundButton;

import com.devdroid.itemsetting.view.RadioSettingsView;

/**
 * User:Gaolei  gurecn@gmail.com
 * Date:2017/12/26
 * I'm glad to share my knowledge with you all.
 */
public interface OnRadioCheckedChangeListener {
	void onCheckedChanged(RadioSettingsView radioSettingsView, CompoundButton buttonView, boolean isChecked);
}

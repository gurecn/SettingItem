package com.devdroid.itemsetting.listener;

import com.devdroid.itemsetting.view.SwitchView;
import com.devdroid.itemsetting.view.SwitchViewSettingsView;

/**
 * 设置条目复选框选择监听
 * @see SwitchViewSettingsView
 * User:Gaolei  gurecn@gmail.com
 * Date:2017/12/12
 * I'm glad to share my knowledge with you all.
 */
public interface OnSwitchViewChangeListener {
    void onCheckedChanged(SwitchViewSettingsView checkBoxSettingsView, SwitchView buttonView, boolean isChecked);
}

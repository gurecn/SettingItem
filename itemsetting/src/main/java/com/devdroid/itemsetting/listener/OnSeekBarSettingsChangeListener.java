package com.devdroid.itemsetting.listener;

import android.widget.SeekBar;

import com.devdroid.itemsetting.view.SeekBarSettingsView;

/**
 * 设置条目进度条滑动监听
 * @see SeekBarSettingsView
 * User:Gaolei  gurecn@gmail.com
 * Date:2017/12/12
 * I'm glad to share my knowledge with you all.
 */
public interface OnSeekBarSettingsChangeListener {
    void onProgressChanged(SeekBarSettingsView seekBarSettingsView, SeekBar seekBar, int progress, boolean fromUser);
}

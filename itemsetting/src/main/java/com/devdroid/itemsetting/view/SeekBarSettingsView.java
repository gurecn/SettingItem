package com.devdroid.itemsetting.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.devdroid.itemsetting.R;
import com.devdroid.itemsetting.listener.OnSeekBarSettingsChangeListener;
/**
 * 设置条目复选框
 * @see OnSeekBarSettingsChangeListener 监听滑动事件
 * User:Gaolei  gurecn@gmail.com
 * Date:2017/12/12
 * I'm glad to share my knowledge with you all.
 */

public class SeekBarSettingsView extends LinearLayout {

    private TextView mTvSeekBarName;
    private ImageView mTvSeekBarStart;
    private ImageView mTvSeekBarEnd;
    private SeekBar mSeekBarValue;

    public SeekBarSettingsView(Context context) {
        super(context);
        initView();
    }

    public SeekBarSettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        initAttributeSrt(context, attrs);
    }

    public SeekBarSettingsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        initAttributeSrt(context, attrs);
    }

    private void initView() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_seek_bar_settings, null);
        addView(rootView);
        mTvSeekBarName = (TextView) rootView.findViewById(R.id.tv_view_seek_bar_name);
        mTvSeekBarStart = (ImageView) rootView.findViewById(R.id.iv_view_seek_bar_value_start);
        mTvSeekBarEnd = (ImageView) rootView.findViewById(R.id.iv_view_seek_bar_value_end);
        mSeekBarValue = (SeekBar) rootView.findViewById(R.id.seekbar_view_seek_bar_value);
    }
    private void initAttributeSrt(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SeekBarSettingsView);
        String itemName = ta.getString(R.styleable.SeekBarSettingsView_itemSeekBarName);
        this.setSeekBarName(itemName);
        int itemValueStart = ta.getResourceId(R.styleable.SeekBarSettingsView_itemSeekBarValueStartIcon, 0);
        int itemValueEnd = ta.getResourceId(R.styleable.SeekBarSettingsView_itemSeekBarValueEndIcon, 0);
        this.setSeekBarStartEndValue(itemValueStart, itemValueEnd);
        int itemMaxProgress = ta.getInteger(R.styleable.SeekBarSettingsView_itemSeekBarMaxProgress, 100);
        this.setSeekBarMaxProgress(itemMaxProgress);
        int itemProgress = ta.getInteger(R.styleable.SeekBarSettingsView_itemSeekBarProgress, 0);
        this.setSeekBarProgress(itemProgress);
    }
    public void setSeekBarName(String seekBarName){
        if(mTvSeekBarName != null) {
            mTvSeekBarName.setText(seekBarName);
            mTvSeekBarName.setTextSize(16);
        }
    }
    
    public String getSeekBarName(){
        String seekBarName = "";
        if(mTvSeekBarName != null) {
            seekBarName = mTvSeekBarName.getText().toString();
        }
        return seekBarName;
    }

    public void setSeekBarStartEndValue(int seekBarNameStart, int seekBarNameEnd){
        if(mTvSeekBarStart != null) {
            mTvSeekBarStart.setImageResource(seekBarNameStart);
        }
        if(mTvSeekBarEnd != null) {
            mTvSeekBarEnd.setImageResource(seekBarNameEnd);
        }
    }
    public void setSeekBarMaxProgress(int maxProgress){
        if(mSeekBarValue != null) {
            mSeekBarValue.setMax(maxProgress);
        }
    }

    public void setSeekBarProgress(int progress){
        if(mSeekBarValue != null) {
            mSeekBarValue.setProgress(progress);
        }
    }

    public void setSeekBarOnSeekBarChangeListener(final OnSeekBarSettingsChangeListener l){
        mSeekBarValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                l.onProgressChanged(SeekBarSettingsView.this, seekBar, progress, fromUser);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

//    public void setSeekBarValueTextSize(int textSize) {
//        if(mTvSeekBarStart != null) {
//            mTvSeekBarStart.setTextSize(textSize);
//        }
//        if(mTvSeekBarEnd != null) {
//            mTvSeekBarEnd.setTextSize(textSize);
//        }
//    }


}

package com.devdroid.itemsetting.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.devdroid.itemsetting.R;


/**
 * 设置界面条目
 * User:Gaolei  gurecn@gmail.com
 * Date:2017/10/9
 * I'm glad to share my knowledge with you all.
 */
public class ImeSettingsItemView extends LinearLayout {
		private TextView mTvSettingTitle;
		private ImageView mIvSettingIcon;
		private ImageView mIvSettingEnter;

	public ImeSettingsItemView(Context context) {
		super(context);
		initLayout();
	}

	public ImeSettingsItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initLayout();
		initAttributeSrt(context, attrs);
	}

	public ImeSettingsItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initLayout();
		initAttributeSrt(context, attrs);
	}

	private void initLayout() {
		View rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_ime_setting_item, null);
		addView(rootView);
		mIvSettingIcon = (ImageView) rootView.findViewById(R.id.iv_view_ime_settings_item_icon);
		mTvSettingTitle = (TextView) rootView.findViewById(R.id.iv_view_ime_settings_item_title);
		mIvSettingEnter = (ImageView) rootView.findViewById(R.id.iv_view_ime_settings_item_enter);
	}
	private void initAttributeSrt(Context context, AttributeSet attrs) {
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ImeSettingsItemView);
		int iconId = ta.getResourceId(R.styleable.ImeSettingsItemView_settingItemIcon, 0);
		if(iconId != 0) {
			this.mIvSettingIcon.setImageResource(iconId);
			this.mIvSettingIcon.setVisibility(View.VISIBLE);
		} else {
			this.mIvSettingIcon.setVisibility(View.GONE);
		}
		String itemSummary= ta.getString(R.styleable.ImeSettingsItemView_settingItemTitle);
		this.mTvSettingTitle.setText(itemSummary);
		int visibility = ta.getInt(R.styleable.ImeSettingsItemView_visibilityEnter, View.GONE);
		this.mIvSettingEnter.setVisibility(visibility);
	}
	/**
	 * Set the visibility state of this view.
	 *
	 * @param visibility One of {@link #VISIBLE}, {@link #INVISIBLE}, or {@link #GONE}.
	 * @attr ref android.R.styleable#View_visibility
	 */
	public void setEnterVisibility(int visibility){
		if(mIvSettingEnter != null) {
			mIvSettingEnter.setVisibility(visibility);
		}
	}
	/**
	 * Returns the visibility status for this view.
	 *
	 * @return One of {@link #VISIBLE}, {@link #INVISIBLE}, or {@link #GONE}.
	 * @attr ref android.R.styleable#View_visibility
	 */
	public int getEnterVisibility(){
		int visibility = View.GONE;
		if(mIvSettingEnter != null) {
			visibility = mIvSettingEnter.getVisibility();
		}
		return visibility;
	}
}

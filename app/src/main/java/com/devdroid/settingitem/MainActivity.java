package com.devdroid.settingitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.devdroid.itemsetting.listener.OnRadioCheckedChangeListener;
import com.devdroid.itemsetting.listener.OnSeekBarSettingsChangeListener;
import com.devdroid.itemsetting.listener.OnSwitchViewChangeListener;
import com.devdroid.itemsetting.view.ImeSettingsItemView;
import com.devdroid.itemsetting.view.RadioSettingsView;
import com.devdroid.itemsetting.view.SeekBarSettingsView;
import com.devdroid.itemsetting.view.SwitchView;
import com.devdroid.itemsetting.view.SwitchViewSettingsView;

public class MainActivity extends AppCompatActivity implements OnRadioCheckedChangeListener, OnSwitchViewChangeListener, OnSeekBarSettingsChangeListener {
	
	private ImeSettingsItemView mImeSettingsItemView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mImeSettingsItemView = (ImeSettingsItemView)findViewById(R.id.isiv_demo);
		RadioSettingsView radioSettingsView = (RadioSettingsView)findViewById(R.id.rsv_demo);
		radioSettingsView.setRadioOnCheckedChangeListener(this);
		SwitchViewSettingsView switchViewSettingsView = (SwitchViewSettingsView)findViewById(R.id.svsv_demo);
		switchViewSettingsView.setCheckBoxOnCheckedChangeListener(this);
		SeekBarSettingsView seekBarSettingsView = (SeekBarSettingsView)findViewById(R.id.sbsv_demo);
		seekBarSettingsView.setSeekBarOnSeekBarChangeListener(this);
	}
	
	public void onClick(View view){
		Toast.makeText(this, "点击设置按钮", Toast.LENGTH_SHORT).show();
		mImeSettingsItemView.setEnterVisibility(mImeSettingsItemView.getEnterVisibility() == View.GONE ? View.VISIBLE:View.GONE);
	}
	
	@Override
	public void onCheckedChanged(RadioSettingsView radioSettingsView, CompoundButton buttonView, boolean isChecked) {
		Toast.makeText(this, "单选框：" + radioSettingsView.getCheckBoxName() + "  状态：" + isChecked, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onCheckedChanged(SwitchViewSettingsView checkBoxSettingsView, SwitchView buttonView, boolean isChecked) {
		Toast.makeText(this, "SwitchView：" + checkBoxSettingsView.getCheckBoxName() + "  状态：" + isChecked, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onProgressChanged(SeekBarSettingsView seekBarSettingsView, SeekBar seekBar, int progress, boolean fromUser) {
		Toast.makeText(this, "SeekBar：" + seekBarSettingsView.getSeekBarName() + "  状态：" + progress, Toast.LENGTH_SHORT).show();
		
	}
}

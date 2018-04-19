package com.devdroid.itemsetting.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.devdroid.itemsetting.R;

public class SwitchView extends View implements View.OnClickListener {

    private Bitmap bg_on, bg_off, slipper_btn;
    private boolean nowStatus = false;// 当前状态
    private OnChangedListener listener;// 监听接口
    public SwitchView(Context context) {
        super(context);
        init();
    }
    public SwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        // 载入图片资源
        bg_on = BitmapFactory.decodeResource(getResources(), R.mipmap.switch_ok_bg);
        bg_off = BitmapFactory.decodeResource(getResources(), R.mipmap.switch_no_bg);
        slipper_btn = BitmapFactory.decodeResource(getResources(), R.mipmap.switchbtn);
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        float x = 0;
        float h = (slipper_btn.getHeight() - bg_off.getHeight()) / 2;
        // 根据nowX设置背景，开或者关状态
        if (nowStatus) {
            canvas.drawBitmap(bg_on, 0, h, paint);// 画出关闭时的背景
            x = bg_off.getWidth() - slipper_btn.getWidth();
        } else {
            canvas.drawBitmap(bg_off, 0, h, paint);// 画出打开时的背景
            x = 0;
        }
        // 画出滑块
        canvas.drawBitmap(slipper_btn, x, 0, paint);
    }

    @Override
    public void onClick(View v) {
        setChecked(!nowStatus);
        if (listener != null) {
            listener.OnChanged(SwitchView.this, nowStatus);
        }
        // 刷新界面
        invalidate();
    }

    public void setOnChangedListener(OnChangedListener listener) {
        this.listener = listener;
    }

    public void setChecked(boolean checked) {
        nowStatus = checked;
        invalidate();
    }

    public boolean isChecked() {
        return nowStatus;
    }

    public interface OnChangedListener {
        void OnChanged(SwitchView wiperSwitch, boolean checkState);
    }
}

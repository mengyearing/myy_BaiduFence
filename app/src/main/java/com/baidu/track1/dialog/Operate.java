package com.baidu.track1.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.baidu.track1.R;
import com.baidu.track1.activity.CreaFence;

/**
 * 服务控制对话框
 *
 */
public class Operate extends PopupWindow {

    private View mView = null;
    private Button alarmBtn = null;
    private Button updateBtn = null;
    private Button deleteBtn = null;
    private Button cancelBtn = null;
    private TextView titleText = null;

    @SuppressLint({"InflateParams", "ClickableViewAccessibility"})
    public Operate(final CreaFence parent) {
        super(parent);
        LayoutInflater inflater = (LayoutInflater) parent
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.dialog_fence2, null);
        alarmBtn = (Button) mView.findViewById(R.id.btn_fenceOperate_alarm);
        updateBtn = (Button) mView.findViewById(R.id.btn_fenceOperate_update);
        deleteBtn = (Button) mView.findViewById(R.id.btn_fenceOperate_delete);
        cancelBtn = (Button) mView.findViewById(R.id.btn_all_cancel);
        titleText = (TextView) mView.findViewById(R.id.tv_dialog_title);
        alarmBtn.setOnClickListener(parent);
        updateBtn.setOnClickListener(parent);
        deleteBtn.setOnClickListener(parent);
        titleText.setText(R.string.all_fence_operate);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        setContentView(mView);
        setFocusable(false);
        setOutsideTouchable(false);
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(LayoutParams.WRAP_CONTENT);
        setAnimationStyle(R.style.dialog_anim_style);
        setBackgroundDrawable(null);

    }

}

package com.baidu.track1;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.track1.utils.CommonUtil;

import java.util.concurrent.atomic.AtomicInteger;

public class TrackApplication extends Application {

    private AtomicInteger mSequenceGenerator = new AtomicInteger();

    public Context mContext = null;


    /**
     * 轨迹服务ID
     */
    public long serviceId = 202137 ;//轨迹服务id，需要申请

    /**
     * Entity标识
     */
    public String entityName = "myTrace";

    public boolean isRegisterReceiver = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        entityName = CommonUtil.getImei(this);

        // 若为创建独立进程，则不初始化成员变量
        if ("com.baidu.track:remote".equals(CommonUtil.getCurProcessName(mContext))) {
            return;
        }

        SDKInitializer.initialize(mContext);

    }

    public int getTag() {
        return mSequenceGenerator.incrementAndGet();
    }

}

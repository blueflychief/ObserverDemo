package com.infinite.observerdemo;

import android.util.Log;

/**
 * Created by Administrator on 2016-04-26.
 */
public class MyObserverObj1 implements MyObserver {
    private static final String TAG = "MyObserverObj1";
    private MySubject subject;

    public MyObserverObj1(MySubject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        Log.i(TAG, "---ObserverObj1_update: " + msg);
    }


}

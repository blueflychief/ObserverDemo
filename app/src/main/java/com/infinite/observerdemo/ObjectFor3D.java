package com.infinite.observerdemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-04-26.
 */
public class ObjectFor3D implements MySubject {
    private static final String TAG = "ObjectFor3D";
    private List<MyObserver> observers = new ArrayList<MyObserver>();
    private String msg;

    @Override
    public void registerObserver(MyObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            Log.i(TAG, "registerObserver: 注册成功");
        } else {
            Log.i(TAG, "registerObserver: 已经注册过");
        }
    }

    @Override
    public void removeObserver(MyObserver observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
            Log.i(TAG, "registerObserver: 解注册成功");
        }
    }

    @Override
    public void notifyObservers() {
        if (null!=observers&&observers.size()==0) {
            Log.i(TAG, "notifyObservers: 请先注册观察者");
        }

        for (MyObserver observer : observers) {
            observer.update(msg);
        }
    }

    /**
     * 主题更新消息
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;

        notifyObservers();
    }
}

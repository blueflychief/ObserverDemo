package com.infinite.observerdemo;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2016-04-26.
 */
public class SystemObserver implements Observer {

    private static final String TAG = "SystemObserver";

    public void registerSubject(Observable observable)
    {
        observable.addObserver(this);
        Log.i(TAG, "registerSubject: 注册成功");
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if (o instanceof SystemSubject3D)
        {
            SystemSubject3D subjectFor3d = (SystemSubject3D) o;
            System.out.println("subjectFor3d's msg -- >" + subjectFor3d.getMsg());
        }

        if (o instanceof SystemSubject4D)
        {
            SystemSubject4D systemSubject4D = (SystemSubject4D) o;
            System.out.println("subjectForSSQ's msg -- >" + systemSubject4D.getMsg());
        }
    }
}

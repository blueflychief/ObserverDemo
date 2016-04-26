package com.infinite.observerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button bt_subscribe;
    private Button bt_push;
    private Button bt_subscribe_sys;
    private Button bt_push_sys;

    private ObjectFor3D mObjectFor3D;
    private MyObserverObj1 observerObj1;
    private MyObserverObj2 observerObj2;
    private SystemSubject3D systemSubject3D;
    private SystemSubject4D systemSubject4D;
    private SystemObserver systemObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_subscribe = (Button) findViewById(R.id.bt_subscribe);
        bt_push = (Button) findViewById(R.id.bt_push);
        bt_subscribe_sys = (Button) findViewById(R.id.bt_subscribe_sys);
        bt_push_sys = (Button) findViewById(R.id.bt_push_sys);


        bt_subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observerObj1 = new MyObserverObj1(mObjectFor3D);
                observerObj2 = new MyObserverObj2(mObjectFor3D);
            }
        });

        bt_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mObjectFor3D) {
                    mObjectFor3D.setMsg("欢迎订阅");
                }
            }
        });

        bt_subscribe_sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                systemSubject3D = new SystemSubject3D();
                systemSubject4D = new SystemSubject4D();
                systemObserver.registerSubject(systemSubject3D);
                systemObserver.registerSubject(systemSubject4D);
            }
        });

        bt_push_sys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (systemSubject3D != null) {
                    systemSubject3D.setMsg("-------sys_3D");
                }else {
                    Log.i(TAG, "onClick: 请先注册观察者");
                }

                if (systemSubject4D != null) {
                    systemSubject4D.setMsg("-------sys_4D");
                }else {
                    Log.i(TAG, "onClick: 请先注册观察者");
                }
            }
        });


        mObjectFor3D = new ObjectFor3D();


        systemObserver = new SystemObserver();

    }
}

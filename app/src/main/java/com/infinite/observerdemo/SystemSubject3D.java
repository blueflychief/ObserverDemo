package com.infinite.observerdemo;

import java.util.Observable;

/**使用系统提供的被观察者
 * Created by Administrator on 2016-04-26.
 */
public class SystemSubject3D extends Observable {
    private String msg ;


    public String getMsg()
    {
        return msg;
    }


    /**
     * 主题更新消息
     *
     * @param msg
     */
    public void setMsg(String msg)
    {
        this.msg = msg  ;
        setChanged();
        notifyObservers();
    }
}

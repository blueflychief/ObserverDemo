package com.infinite.observerdemo;

/**
 * 自定义的被观察者
 * Created by Administrator on 2016-04-26.
 */
public interface MySubject {
    /**
     * 注册一个观察着
     *
     * @param observer
     */
    public void registerObserver(MyObserver observer);

    /**
     * 移除一个观察者
     *
     * @param observer
     */
    public void removeObserver(MyObserver observer);

    /**
     * 通知所有的观察着
     */
    public void notifyObservers();
}

package com.kilrol.queuestack.model;

public class MyQueue<T> implements Push<T> {
    MyList<T> list;

    public MyQueue(MyList<T> list) {
        this.list = list;
    }

    public MyQueue() { }

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public void setList(MyList<T> list) {
        this.list = list;
    }
}

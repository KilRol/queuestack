package com.kilrol.queuestack.model;

public class MyStack<T> implements Push<T>{
    MyList<T> list;

    public MyStack(MyList<T> list){
        this.list = list;
    }

    public MyStack() { }

    @Override
    public void push(T item) {
        list.add_front(item);
    }

    @Override
    public void setList(MyList<T> list) {
        this.list = list;
    }
}
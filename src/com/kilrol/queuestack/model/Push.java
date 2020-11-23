package com.kilrol.queuestack.model;

public interface Push<E> {
    void push(E item);
    void setList(MyList<E> list);
}

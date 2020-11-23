package com.kilrol.queuestack.view;

import com.kilrol.queuestack.model.MyList;

import javax.swing.*;

public class BaseListModel extends AbstractListModel<String> {
    MyList list;

    public BaseListModel(MyList list) {
        this.list = list;
    }

    public BaseListModel() { }

    public void setList(MyList list) {
        this.list = list;
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public String getElementAt(int index) {
        synchronized(list) {
            String i = (String) list.getIndex(index);
            return i;
        }
    }

    void addElement(int k) {
        list.add(k);
        fireIntervalAdded(this, 0, list.getSize());
    }

    public String pop() {
        String res = (String)this.list.pop();
        fireIntervalAdded(this, 0, list.getSize());
        return res;
    }
    public void fireIntervalAdded(){
        fireIntervalAdded(this,0, list.getSize());
    }


}
package com.kilrol.queuestack;

import com.kilrol.queuestack.view.MyFrame;
import com.kilrol.queuestack.view.MyPanel;

public class Main {
    public static void main(String[] args) {
        MyFrame frame;
        MyPanel panel = new MyPanel();
        frame = new MyFrame(panel);
    }
}


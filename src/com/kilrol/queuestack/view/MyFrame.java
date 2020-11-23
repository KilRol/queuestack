package com.kilrol.queuestack.view;

import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel panel;

    public MyFrame(MyPanel p) {
        super("QueueStackList");
        panel = p;
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
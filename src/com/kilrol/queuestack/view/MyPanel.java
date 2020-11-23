package com.kilrol.queuestack.view;

import com.kilrol.queuestack.model.MyList;
import com.kilrol.queuestack.model.MyQueue;
import com.kilrol.queuestack.model.MyStack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {

    JTextField field;
    JButton pushButton;
    JButton popButton;
    JButton queueButton;
    JButton stackButton;
    JButton switchModeButton;
    JList<String> jList;
    BaseListModel baseModel;
    MyList<String> list;

    public MyPanel() {
        list = new MyList<String>();
        field = new JTextField();

        pushButton = new JButton("Push");
        popButton = new JButton("Pop");

        queueButton = new JButton("Queue Model");
        stackButton = new JButton("Stack Model");

        switchModeButton = new JButton("Stack Mode");
        baseModel = new BaseListModel();
        baseModel.setList(list);

        jList = new JList<String>(baseModel);

        popButton.setEnabled(false);
        list.setSq(new MyStack());

        stackButton.setEnabled(false);

        switchModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (switchModeButton.getText().equals("Stack Mode")) {
                    list.setSq(new MyQueue());
                    switchModeButton.setText("Queue Mode");
                }
                else if (switchModeButton.getText().equals("Queue Mode")) {
                    list.setSq(new MyStack());
                    switchModeButton.setText("Stack Mode");
                }
            }
        });

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String k = field.getText().trim();
                    list.push(k);
                    baseModel.fireIntervalAdded();
                    field.setText("");
                    popButton.setEnabled(true);
                    field.requestFocus(true);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(MyPanel.this, "Error!");
                }
            }
        });
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(baseModel.pop().toString());
                if (baseModel.getSize() == 0) popButton.setEnabled(false);
            }
        });
        queueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.setSq(new MyQueue());
                stackButton.setEnabled(true);
                queueButton.setEnabled(false);
            }
        });

        stackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.setSq(new MyStack());
                stackButton.setEnabled(false);
                queueButton.setEnabled(true);
            }
        });

        JComponent[][] component = new JComponent[3][2];
        component[0][0] = field;
        component[0][1] = pushButton;
        component[1][0] = new JScrollPane(jList);
        component[1][1] = popButton;
        component[2][0] = queueButton;
        component[2][1] = stackButton;

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < 3; i++){
            constraints.gridy = i;
            for (int j = 0; j < 2; j++){
                constraints.gridx = j;
                add(component[i][j],constraints);
            }
        }
    }
}
package com.school;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;

public abstract class Frame implements ActionListener{
    protected JFrame frame;
    protected JPanel panel;
    protected JButton btn;
    protected JLabel label;
    Color color = Color.black;
    ButtonGroup group = new ButtonGroup();
    ButtonGroup hues = new ButtonGroup();
    ButtonGroup columns = new ButtonGroup();
    ButtonGroup rows = new ButtonGroup();

    //Constructors
    public Frame(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.btn = new JButton("TEXT");
    }

    public abstract void actionPerformed(ActionEvent e);

    public abstract boolean moveTo(Column x, int y);
}

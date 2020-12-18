package com.school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;

public class VerifyGUI extends Figure {
    private Column col;
    private int row;
    private JFrame frame;
    private JPanel panel;
    private JButton btn;
    private JLabel label;
    private Boolean valid;
    private Figure currentPiece;
    private boolean beenPressed = false;
    private boolean pressedCol = false;
    private boolean pressedRow = false;
    private boolean pressed = false;
    ArrayList<Figure> pieces;

    public VerifyGUI(){
        frame = new JFrame();
        panel = new JPanel();
        btn = new JButton("Verify");
    }

    public VerifyGUI(ArrayList<Figure> pieces){
        frame = new JFrame();
        panel = new JPanel();
        btn = new JButton("Verify");
        this.pieces = pieces;
    }

    /**
     * Creates a GUI and prompts user for the target column.
     * used to validate an individual pieces position
     * @param piece
     * @return
     */
    public Column promptTargetCol(Figure piece){
        currentPiece = piece;
        //Create the radio buttons.
        JRadioButton AButton = new JRadioButton("Column A");
        AButton.setMnemonic(KeyEvent.VK_A);
        AButton.setActionCommand("col");

        JRadioButton BButton = new JRadioButton("Column B");
        BButton.setMnemonic(KeyEvent.VK_C);
        BButton.setActionCommand("col");

        JRadioButton CButton = new JRadioButton("Column C");
        CButton.setMnemonic(KeyEvent.VK_D);
        CButton.setActionCommand("col");

        JRadioButton DButton = new JRadioButton("Column D");
        DButton.setMnemonic(KeyEvent.VK_R);
        DButton.setActionCommand("col");

        JRadioButton EButton = new JRadioButton("Column E");
        EButton.setMnemonic(KeyEvent.VK_P);
        EButton.setActionCommand("col");

        JRadioButton FButton = new JRadioButton("Column F");
        FButton.setMnemonic(KeyEvent.VK_S);
        FButton.setActionCommand("col");

        JRadioButton GButton = new JRadioButton("Column G");
        GButton.setMnemonic(KeyEvent.VK_P);
        GButton.setActionCommand("col");

        JRadioButton HButton = new JRadioButton("Column H");
        HButton.setMnemonic(KeyEvent.VK_S);
        HButton.setActionCommand("col");

        //Group the radio buttons.
        group.add(AButton);
        group.add(BButton);
        group.add(CButton);
        group.add(DButton);
        group.add(EButton);
        group.add(FButton);
        group.add(GButton);
        group.add(HButton);

        //Register a listener for the radio buttons.
        AButton.addActionListener(this);
        BButton.addActionListener(this);
        CButton.addActionListener(this);
        DButton.addActionListener(this);
        EButton.addActionListener(this);
        FButton.addActionListener(this);
        GButton.addActionListener(this);
        HButton.addActionListener(this);

        //obtains user info
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        label = new JLabel("Select desired column for" + currentPiece.getName());
        panel.add(label);
        panel.add(AButton);
        panel.add(BButton);
        panel.add(CButton);
        panel.add(DButton);
        panel.add(EButton);
        panel.add(FButton);
        panel.add(GButton);
        panel.add(HButton);
        btn.addActionListener(this);
        btn.setActionCommand("pressedNOGO");
        panel.add(btn);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Checker");
        frame.pack();
        frame.setVisible(true);

        while(!pressedCol){Thread.onSpinWait();}

        return col;
    }

    /**
     * Creates a GUI and promptes user for the target row.
     * used to validate an individual pieces position.
     * @param piece
     * @return
     */
    public int promptTargetRow(Figure piece){
        currentPiece = piece;
        //Create the radio buttons.
        JRadioButton ONEButton = new JRadioButton("row 1");
        ONEButton.setMnemonic(KeyEvent.VK_A);
        ONEButton.setActionCommand("row");

        JRadioButton TWOButton = new JRadioButton("row 2");
        TWOButton.setMnemonic(KeyEvent.VK_C);
        TWOButton.setActionCommand("row");

        JRadioButton THREEButton = new JRadioButton("row 3");
        THREEButton.setMnemonic(KeyEvent.VK_D);
        THREEButton.setActionCommand("row");

        JRadioButton FOURButton = new JRadioButton("row 4");
        FOURButton.setMnemonic(KeyEvent.VK_R);
        FOURButton.setActionCommand("row");

        JRadioButton FIVEButton = new JRadioButton("row 5");
        FIVEButton.setMnemonic(KeyEvent.VK_P);
        FIVEButton.setActionCommand("row");

        JRadioButton SIXButton = new JRadioButton("row 6");
        SIXButton.setMnemonic(KeyEvent.VK_S);
        SIXButton.setActionCommand("row");

        JRadioButton SEVENButton = new JRadioButton("row 7");
        SEVENButton.setMnemonic(KeyEvent.VK_P);
        SEVENButton.setActionCommand("row");

        JRadioButton EIGHTButton = new JRadioButton("row 8");
        EIGHTButton.setMnemonic(KeyEvent.VK_S);
        EIGHTButton.setActionCommand("row");

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(ONEButton);
        group.add(TWOButton);
        group.add(THREEButton);
        group.add(FOURButton);
        group.add(FIVEButton);
        group.add(SIXButton);
        group.add(SEVENButton);
        group.add(EIGHTButton);

        //Register a listener for the radio buttons.
        ONEButton.addActionListener(this);
        TWOButton.addActionListener(this);
        THREEButton.addActionListener(this);
        FOURButton.addActionListener(this);
        FIVEButton.addActionListener(this);
        SIXButton.addActionListener(this);
        SEVENButton.addActionListener(this);
        EIGHTButton.addActionListener(this);

        //obtains user info
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        label = new JLabel("Select desired row");
        panel.add(label);
        panel.add(ONEButton);
        panel.add(TWOButton);
        panel.add(THREEButton);
        panel.add(FOURButton);
        panel.add(FIVEButton);
        panel.add(SIXButton);
        panel.add(SEVENButton);
        panel.add(EIGHTButton);
        btn.addActionListener(this);
        btn.setActionCommand("pressedNOGO");
        panel.add(btn);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Checker");
        frame.pack();
        frame.setVisible(true);

        while(!pressedRow){Thread.onSpinWait();}

        return row;
    }

    /**
     * Creates a GUI and prompts user for the target column
     * @return target row
     */
    public Column promptTargetCol(){

        //Create the radio buttons.
        JRadioButton AButton = new JRadioButton("Column A");
        AButton.setMnemonic(KeyEvent.VK_A);
        AButton.setActionCommand("col");

        JRadioButton BButton = new JRadioButton("Column B");
        BButton.setMnemonic(KeyEvent.VK_C);
        BButton.setActionCommand("col");

        JRadioButton CButton = new JRadioButton("Column C");
        CButton.setMnemonic(KeyEvent.VK_D);
        CButton.setActionCommand("col");

        JRadioButton DButton = new JRadioButton("Column D");
        DButton.setMnemonic(KeyEvent.VK_R);
        DButton.setActionCommand("col");

        JRadioButton EButton = new JRadioButton("Column E");
        EButton.setMnemonic(KeyEvent.VK_P);
        EButton.setActionCommand("col");

        JRadioButton FButton = new JRadioButton("Column F");
        FButton.setMnemonic(KeyEvent.VK_S);
        FButton.setActionCommand("col");

        JRadioButton GButton = new JRadioButton("Column G");
        GButton.setMnemonic(KeyEvent.VK_P);
        GButton.setActionCommand("col");

        JRadioButton HButton = new JRadioButton("Column H");
        HButton.setMnemonic(KeyEvent.VK_S);
        HButton.setActionCommand("col");

        //Group the radio buttons.
        columns.add(AButton);
        columns.add(BButton);
        columns.add(CButton);
        columns.add(DButton);
        columns.add(EButton);
        columns.add(FButton);
        columns.add(GButton);
        columns.add(HButton);

        //Register a listener for the radio buttons.
        AButton.addActionListener(this);
        BButton.addActionListener(this);
        CButton.addActionListener(this);
        DButton.addActionListener(this);
        EButton.addActionListener(this);
        FButton.addActionListener(this);
        GButton.addActionListener(this);
        HButton.addActionListener(this);

        //obtains user info
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        label = new JLabel("Select desired column");
        panel.add(label);
        panel.add(AButton);
        panel.add(BButton);
        panel.add(CButton);
        panel.add(DButton);
        panel.add(EButton);
        panel.add(FButton);
        panel.add(GButton);
        panel.add(HButton);
        btn.addActionListener(this);
        btn.setActionCommand("pressedNOGO");
        //panel.add(btn);
        frame = new JFrame();
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Checker");
        frame.pack();
        frame.setVisible(true);

        while(!pressedCol){Thread.onSpinWait();}

        return col;
    }

    /**
     * Creates a GUI and promptes user for the target row
     * @return target row
     */
    public int promptTargetRow(){
        //Create the radio buttons.
        JRadioButton ONEButton = new JRadioButton("row 1");
        ONEButton.setMnemonic(KeyEvent.VK_A);
        ONEButton.setActionCommand("row");

        JRadioButton TWOButton = new JRadioButton("row 2");
        TWOButton.setMnemonic(KeyEvent.VK_C);
        TWOButton.setActionCommand("row");

        JRadioButton THREEButton = new JRadioButton("row 3");
        THREEButton.setMnemonic(KeyEvent.VK_D);
        THREEButton.setActionCommand("row");

        JRadioButton FOURButton = new JRadioButton("row 4");
        FOURButton.setMnemonic(KeyEvent.VK_R);
        FOURButton.setActionCommand("row");

        JRadioButton FIVEButton = new JRadioButton("row 5");
        FIVEButton.setMnemonic(KeyEvent.VK_P);
        FIVEButton.setActionCommand("row");

        JRadioButton SIXButton = new JRadioButton("row 6");
        SIXButton.setMnemonic(KeyEvent.VK_S);
        SIXButton.setActionCommand("row");

        JRadioButton SEVENButton = new JRadioButton("row 7");
        SEVENButton.setMnemonic(KeyEvent.VK_P);
        SEVENButton.setActionCommand("row");

        JRadioButton EIGHTButton = new JRadioButton("row 8");
        EIGHTButton.setMnemonic(KeyEvent.VK_S);
        EIGHTButton.setActionCommand("row");

        //Group the radio buttons.
        rows.add(ONEButton);
        rows.add(TWOButton);
        rows.add(THREEButton);
        rows.add(FOURButton);
        rows.add(FIVEButton);
        rows.add(SIXButton);
        rows.add(SEVENButton);
        rows.add(EIGHTButton);

        //Register a listener for the radio buttons.
        ONEButton.addActionListener(this);
        TWOButton.addActionListener(this);
        THREEButton.addActionListener(this);
        FOURButton.addActionListener(this);
        FIVEButton.addActionListener(this);
        SIXButton.addActionListener(this);
        SEVENButton.addActionListener(this);
        EIGHTButton.addActionListener(this);

        //obtains user info
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        label = new JLabel("Select desired row");
        panel.add(label);
        panel.add(ONEButton);
        panel.add(TWOButton);
        panel.add(THREEButton);
        panel.add(FOURButton);
        panel.add(FIVEButton);
        panel.add(SIXButton);
        panel.add(SEVENButton);
        panel.add(EIGHTButton);
        btn.addActionListener(this);
        btn.setActionCommand("");
        //panel.add(btn);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Checker");
        frame.pack();
        frame.setVisible(true);

        while(!pressedRow){Thread.onSpinWait();}

        return row;
    }

    /**
     asks the user the x axis , checks if its valid then returns corresponding Column object

     @return Column col
     */
    public Column getCol(){
        return currentPiece.getCol();
    }

    /**
     asks the user y axis, checks if its valid then returns int

     @return int row
     */
    public int getRow(){
        return currentPiece.getRow();
    }

    /**
     * Creates a GUI and verifies each piece has a valid starting position
     * @param pieces
     */
    public void verify(ArrayList<Figure> pieces){
        ChessBoard board;
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        for(int i = 0; i < pieces.size(); i++){
            board = new ChessBoard(pieces.get(i));
            label = new JLabel("Selected piece: " + pieces.get(i).getColor() + " " + pieces.get(i).getName());
            panel.add(label);
            label = new JLabel("Selected position: " + pieces.get(i).getCol() + ", " + pieces.get(i).getRow());
            panel.add(label);
            valid = board.verifyCoordinates(pieces.get(i).getCol(), pieces.get(i).getRow());
            if(valid){
                label = new JLabel("valid starting position!\n");
                panel.add(label);
            }else {
                label = new JLabel("NOT valid starting position!\n");
                panel.add(label);
            }

        }
        btn.addActionListener(this);
        btn.setActionCommand("move");
        panel.add(btn);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Checker");
        frame.pack();
        frame.setVisible(true);
        while(!pressed){Thread.onSpinWait();}
    }

    /**
     * Creates a GUI and prints whether a piece can move to the desired target position.
     * @param pieces
     * @param targCol
     * @param targRow
     */
    public void verifyTarget(ArrayList<Figure> pieces, Column targCol, int targRow){
        ChessBoard board;
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        for(int i = 0; i < pieces.size(); i++){
            board = new ChessBoard(pieces.get(i));
            label = new JLabel("Selected piece: " + pieces.get(i).getColor() + " " + pieces.get(i).getName());
            panel.add(label);
            label = new JLabel("starting position: " + pieces.get(i).getCol() + ", " + pieces.get(i).getRow());
            panel.add(label);
            valid = pieces.get(i).moveTo(targCol, targRow);
            if(valid){
                label = new JLabel(pieces.get(i).getName() + " can move to " + targCol.toString() + ", "+ targRow + "!\n\n");
                panel.add(label);
            }else {
                label = new JLabel(pieces.get(i).getName() + " CANNOT move to " + targCol.toString() + ", "+ targRow + "!\n\n");
                panel.add(label);
            }
        }
        btn = new JButton("Close");
        btn.addActionListener(this);
        btn.setActionCommand("close");
        panel.add(btn);
        frame = new JFrame();
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Checker");
        frame.pack();
        frame.setVisible(true);
    }



    /**
     * listens for an action from the user and sets fields based on their
     * chosen chess piece parameter.
     *
     * @param e The action event is the user clicking on a radio button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "col" -> {
                ArrayList<AbstractButton> buttonList = new ArrayList<AbstractButton>();
                Enumeration<AbstractButton> button = columns.getElements();
                for (int i = 0; i < columns.getButtonCount(); i++) {
                    buttonList.add(button.nextElement());
                }

                if (columns.isSelected(buttonList.get(0).getModel())) {
                    col = Column.A;
                } else if (columns.isSelected(buttonList.get(1).getModel())) {
                    col = Column.B;
                } else if (columns.isSelected(buttonList.get(2).getModel())) {
                    col = Column.C;
                } else if (columns.isSelected(buttonList.get(3).getModel())) {
                    col = Column.D;
                } else if (columns.isSelected(buttonList.get(4).getModel())) {
                    col = Column.E;
                } else if (columns.isSelected(buttonList.get(5).getModel())) {
                    col = Column.F;
                } else if (columns.isSelected(buttonList.get(6).getModel())) {
                    col = Column.G;
                } else if (columns.isSelected(buttonList.get(7).getModel())) {
                    col = Column.H;
                }
                pressedCol = true;
                frame.dispose();
            }

            case "row" -> {
                ArrayList<AbstractButton> buttonList = new ArrayList<AbstractButton>();
                Enumeration<AbstractButton> button = rows.getElements();
                for (int i = 0; i < rows.getButtonCount(); i++) {
                    buttonList.add(button.nextElement());
                }

                if (rows.isSelected(buttonList.get(0).getModel())) {
                    row = 1;
                } else if (rows.isSelected(buttonList.get(1).getModel())) {
                    row = 2;
                } else if (rows.isSelected(buttonList.get(2).getModel())) {
                    row = 3;
                } else if (rows.isSelected(buttonList.get(3).getModel())) {
                    row = 4;
                } else if (rows.isSelected(buttonList.get(4).getModel())) {
                    row = 5;
                } else if (rows.isSelected(buttonList.get(5).getModel())) {
                    row = 6;
                } else if (rows.isSelected(buttonList.get(6).getModel())) {
                    row = 7;
                } else if (rows.isSelected(buttonList.get(7).getModel())) {
                    row = 8;
                }
                pressedRow = true;
                frame.dispose();
            }

            case "move" -> {
                pressed = true;
                frame.dispose();
            }

            case "close" -> {frame.dispose();}
        }
    }
}


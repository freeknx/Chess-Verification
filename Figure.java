package com.school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;

public class Figure extends Frame implements IntFigure {
    protected Piece pieceName;
    protected Color color;
    protected int row;
    protected Column col;
    protected volatile boolean valid;
    protected Figure currentPiece;
    private boolean pressedPiece = false;
    private boolean pressedCol = false;
    private boolean pressedRow = false;
    private boolean pressedHue = false;

    //Constructors
    Figure() {
        super();
        this.pieceName = Piece.pawn;
        this.color = Color.white;
        this.row = 1;
        this.col = Column.A;
        this.valid = false;
    }


    Figure(Piece pieceName) {
        super();
        this.pieceName = pieceName;
        this.color = color;
        this.valid = false;
        btn = new JButton("Next");
    }

    //getters
    public String getColor() {
        return String.valueOf(color);
    }

    public String getName() {
        String name = "";
        switch (pieceName) {
            case pawn -> {
                name = "pawn";
                break;
            }
            case king -> {
                name = "King";
                break;
            }
            case rook -> {
                name = "Rook";
                break;
            }
            case bishop -> {
                name = "Bishop";
                break;
            }
            case queen -> {
                name = "Queen";
                break;
            }
            case knight -> {
                name = "Knight";
                break;
            }
        }
        return name;
    }

    public int getRow() {
        return row;
    }


    public Column getCol() {
        return col;
    }

    public boolean getValid() {
        return valid;
    }

    //setters
    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(Column col) {
        this.col = col;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Creates a GUI and asks user which chess piece they would like to use,
     * then selects color, starting column, and starting row
     *
     * @return returns a Figure object of the selected type and parameters
     */
    public Figure GUI() {
        //Create the radio buttons.
        JRadioButton pawnButton = new JRadioButton("pawn");
        pawnButton.setMnemonic(KeyEvent.VK_B);
        pawnButton.setActionCommand("piece");

        JRadioButton kingButton = new JRadioButton("king");
        kingButton.setMnemonic(KeyEvent.VK_C);
        kingButton.setActionCommand("piece");

        JRadioButton queenButton = new JRadioButton("queen");
        queenButton.setMnemonic(KeyEvent.VK_D);
        queenButton.setActionCommand("piece");

        JRadioButton rookButton = new JRadioButton("rook");
        rookButton.setMnemonic(KeyEvent.VK_R);
        rookButton.setActionCommand("piece");


        JRadioButton bishopButton = new JRadioButton("bishop");
        bishopButton.setMnemonic(KeyEvent.VK_P);
        bishopButton.setActionCommand("piece");

        JRadioButton knightButton = new JRadioButton("knight");
        knightButton.setMnemonic(KeyEvent.VK_S);
        knightButton.setActionCommand("piece");

        //colors
        JRadioButton blackButton = new JRadioButton("black");
        blackButton.setActionCommand("color");

        JRadioButton whiteButton = new JRadioButton("white");
        whiteButton.setActionCommand("color");

        //columns
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

        //rows
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
        group.add(pawnButton);
        group.add(kingButton);
        group.add(queenButton);
        group.add(rookButton);
        group.add(bishopButton);
        group.add(knightButton);

        hues.add(blackButton);
        hues.add(whiteButton);

        columns.add(AButton);
        columns.add(BButton);
        columns.add(CButton);
        columns.add(DButton);
        columns.add(EButton);
        columns.add(FButton);
        columns.add(GButton);
        columns.add(HButton);

        rows.add(ONEButton);
        rows.add(TWOButton);
        rows.add(THREEButton);
        rows.add(FOURButton);
        rows.add(FIVEButton);
        rows.add(SIXButton);
        rows.add(SEVENButton);
        rows.add(EIGHTButton);

        //Register a listener for the radio buttons.
        pawnButton.addActionListener(this);
        kingButton.addActionListener(this);
        queenButton.addActionListener(this);
        rookButton.addActionListener(this);
        bishopButton.addActionListener(this);
        knightButton.addActionListener(this);

        blackButton.addActionListener(this);
        whiteButton.addActionListener(this);

        //Register a listener for the radio buttons.
        AButton.addActionListener(this);
        BButton.addActionListener(this);
        CButton.addActionListener(this);
        DButton.addActionListener(this);
        EButton.addActionListener(this);
        FButton.addActionListener(this);
        GButton.addActionListener(this);
        HButton.addActionListener(this);

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
        this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        JLabel colorLabel = new JLabel("Select color first");
        panel.add(colorLabel);
        panel.add(blackButton);
        panel.add(whiteButton);
        label = new JLabel("Select desired chess piece");
        panel.add(label);
        panel.add(pawnButton);
        panel.add(kingButton);
        panel.add(queenButton);
        panel.add(rookButton);
        panel.add(bishopButton);
        panel.add(knightButton);
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
        label = new JLabel("Select desired row for ");
        panel.add(label);
        panel.add(ONEButton);
        panel.add(TWOButton);
        panel.add(THREEButton);
        panel.add(FOURButton);
        panel.add(FIVEButton);
        panel.add(SIXButton);
        panel.add(SEVENButton);
        panel.add(EIGHTButton);
        btn = new JButton("Next");
        btn.addActionListener(this);
        btn.setActionCommand("pressed");
        panel.add(btn);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Checker");
        frame.pack();
        frame.setVisible(true);

        //waits until user inputs all info to return
        while (!valid) {
            Thread.onSpinWait();

        }

        return currentPiece;
    }

    /**
     * listens for an action from the user and sets fields based on their
     * chosen chess piece parameter.
     *
     * @param e The action event is the user clicking on a radio button
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "piece" -> {
                pressedPiece = true;    //tells GUI to return
                ArrayList<AbstractButton> buttonList = new ArrayList<AbstractButton>(); //creates
                Enumeration<AbstractButton> button = group.getElements();
                for (int i = 0; i < group.getButtonCount(); i++) {
                    buttonList.add(button.nextElement());
                }

                if (group.isSelected(buttonList.get(0).getModel())) {
                    currentPiece = new Pawn(Piece.pawn);
                } else if (group.isSelected(buttonList.get(3).getModel())) {
                    currentPiece = new Rook(Piece.rook);
                } else if (group.isSelected(buttonList.get(1).getModel())) {
                    currentPiece = new King(Piece.king);
                } else if (group.isSelected(buttonList.get(2).getModel())) {
                    currentPiece = new Queen(Piece.queen);
                } else if (group.isSelected(buttonList.get(5).getModel())){
                    currentPiece = new Knight(Piece.knight);
                } else if (group.isSelected(buttonList.get(4).getModel())){
                    currentPiece = new Bishop(Piece.bishop);
                }
            }

            case "col" -> {
                pressedCol = true;
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

            }

            case "row" -> {
                pressedRow = true;
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

            }

            case "color" -> {
                pressedHue = true;
                ArrayList<AbstractButton> buttonList = new ArrayList<AbstractButton>();
                Enumeration<AbstractButton> button = hues.getElements();
                for (int i = 0; i < hues.getButtonCount(); i++) {
                    buttonList.add(button.nextElement());
                }

                if (hues.isSelected(buttonList.get(1).getModel())) {
                    color = Color.white;
                } else if (hues.isSelected(buttonList.get(0).getModel())) {
                    color = Color.black;
                }

            }

            case "pressed" -> {
                if (pressedPiece && pressedHue && pressedCol && pressedRow) {
                    currentPiece.setValid(true);
                    valid = true;
                    currentPiece.setRow(row);
                    currentPiece.setColor(Color.black);
                    currentPiece.setCol(col);
                    frame.dispose();

                } else {
                    label = new JLabel("Must pick one from each category");
                    panel.add(label);
                    SwingUtilities.updateComponentTreeUI(frame);
                }
            }

        }
    }

    @Override
    public boolean moveTo(Column x, int y) {
        return false;
    }
}
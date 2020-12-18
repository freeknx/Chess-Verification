package com.school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessBoard extends VerifyGUI implements IntChessBoard, ActionListener {
    //fields
    private final int MAX_ROW = 8;
    private final int MIN_ROW = 0;
    private Column col;
    private String[][] board_coordinates = new String[MAX_ROW][MAX_ROW];
    private StringBuilder sb = new StringBuilder();
    private JFrame frame;
    private JPanel panel;
    private JButton btn;
    private JLabel label;
    private Figure currentPiece;
    private int newRow;
    private Column newCol;
    private VerifyGUI tempCol = new VerifyGUI();
    private VerifyGUI tempRow = new VerifyGUI();
    private boolean valid;


    //integers to be converted to Chars
    //refer to ascii table
    //creates 2d array with all possible chess move positions
    ChessBoard(Figure currentPiece){
        int board_columns = 65;
        int board_row = 49;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board_coordinates[i][j] = String.valueOf((char)(board_columns + j));
                board_coordinates[i][j] += String.valueOf((char)(board_row + i));
            }
        }
        frame = new JFrame();
        panel = new JPanel();
        btn = new JButton("Try Again");
        this.currentPiece = currentPiece;
    }

    /**
     takes in an x and y axis and determines if that move is even possible.

     @param  row: the y axis
     @param  col: the x axis

     @return boolean
     */
    public boolean verifyCoordinatesHelper(Column col, int row){
        String temp = String.valueOf(col);
        char targetCol = temp.charAt(0);
        char targetRow = (char)(row + 48);
        sb.append(targetCol).append(targetRow);
        String coord = sb.toString();

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board_coordinates[i][j].equals(coord)){
                    return true;
                }

            }
        }
        return false;
    }

    public boolean verifyCoordinates(Column col, int row){

        try{
            if((col.equals(Column.A)) || (col.equals(Column.B)) || (col.equals(Column.C)) || (col == Column.D)
                    || col == Column.E || col == Column.F || col == Column.G || col == Column.H){
                if(1 <= row && row <= 8){
                    boolean isValid = verifyCoordinatesHelper(col, row);
                    return isValid;
                }
                else throw new InvalidInputException("Row must be between 1-8");
            }
            else throw new InvalidInputException("Column must be between a-h");

        }
        catch(InvalidInputException e){

            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
            panel.setLayout(new GridLayout(0,1));
            label = new JLabel("Mistake Happened: " + e + "\n Please input the correct Row and Column: ");
            panel.add(label);

            btn.addActionListener(this);
            btn.setActionCommand("pressed");
            panel.add(btn);
            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Chess Checker");
            frame.pack();
            frame.setVisible(true);

            while(!valid){Thread.onSpinWait();}

            return verifyCoordinates(newCol, newRow);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "pressed" -> {
                newRow = tempRow.promptTargetRow(currentPiece);
                newCol = tempCol.promptTargetCol(currentPiece);
                valid = true;
            }
        }
    }
}
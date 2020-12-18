package com.school;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Pawn extends Figure{
    private JPanel Tpanel = new JPanel();
    //constructor
    Pawn(){
        super();
        this.pieceName = Piece.pawn;
    }

    Pawn(Piece pieceName){
        super(pieceName);
    }

    /**
     takes in an x and y axis and the current chess piece and
     determines the elibility of moving to that position from
     the set, or initial, x and y axis based on the rules for
     the current chess piece.

     @param int row: the y axis
     @param Column col: the x axis

     @return boolean
     */

    @Override
    public boolean moveTo(Column col, int row){
        boolean possibleMove = false;
        String tempTarget = String.valueOf(col);
        int num = tempTarget.charAt(0);

        String tempDest = String.valueOf(this.col);
        int num2 = tempDest.charAt(0);
        // y-axis can only have a difference of one x-axis must not change.
        //if color is black, it can only move in the -y direction. vice versa
        if(color.equals("black")){
            possibleMove = (num == num2) && (row - this.row == -1);
        }
        else possibleMove = (num == num2)  && (row - this.row == 1);

        return possibleMove;
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }

}

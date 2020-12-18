package com.school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //initializes piece objects
        Figure piece1 = new Figure();
        Figure piece2 = new Figure();
        Figure piece3 = new Figure();
        Figure piece4 = new Figure();
        Figure piece5 = new Figure();
        Figure piece6 = new Figure();



        //creates container of Figure objects
        ArrayList<Figure> pieces = new ArrayList<Figure>();

        //adds each piece to container
        pieces.add(piece1.GUI());
        pieces.add(piece2.GUI());
        pieces.add(piece3.GUI());
        pieces.add(piece4.GUI());
        pieces.add(piece5.GUI());
        pieces.add(piece6.GUI());

        //creates verification objects
        VerifyGUI verifyPieces = new VerifyGUI(pieces);
        verifyPieces.verify(pieces);    //verifies each piece has a valid starting position

        VerifyGUI tempCol = new VerifyGUI();
        VerifyGUI tempRow = new VerifyGUI();
        VerifyGUI tempPiece = new VerifyGUI();
        Column tCol = tempCol.promptTargetCol();    //target column
        int tRow = tempRow.promptTargetRow();       //target row
        tempPiece.verifyTarget(pieces, tCol, tRow); //verifies pieces can  move to target position


    }
}

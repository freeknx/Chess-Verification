package com.school;

public class Knight extends Figure{

    //Constructors
    Knight(){
        super();
    }

    Knight(Piece pieceName){
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

        possibleMove = ((Math.abs(num - num2) == 2) && (Math.abs(row - this.row) == 1)) ||
                ((Math.abs(num - num2) == 1) && (Math.abs(row - this.row) == 2));
        return possibleMove;
    }

}

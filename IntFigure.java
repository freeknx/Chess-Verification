package com.school;

public interface IntFigure {
    boolean moveTo(Column x, int y);
}

//class containing chess pieces and all possible attributes
enum Piece{
    pawn, queen, king, bishop, rook, knight;
}

//objects for all possible x axis
enum Column{
    A, B, C, D, E, F, G, H;

}

//contains color objects
enum Color{
    black, white;
}

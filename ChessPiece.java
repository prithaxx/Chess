import java.util.ArrayList;

// This is the parent class for all ChessPieces. 
public abstract class ChessPiece{
    // KING, QUEEN, BISHOP, ROOK, KNIGHT, PAWN
    boolean flag=true,flag1=true;

    private String type = "Generic Chess Piece";

    // "BLACK" or "WHITE"
    protected String color = "UNKNOWN";

    // File graphic references. 
    private String graphicBlack = "chess-board-and-pieces.jpg";
    private String graphicWhite = "chess-board-and-pieces.jpg";

    // a reference to the current board (needed for many methods)
    private Board boardRef;

    // Will enable additional debugging output. 
    protected final boolean DEBUG_MODE = false;

    // Base constructor. 
    // type is the piece type 
    // color is "BLACK" or "WHITE"
    // theBoard is the current board in use. 
    public ChessPiece(String type, String color, Board theBoard){
        this.type = type;
        this.color = color;
        boardRef = theBoard;
    }

    // --- Accessors ---
    // Over ride to return PAWN
    public String toString(){
        return color + " " + getType();
    }

    // Return a reference to the current board. 
    public Board getBoard(){
        return boardRef;
    }

    // Retrieve the type. 
    public String getType(){
        return type;
    }
    // The color of this piece. 
    public String getColor(){
        return color;
    }

    // Retrieve the graphic. Used for the Board class when drawing. 
    public String getGraphic(){
        if(color.equals(Board.black)){
            return graphicBlack;
        }else{
            return graphicWhite;
        }
    }

    // --- Mutators ---
    public void setGraphics(String blackGraphic, String whiteGraphic ){
        graphicBlack = blackGraphic;
        graphicWhite = whiteGraphic;
    }

    // Is the move from a given tile to a given tile a valid move (for this peice type?)
    // Port this to just use row and col anyways. 
    public boolean isValidMove( int currentRow, int currentCol, int futureRow, int futureCol ){
        System.out.println("Should not get called");
        return false;
    }

    //moves Castle and Queen n steps vertically upwards or downwards
    public boolean isVertical(int currentRow, int currentCol, int futureRow, int futureCol){
        boolean isTheMoveValid = false;
        boolean pieceBlockingMove = false;
        if (currentCol == futureCol) {
            //vertically upwards
            if ((futureRow - currentRow) > 0) {
                for (int i = currentRow + 1; i <= futureRow; i++) {
                    //If a piece is in front of the current piece returns false else
                    //returns true
                    if (pieceBlockingMove) 
                        isTheMoveValid = false;
                    else 
                    {
                        //if there is a piece in path then checks if its color.
                        //move is valid if colour is different else returns false.
                        if (boardRef.hasPiece(i, currentCol)) {
                            if ((boardRef.getPieceColor(i, currentCol)).equals(boardRef.getPieceColor(currentRow, currentCol))) 
                                isTheMoveValid = false;
                            else 
                                isTheMoveValid = true;
                            pieceBlockingMove = true;
                        } 
                        else 
                            isTheMoveValid = true;
                    }
                }
            }
            //vertically downwards
            if ((futureRow - currentRow) < 0) {
                for (int i = currentRow - 1; i >= futureRow; i--) {
                    //If a piece is in front of the current piece returns false else
                    //returns true
                    if (pieceBlockingMove)
                        isTheMoveValid = false;
                    else 
                    {
                        //if there is a piece in path then checks if its color.
                        //move is valid if colour is different else returns false.
                        if (boardRef.hasPiece(i, currentCol)) {
                            if ((boardRef.getPieceColor(i, currentCol)).equals(boardRef.getPieceColor(currentRow, currentCol))) 
                                isTheMoveValid = false;
                            else 
                                isTheMoveValid = true;
                            pieceBlockingMove = true;
                        } 
                        else 
                            isTheMoveValid = true;
                    }
                }
            }
        }
        return isTheMoveValid;
    }
    
    //moves Castle and Queen n steps horizontally right or left
    public boolean isHorizontal(int currentRow, int currentCol, int futureRow, int futureCol){
        boolean isTheMoveValid = false;
        boolean pieceBlockingMove = false;
        //horizonatally left
        if (currentRow == futureRow) {
            if ((futureCol - currentCol) > 0) {
                for (int j = currentCol + 1; j <= futureCol; j++) {
                    //If a piece is in front of the current piece returns false else
                    //returns true
                    if (pieceBlockingMove) 
                        isTheMoveValid = false;
                    else {
                        //if there is a piece in path then checks if its color.
                        //move is valid if colour is different else returns false.
                        if (boardRef.hasPiece(currentRow, j)) {
                            if ((boardRef.getPieceColor(currentRow, j)).equals(boardRef.getPieceColor(currentRow, currentCol))) 
                                isTheMoveValid = false;
                            else 
                                isTheMoveValid = true;
                            pieceBlockingMove = true;
                        }
                        else 
                            isTheMoveValid = true;
                    }
                }
            }
            //horizontally right
            if ((futureCol - currentCol) < 0) {
                for (int j = currentCol - 1; j >= futureCol; j--) {
                    //If a piece is in front of the current piece returns false else
                    //returns true
                    if (pieceBlockingMove) 
                        isTheMoveValid = false;
                    else {
                        //if there is a piece in path then checks if its color.
                        //move is valid if colour is different else returns false.
                        if (boardRef.hasPiece(currentRow, j)) {
                            if ((boardRef.getPieceColor(currentRow, j)).equals(boardRef.getPieceColor(currentRow, currentCol))) 
                                isTheMoveValid = false;
                            else 
                                isTheMoveValid = true;
                            pieceBlockingMove = true;
                        } 
                        else
                            isTheMoveValid = true;
                    }
                }
            }
        }
        return isTheMoveValid;
    }
    //moves Bishop and Queen n steps diagonal
    public boolean isDiagonal(int currentRow, int currentCol, int futureRow, int futureCol){
        boolean isTheMoveValid = false;
        boolean pieceBlockingMove = false;
        if (Math.abs(futureRow-currentRow)==Math.abs(futureCol-currentCol)) {
            //checks for top-right diagonal tiles
            if ((futureRow - currentRow) > 0 && (futureCol - currentCol) > 0) {
                //i and j increases as loop iterates
                //so value of rows and cols increase together
                // thus, top-right tiles
                for (int i = currentRow + 1, j = currentCol + 1; i <= futureRow && j <= futureCol; i++, j++) {
                    //If a piece is diagonally adjacent of the current piece 
                    //returns false else returns true
                    if (pieceBlockingMove) 
                        isTheMoveValid = false;
                    else {
                        //if there is a piece in path then checks if its color.
                        //move is valid if colour is different else returns false.
                        if (boardRef.hasPiece(i, j)) {
                            if (boardRef.getPieceColor(currentRow, currentCol).equals(boardRef.getPieceColor(i, j))) 
                                isTheMoveValid = false;
                            else 
                                isTheMoveValid = true;
                            pieceBlockingMove = true;
                        } 
                        else 
                            isTheMoveValid = true;
                    }
                }
            }
            //checks for bottom-left diagonal tiles
            if ((futureRow - currentRow) < 0 && (futureCol - currentCol) < 0) {
                //i and j decreases as loop iterates
                //so value of rows and cols decrease together
                // thus, bottom-left tiles
                for (int i = currentRow - 1, j = currentCol - 1; i >= futureRow && j >= futureCol; i--, j--) {
                    //If a piece is diagonally adjacent of the current piece 
                    //returns false else returns true
                    if (pieceBlockingMove) 
                        isTheMoveValid = false;
                    else {
                        //if there is a piece in path then checks if its color.
                        //move is valid if colour is different else returns false.
                        if (boardRef.hasPiece(i, j)) {
                            if (boardRef.getPieceColor(currentRow, currentCol).equals(boardRef.getPieceColor(i, j))) 
                                isTheMoveValid = false;
                            else 
                                isTheMoveValid = true;
                            pieceBlockingMove = true;
                        } 
                        else 
                            isTheMoveValid = true;
                    }
                }
            }
            //checks for bottom-right diagonal tiles
            if ((futureRow - currentRow) < 0 && (futureCol - currentCol) > 0) {
                //i decreases and j increases as loop iterates
                //so value of rows decreases and cols increases together
                // thus, bottom-right tiles
                for (int i = currentRow - 1, j = currentCol + 1; i >= futureRow && j <= futureCol; i--, j++) {
                    //If a piece is diagonally adjacent of the current piece 
                    //returns false else returns true
                    if (pieceBlockingMove) 
                        isTheMoveValid = false;
                    else {
                        //if there is a piece in path then checks if its color.
                        //move is valid if colour is different else returns false.
                        if (boardRef.hasPiece(i, j)) {
                            if (boardRef.getPieceColor(currentRow, currentCol).equals(boardRef.getPieceColor(i, j))) 
                                isTheMoveValid = false;
                            else 
                                isTheMoveValid = true;
                            pieceBlockingMove = true;
                        } 
                        else 
                            isTheMoveValid = true;
                    }
                }
            }
            //checks for top-left diagonal tiles
            if ((futureRow - currentRow) > 0 && (futureCol - currentCol) < 0) {
                //i increases and j decreases as loop iterates
                //so value of rows increases and cols decreases together
                // thus, top-left tiles
                for (int i = currentRow + 1, j = currentCol - 1; i <= futureRow && j >= futureCol; i++, j--) {
                    //If a piece is diagonally adjacent of the current piece 
                    //returns false else returns true
                    if (pieceBlockingMove) 
                        isTheMoveValid = false;
                    else {
                        //if there is a piece in path then checks if its color.
                        //move is valid if colour is different else returns false.
                        if (boardRef.hasPiece(i, j)) {
                            if (boardRef.getPieceColor(currentRow, currentCol).equals(boardRef.getPieceColor(i, j))) 
                                isTheMoveValid = false;
                            else 
                                isTheMoveValid = true;
                            pieceBlockingMove = true;
                        } else 
                            isTheMoveValid = true;
                    }
                }
            }
        }
        return isTheMoveValid;
    }
    
    //checks the colors before capturing a piece. It checks if the current piece
    //color is different to future piece color and captures it else
    //returns false. (mainly used by King and Knight class)
    //(Queen,Bishop and Castle works without this method.)
    //(Pawn does not use this method at all)
    public boolean isRestrictedMove(int currentRow, int currentCol, int futureRow, int futureCol){
        if((boardRef.hasPiece(futureRow,futureCol) && !boardRef.getPieceColor(futureRow,futureCol).equals(boardRef.getPieceColor(currentRow,currentCol))))
            return true;   
        if(!boardRef.hasPiece(futureRow,futureCol))
            return true;
        if((boardRef.hasPiece(futureRow,futureCol) && boardRef.getPieceColor(futureRow,futureCol).equals(boardRef.getPieceColor(currentRow,currentCol))))
            return false;
        else
            return false;
    }
}
//This class takes care of the movements
//of the Pawn Piece

public class Pawn extends ChessPiece{
    private Board theBoard;
    
    //Sets the Pawn graphics in the board
    public Pawn(String newColor, Board theBoard){
        super("Pawn",newColor,theBoard);
        setGraphics("PawnBlack.png","PawnWhite.png");
        this.theBoard=theBoard;
    }
    
    //Sets the Pawn graphics in the board
    public Pawn(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("PawnBlack.png","PawnWhite.png");
        this.theBoard=theBoard;
    }
    
    //Calculates the basic movements of a Pawn 
    //based on its colour. The first move of every pawn
    //can be upto two boxes forward, the next move
    //can only be one step forward.
    public boolean isForwardMove(int currentRow, int currentCol, int futureRow, int futureCol){
        String color=theBoard.getPieceColor(currentRow,currentCol);
        //Sets the explained movement based on White Pawns
        if(color.equals("WHITE")){
            if(futureRow<4){
                //Atleast two steps forward
                if((futureRow==currentRow+2 && futureCol==currentCol)||
                (futureRow==currentRow+1 && futureCol==currentCol))
                    return true;
            }
            else{
                //One step forward
                if(futureRow==currentRow+1 && futureCol==currentCol)
                    return true;
            }
        }
        //Sets the explained movement based on Black Pawns
        else if(color.equals("BLACK")){
            if(futureRow>3){
                //Atleast two steps forward
                if((futureRow==currentRow-2 && futureCol==currentCol)||
                (futureRow==currentRow-1 && futureCol==currentCol))
                    return true;
            }
            else{
                //One step forward
                if(futureRow==currentRow-1 && futureCol==currentCol)
                    return true;
            }
        }
        return false;
    }
    
    //Calculates the capturing movement of a Pawn 
    //based on its color. A pawn can only move 
    //one step diagonally forward to capture another piece.
    public boolean diagonalCapture(int currentRow, int currentCol, int futureRow, int futureCol){
        String color=theBoard.getPieceColor(currentRow,currentCol);
        //Capture movement based on White Pawns
        if(color.equals("WHITE")){
            if(futureRow==currentRow+1 && (futureCol==currentCol+1 || futureCol==currentCol-1))
                return true;
        }
        //Capture movement based on Black Pawns
        else if(color.equals("BLACK")){
            if(futureRow==currentRow-1 && (futureCol==currentCol+1 || futureCol==currentCol-1))
                return true;
        }
        return false;
    }
    
    //Checks if the move made by a Pawn
    //is valid or not. 
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol ){
        if(!theBoard.hasPiece(futureRow,futureCol))
            return isForwardMove(currentRow,currentCol,futureRow,futureCol);
        if(theBoard.hasPiece(futureRow,futureCol) && !theBoard.getPieceColor(futureRow,futureCol).equals(theBoard.getPieceColor(currentRow,currentCol)))
            return diagonalCapture(currentRow,currentCol,futureRow,futureCol);
        System.out.println("Should not get called");
        return false;
    }
}
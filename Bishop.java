//This class takes care of the movements
//of the Bishop Piece

public class Bishop extends ChessPiece{
    private Board theBoard;
    
    //Sets the Bishop graphics in the board
    public Bishop(String newColor, Board theBoard){
        super("Bishop",newColor,theBoard);
        setGraphics("BishopBlack.png","BishopWhite.png");
        this.theBoard=theBoard;
    }
    
    //Sets the Bishop graphics in the board
    public Bishop(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("BishopBlack.png","BishopWhite.png");
        this.theBoard=theBoard;
    }
    
    //Checks if the move made by the Bishop
    //is valid or not. 
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol ){
        if(isRestrictedMove(currentRow,currentCol,futureRow,futureCol))
            return isDiagonal(currentRow,currentCol,futureRow,futureCol);
        System.out.println("Should not get called");
        return false;
    }
}

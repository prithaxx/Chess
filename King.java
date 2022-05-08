//This class takes care of the movements
//of the King Piece

public class King extends ChessPiece{
    private Board theBoard;
    
    //Sets the King graphics in the board
    public King(String newColor, Board theBoard){
        super("King",newColor,theBoard);
        setGraphics("KingBlack.png","KingWhite.png");
        this.theBoard=theBoard;
    }
    
    //Sets the King graphics in the board
    public King(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("KingBlack.png","KingWhite.png");
        this.theBoard=theBoard;
    }
    
    //Checks if the move made by the King
    //is valid or not. 
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol ){
        if(isRestrictedMove(currentRow,currentCol,futureRow,futureCol)){            
            if((futureRow==currentRow+1||futureRow==currentRow-1||futureRow==currentRow)&&
            (futureCol==currentCol+1||futureCol==currentCol-1||futureCol==currentCol))
                return true;
        }
        System.out.println("Should not get called");
        return false;
    }
}
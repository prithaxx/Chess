//This class takes care of the movements
//of the Castle Piece

public class Castle extends ChessPiece{
    private Board theBoard;
    
    //Sets the Castle graphics in the board
    public Castle(String newColor, Board theBoard){
        super("Castle",newColor,theBoard);
        setGraphics("CastleBlack.png","CastleWhite.png");
        this.theBoard=theBoard;
    }
    
    //Sets the Castle graphics in the board
    public Castle(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("CastleBlack.png","CastleWhite.png");
        this.theBoard=theBoard;
    }
    
    //Checks if the move made by the Castle
    //is valid or not. 
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol ){
        if(isHorizontal(currentRow,currentCol,futureRow,futureCol)|| isVertical(currentRow,currentCol,futureRow,futureCol))
            return (isRestrictedMove(currentRow,currentCol,futureRow,futureCol));
        System.out.println("Should not get called");
        return false;
    }
}

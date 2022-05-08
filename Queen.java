//This class takes care of the movements
//of the Queen Piece

public class Queen extends ChessPiece{
    private Board theBoard;
    
    //Sets the Queen graphics in the board
    public Queen(String newColor, Board theBoard){
        super("Queen",newColor,theBoard);
        setGraphics("QueenBlack.png","QueenWhite.png");
        this.theBoard=theBoard;
    }
    
    //Sets the Queen graphics in the board
    public Queen(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("QueenBlack.png","QueenWhite.png");
        this.theBoard=theBoard;
    }
    
    //Checks if the move made by the Queen
    //is valid or not. 
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol ){
        if(isRestrictedMove(currentRow,currentCol,futureRow,futureCol))
            return isDiagonal(currentRow,currentCol,futureRow,futureCol) || isHorizontal(currentRow,currentCol,futureRow,futureCol)|| 
            isVertical(currentRow,currentCol,futureRow,futureCol);
        System.out.println("Should not get called");
        return false;
    }
}

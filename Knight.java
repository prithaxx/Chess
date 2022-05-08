//This class takes care of the movements
//of the Knight Piece

public class Knight extends ChessPiece{
    private Board theBoard;
    
    //Sets the Knight graphics in the board
    public Knight(String newColor, Board theBoard){
        super("Knight",newColor,theBoard);
        setGraphics("KnightBlack.png","KnightWhite.png");
        this.theBoard=theBoard;
    }
    
    //Sets the Knight graphics in the board
    public Knight(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("KnightBlack.png","KnightWhite.png");
        this.theBoard=theBoard;
    }
    
    //Calculates the Two and Half movements of Knight.
    //Also takes care of the jumps that only Knight
    //can make over any other piece.
    public boolean isTwoAndHalf(int currentRow, int currentCol, int futureRow, int futureCol){
        if((futureRow==currentRow+1 && (futureCol==currentCol-2 || futureCol==currentCol+2))||
        (futureRow==currentRow-1 && (futureCol==currentCol-2 || futureCol==currentCol+2))||
        (futureRow==currentRow+2 && (futureCol==currentCol-1 || futureCol==currentCol+1))||
        (futureRow==currentRow-2 && (futureCol==currentCol-1 || futureCol==currentCol+1)))
            return true;
        else
            return false;
    }
    
    //Checks if the move made by the Knight
    //is valid or not. 
    public boolean isValidMove(int currentRow, int currentCol, int futureRow, int futureCol ){
        if(isRestrictedMove(currentRow,currentCol,futureRow,futureCol))
            return isTwoAndHalf(currentRow,currentCol,futureRow,futureCol);
        System.out.println("Should not get called");
        return false;
    }
}
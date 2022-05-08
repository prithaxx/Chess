//This class loads a file that represents the Board
import java.io.*;
import java.util.Scanner;
public class BoardLoader{
    private static String folder=".\\Boards\\StandardBoard.txt";
    
    //Loads the board and handles all the
    //other methods in the class
    public static void loadBoardState(Board theBoard, String fileName){
        String[][] board=parseFile(folder);
        loadPiecesFromString(theBoard,board);
    }
    
    //Sets the size of the boardArray[][] and inputs
    //all the board codes into it. It also throws in
    //exceptions if there were any. 
    private static String[][] parseFile(String fileName){
        String[][] boardArray=null;
        try{
            FileReader theFile = new FileReader(fileName);
            BufferedReader inFile = new BufferedReader(theFile);
            String output = inFile.readLine();
            Scanner scan;
            String token;
            int i=0,size,count=0;
            while(output!=null){
                scan=new Scanner(output);
                //Initializes the 2D array
                while(scan.hasNextInt()){
                    i=scan.nextInt();
                    boardArray=new String[i][scan.nextInt()];
                }
                size=boardArray.length*boardArray[0].length;
                //Fills the 2D array with the board codes
                //in the form of Strings.
                while(scan.hasNext()){
                    token=scan.next();
                    if(count!=size){
                        boardArray[count/boardArray.length][count%boardArray.length]=token;
                        count++;
                    }
                }
                output=inFile.readLine();
            }
            //Releases control of the file.
            theFile.close();
        }
        //Throws all types of Exception if there are any.
        catch (Exception e){
            System.out.println("Sorry something went wrong");
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return boardArray;
    }
    
    //Gets all the ChessPiece subclass objects containing the 
    //board codes and loadd them in the Board Object.
    private static void loadPiecesFromString(Board targetBoard, String[][]boardCodes){
        for(int i=0;i<boardCodes.length;i++){
            for(int j=0;j<boardCodes[0].length;j++){
                ChessPiece piece=loadChessPiece(targetBoard,boardCodes[i][j]);
                targetBoard.setTile(boardCodes.length,boardCodes.length,piece);
            }
        }
    }
    
    //Gets the code of each piece and differentiates it on the 
    //basis of color and type. Assigns the color and type code 
    //to their appropriate ChessPiece sublclass objects.
    private static ChessPiece loadChessPiece(Board targetBoard, String code){
        ChessPiece piece=null;
        //Gets the color from the String code
        String color=code.substring(0,1);
        //Gets the type of piece from the String code
        String type=code.substring(1);
        if(type.equals("C"))
            piece=new Castle(type,color,targetBoard);
        else if(type.equals("N"))
            piece=new Knight(type,color,targetBoard);
        else if(type.equals("B"))
            piece=new Bishop(type,color,targetBoard);
        else if(type.equals("Q"))
            piece=new Queen(type,color,targetBoard);
        else if(type.equals("K"))
            piece=new King(type,color,targetBoard);
        else if(type.equals("P"))
            piece=new Pawn(type,color,targetBoard);
        return piece;
    }
}
import java.util.*;

public class Board {
    private int size = 3;

    private String[][] board = new String[3][3];


    public Board() {
        this.createBoard();

    }

    public String[][] getBoard() {
        return board;
    }

    //    public Board(int size) {
//        this.size = size;
//        this.board = new String[size][size];
//        this.createBoard();
//    }

    private void createBoard() {
        for (int i = 0; i < this.size; i++) {

            for (int j = 0; j < this.size; j++) {
                this.board[i][j] = " ";
            }
        }
    }

    public void setBox(int x, int y, String flag) {

        // x: from 1 to size
        // index: from 0 to size - 1
        this.board[x - 1][y - 1] = flag;
    }


    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String result = "\n---";
//        for (String[] row : board ) {
//            for (String element : row ) {
//                result +=  "-------" ;
//            }
//            result += "\n";
//
//            result +=  " |  " ;
//            for (String element : row ) {
//                result += element + "  |  " ;
//            }
//            result += "\n";
//
//        }
        for (int j = 0; j < this.size; j++) {
            result += "--" + (j + 1) + "---";
        }
        result += "\n";

        for (int i = 0; i < board.length; i++) {


            result += i + 1 + " |  ";
            for (int j = 0; j < board[i].length; j++) {
                result += board[i][j] + "  |  ";
            }

            result += "\n---";
            for (int j = 0; j < board[i].length; j++) {
                result += "------";

            }
            result += "\n";

        }

        return result;
    }




}

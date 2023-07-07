public class Helper {
    static public String[][] copyBoard(String[][] board) {
        String[][] result = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }
}

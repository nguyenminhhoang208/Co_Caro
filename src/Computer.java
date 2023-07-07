import java.util.Arrays;
import java.util.Objects;

public class Computer implements PlayCaro {
    private String flag;
    private String name = "Computer";

    public Computer(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }


    @Override
    public void play(String[][] board) {
        int x;
        int y;
        String[][] boardCopy = Arrays.stream(board).map(row -> Arrays.stream(row).map(ele -> Objects.equals(ele, " ") ? this.flag : ele).toArray(String[]::new)).toArray(String[][]::new);

        int flag = 0;
        // row check
        for (String[] row : boardCopy) {
            for (String ele : row) {
                if (Objects.equals(this.flag, ele)) {
                    flag++;
                }
            }
            if (flag == 3) {
                return true;
            }
            flag = 0;
        }

        // column check
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(boardCopy[j][i], this.flag)) {
                    flag++;
                }

            }
            if (flag == 3) {
                return true;
            }
            flag = 0;
        }

        // Main diagonal check

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(boardCopy[i][i], this.flag)) {
                flag++;
            }
        }
        if (flag == 3) {
            return true;
        }
        flag = 0;

        // Secondary diagonal

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(boardCopy[i][3 - i - 1], this.flag)) {
                flag++;
            }
        }
        if (flag == 3) {
            return true;
        }

    }


}

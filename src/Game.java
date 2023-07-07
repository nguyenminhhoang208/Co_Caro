import java.util.*;
import java.util.stream.Stream;


public class Game {
    private Board board;
    private  Menu menu;
    private  ArrayList<Player> players;

    public Game() {

    }

    public void play() {
        this.board = new Board();
        this.menu = new Menu();
        this.players  = new ArrayList<>();
        menu.showMenu();
        handleMenuSelection();

    }

    public void handleMenuSelection() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap lua chon cua ban: ");
        int key = input.nextInt();
        switch (key) {
            case 0:
                System.exit(0);
            case 1:
                System.out.println("Nhap ten nguoi choi 1: ");
                createPlayer("X");
                System.out.println("Nhap ten nguoi choi 2: ");
                createPlayer("O");
                playTogether();
                break;
            case 2:
                System.out.println("Nhap ten nguoi choi: ");
                createPlayer("X");
                createComputer();
                playWithComputer();
                break;
            default:
                System.out.println("Khong hop le!");
                handleMenuSelection();
        }
    }

    public void createPlayer(String flag) {
        Scanner input = new Scanner(System.in);
        String playerName = input.nextLine();
        Player player = new Player(playerName, flag);
        players.add(player);
    }

    public void createComputer() {
        Player player = new Player("Computer", "X");
        players.add(player);
    }


    public void computerPlay() {

    }


    public void playWithComputer() {

        int flag = 1;
        while (flag <= 9 || checkWin(players.get(0))) {

        }

    }

    public void playTogether() {
        int flag = 1;
        System.out.println(this.board.toString());
        while (flag <= 9 && !checkWin(players.get(0)) && !checkWin(players.get(1))) {
            Player player = players.get(0);

            System.out.println("Luot cua " + player.getName() + ": ");
            Scanner input = new Scanner(System.in);
            System.out.println("Nhap toa do x: ");
            int x = input.nextInt();
            System.out.println("Nhap toa do y: ");
            int y = input.nextInt();
            if (x < 1 || x > 3 || y < 1 || y > 3 || !Objects.equals(this.board.getBoard()[x - 1][y - 1], " ")) {
                System.out.println("Khong hop le!");
            } else {
                this.board.setBox(x, y, player.getFlag());
                if (checkWin(player)) {
                    System.out.println("Chuc mung " + player.getName() + " da chien thang!\n");
                    this.play();
                    break;
                }
                if (!checkDraw(player) && !checkDraw(players.get(1))) {
                    System.out.println(this.board.toString());
                    System.out.println("Hoa!\n");
                    this.play();
                    break;
                }
                Collections.reverse(players);
                System.out.println(this.board.toString());
                flag++;
            }
        }
    }

    private boolean checkWin(Player player) {
        int flag = 0;
        // row check
        for (String[] row : this.board.getBoard()) {
            for (String ele : row) {
                if (Objects.equals(player.getFlag(), ele)) {
                    flag++;
                }
            }
            if (flag == 3) {
                return true;
            }
            flag = 0;
        }

        // column check
        for (int i = 0; i < this.board.getSize(); i++) {
            for (int j = 0; j < this.board.getSize(); j++) {
                if (Objects.equals(this.board.getBoard()[j][i], player.getFlag())) {
                    flag++;
                }

            }
            if (flag == 3) {
                return true;
            }
            flag = 0;
        }

        // Main diagonal check

        for (int i = 0; i < this.board.getSize(); i++) {
            if (Objects.equals(this.board.getBoard()[i][i], player.getFlag())) {
                flag++;
            }
        }
        if (flag == 3) {
            return true;
        }
        flag = 0;

        // Secondary diagonal

        for (int i = 0; i < this.board.getSize(); i++) {
            if (Objects.equals(this.board.getBoard()[i][this.board.getSize() - i - 1], player.getFlag())) {
                flag++;
            }
        }
        return flag == 3;
    }

    private boolean checkWin(String[][] board, Player player) {
        int flag = 0;
        // row check
        for (String[] row : board) {
            for (String ele : row) {
                if (Objects.equals(player.getFlag(), ele)) {
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
                if (Objects.equals(board[j][i], player.getFlag())) {
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
            if (Objects.equals(board[i][i], player.getFlag())) {
                flag++;
            }
        }
        if (flag == 3) {
            return true;
        }
        flag = 0;

        // Secondary diagonal

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(board[i][3 - i - 1], player.getFlag())) {
                flag++;
            }
        }
        return flag == 3;
    }

    private boolean checkDraw(Player player) {
        String[][] board =  Arrays.stream(this.board.getBoard()).map(row -> Arrays.stream(row).map(ele -> Objects.equals(ele, " ") ? player.getFlag() : ele).toArray(String[]::new)).toArray(String[][]::new);
        return checkWin(board, player);
    }
}

public class Player implements PlayCaro {
    private  String flag;
    private String name;
    public Player(String name,String flag){
        this.flag = flag;
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }

    @Override
    public void play(String[][] board) {

    }
}

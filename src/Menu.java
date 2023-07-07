import java.util.HashMap;
import java.util.Map;

public class Menu {
    private HashMap<Integer, String> menu = new HashMap<>();

    public Menu() {
        this.menu.put(1, "Choi voi ban");
        this.menu.put(2, "Choi voi may");
        this.menu.put(0, "Thoat");
    }

    public void showMenu() {
        for (Map.Entry<Integer, String> entry : menu.entrySet()
        ) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public HashMap<Integer, String> getMenu() {
        return menu;
    }


}

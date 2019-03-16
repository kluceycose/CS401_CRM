package Menu;

import static Menu.MenuConsole.getChoice;
import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuItem{
    public final String name;
    public MenuStack menus;
    public List<MenuItem> options;
    public Menu(String menuName, MenuStack menuStack){
        name = menuName;
        menus = menuStack;
        options = new ArrayList<>();
    }
    
    public void addOption(MenuItem option){
        options.add(option);
    }
    @Override
    public void execute(){
        options.get(getChoice(options)).execute();
    } 
    @Override
    public String toString() {
        return name;
    }
    
}
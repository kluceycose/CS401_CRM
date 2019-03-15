/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author Jomar Mendoza master branch
 */
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

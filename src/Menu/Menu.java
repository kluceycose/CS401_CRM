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
    //Name of the Menu
    public final String name;
    //Stack of Menus that will contain this Menu
    public MenuStack menus;
    //List of options in this Menu
    public List<MenuItem> options;
    
    //Constructor
    public Menu(String menuName, MenuStack menuStack){
        name = menuName;
        menus = menuStack;
        menus.addMenu(this);
        options = new ArrayList<>();
    }
    //Add option
    public void addOption(MenuItem option){
        options.add(option);
    }
    @Override
    //Execute Chosen Option
    public void execute(){
        options.get(getChoice(options)).execute();
    } 
    @Override
    public String toString() {
        return name;
    }
    
}

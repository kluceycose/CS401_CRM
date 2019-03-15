/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author Jomar
 * Return to Previous Menu
 */
public class ReturnFromMenu implements MenuItem{
     private final String name;
    private final MenuStack menus;
    
    public ReturnFromMenu(String prevMenuName, MenuStack menuStack) {
        name = "Return to " + prevMenuName;
        menus = menuStack;
    }

    @Override
    public void execute() {
        menus.toPreviousMenu();
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}

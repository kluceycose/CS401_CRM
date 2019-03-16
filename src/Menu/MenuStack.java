/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Stack;

/**
 *
 * @author Jomar
 */
public class MenuStack {
    //initialize Stack    
    private final Stack<Menu> menus;
    //Construct empty Stack
    public MenuStack () {
        menus = new Stack<>();
    }
    //Get Top Menu
    public Menu getCurrentMenu(){
        return menus.peek();
    }
    //Push New Menu to Stack
    public void addMenu(Menu menuToAdd){
        menus.push(menuToAdd);
    }
    //Pop Menu to Return to previous Menu
    public void toPreviousMenu(){
        menus.pop();
    }
    //Execute top Menu
    public void run(){
        menus.peek().execute();
    }
}

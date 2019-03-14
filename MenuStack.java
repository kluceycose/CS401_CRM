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
        
    private final Stack<Menu> menus;
    
    public MenuStack () {
        menus = new Stack<>();
    }
    
    public Menu getCurrentMenu(){
        return menus.peek();
    }
    public void addMenu(Menu menuToAdd){
        menus.push(menuToAdd);
    }
    
    public void toPreviousMenu(){
        menus.pop();
    }
    
    public void run(){
        menus.peek().execute();
    }
}

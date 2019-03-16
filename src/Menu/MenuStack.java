
package Menu;

import java.util.Stack;


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


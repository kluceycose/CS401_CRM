/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jomar
 */
public class TestMenu {
    
    MenuStack menus;
    Menu menu1, menu2;
    
    @Before
    public void setUp() {
        menus =  new MenuStack();
        menu1 = new Menu("Test Menu", menus);
        menu2 = new Menu("Test Menu 2", menus);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    //Testing if menu constructors add themselves to the stack
    public void testAdd() {
        assertEquals(menu2, menus.getCurrentMenu());
    }
    @Test
    //Testing if ReturnFromMenu pops menus
    public void testReturn(){
        ReturnFromMenu returnTo = new ReturnFromMenu("Test Menu", menus);
        menu2.addOption(returnTo);
        returnTo.execute();
        assertEquals(menu1, menus.getCurrentMenu());
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jomar
 */
public class MenuConsole {
     public final static Scanner STDIN = new Scanner(System.in);
     
     public static <T> void prompt (List<T> options){
         System.out.println("\nOptions:");
        for (int choice = 0; choice < options.size(); choice++) {
            System.out.println(choice + ". " + options.get(choice));
        }
     }
     public static <T> int getChoice (List<T> options){
         prompt(options);
         System.out.println("Choose an option: (0 - " + (options.size() - 1));
         return STDIN.nextInt();
     }
}

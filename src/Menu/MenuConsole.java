package Menu;

import java.util.List;
import java.util.Scanner;


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
         System.out.println("Choose an option: (0 - " + (options.size() - 1)+")");
         return STDIN.nextInt();
     }
}

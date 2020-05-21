package view;

import java.util.Scanner;

public class ExitView {
    public  static boolean exitSystem(){
        Scanner sc = new Scanner (System.in);
        System.out.println("您确认退出系统吗（y/n）");
        String choice = sc.nextLine();
        if(choice.matches("y|Y")){
            System.exit(0);
        }
        return true;
    }
}

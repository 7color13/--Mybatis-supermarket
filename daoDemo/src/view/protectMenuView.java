package view;

import java.util.Scanner;

public class protectMenuView {
    public static int showProtectMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===****超市商品管理维护====\n" +
                "1、从excel中导入数据\n" +
                "2、从文本文件导入数据\n" +
                "3、键盘输入\n" +
                "4、按商品名称查询\n" +
                "5、返回主菜单\n" +
                "请选择（1-5）");
        int choice = sc.nextInt();
        return choice;
    }
    public static boolean printDefault(){
        System.out.println("无效的选择");
        return false;
    }
}

package view;

import java.util.Scanner;

public class OutMenuView {
    public static int printOutMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===****超市销售信息导出====\n" +
                "1、导出到excel文件\n" +
                "2、导出到文本文件\n" +
                "3、返回主菜单\n" +
                "请选择（1-3）");
        int choose= sc.nextInt();
        return choose;
    }
public static boolean successInsert(int i){
    System.out.println("成功导出" + i + "条销售数据到Excel文件中");
    return true;
}
}

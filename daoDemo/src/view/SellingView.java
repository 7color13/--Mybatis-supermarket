package view;

import java.util.Scanner;

public class SellingView {
    public static String inputFlowNum(){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入商品条形码（6位数字字符）：");
        String barCode = sc.next();
        return barCode;
    }
    public static int inputCount(){
        Scanner sc= new Scanner(System.in);
        System.out.println("输入商品数量：");
        int count=sc.nextInt();
        return count;
    }
    public static boolean outBarCodeNotExist(){
        System.out.println("您输入的商品条形码不存在，请确认后重新输入");
        return false;
    }
    public static boolean verifyBarCodePattern(){
        System.out.println("条形码输入格式不正确，请重新输入");
        return false;
    }
    public static boolean sellingSuccess(){
        System.out.println("收银成功！");
        return true;
    }

}

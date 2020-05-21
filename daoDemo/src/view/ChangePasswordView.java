package view;

import java.util.Scanner;

public class ChangePasswordView {
    public static String inputOldPassword(){
        System.out.println("请输入原密码：");
        Scanner sc = new Scanner(System.in);
        String oldPassword = sc.next();
        return oldPassword;
    }
    public static boolean oldPasswordWrong(){
        System.out.println("原密码输入不正确，请重新输入:");
        return false;
    }
    public static String inputNewPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请再次输入新密码");
        String verifyPass = sc.next();
        return verifyPass;
    }
    public static boolean passwordPatternWrong(){
        System.out.println("您的密码不符合复杂性要求");
        return false;
    }
    public static String inputVerifyPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请再次输入新密码");
        String verifyPassword=sc.next();
        return verifyPassword;
    }
    public static boolean differentPassword(){
        System.out.println("两次输入的密码必须一致，请重新输入密码");
        return false;
    }
    public static boolean changePasswordSuccess(){
        System.out.println("密码修改成功");
        return true;
    }
}

package view;

import util.MD5Util;
import vo.User;

import java.util.Scanner;

public class LoginView {
    public static User show() {
        System.out.println("欢迎使用****超市收银系统，请登录");
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String userName = scan.next();
        System.out.println("请输入密码：");
        String password = scan.next();
        String miwen = MD5Util.md5(password);
        User user = new User(userName, miwen,null,null);
        return user;
    }
    public static boolean loginSuccess(){
        System.out.println("登陆成功");
        return true;
    }
    public static boolean loginFail(){
        System.out.println("最多只能尝试3次，即将退出！");
        return false;
    }
    public static boolean loginTry(){
        System.out.println("用户名或密码不正确");
        return false;
    }
}

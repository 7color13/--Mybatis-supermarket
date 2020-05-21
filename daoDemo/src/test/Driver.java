package test;

import service.MenuService;
import service.UserService;
import view.LoginView;
import vo.User;
/*通过传入view的输入
* return view的输出
* 实现相应的MVC
* */

public class Driver {   //主函数
    public static User user;
    public static int loginCount=0;
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
        user= LoginView.show();
            while (!userService.checkLogin(user)&&loginCount<3) {
                user=LoginView.show();
            }
            if (loginCount!=3){
            MenuService.menuChoose();
            }
    }
}

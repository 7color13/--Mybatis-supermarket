package service;

import view.*;

public class MenuService {   //菜单函数
    public static void menuChoose() throws Exception{
        SaleDetailService saleDetailService = new SaleDetailService();
        UserService userService = new UserService();
        int choose = MenuView.showMenu();
        while(true){
            switch(choose){
                case 1:while(!saleDetailService.selling(SellingView.inputFlowNum()));break;
                case 2:
                    while(!saleDetailService.queryDay(QueryView.inputDay()));break;
                case 3:ProductMenuService.chooseConfig();break;
                case 4:
                    while(!userService.changePassword(ChangePasswordView.inputOldPassword()));break;
                case 5:OutMenuService.outFile();break;
                case 6:ExitView.exitSystem();break;
            }
            choose = MenuView.showMenu();
        }
    }
}

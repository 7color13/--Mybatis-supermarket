package service;

import view.ProtectView;
import view.protectMenuView;

import java.sql.Connection;

public class ProductMenuService {
    public static boolean chooseConfig() throws Exception{   //产品相关的菜单
        int choose = protectMenuView.showProtectMenu();
        ProtectGoodService pgs = new ProtectGoodService();
        if (!UserService.user1.getRole().equals("管理员")){
            choose=5;
        }
        while(choose!=5){
            switch (choose){
                case 1:
                    pgs.inputFromExcel();break;
                case 2:
                    pgs.inputFromTxt();
                    break;
                case 3:
                    while(!pgs.inputFromKeyBoard( ProtectView.inputProductFromKeyboard()));
                    break;
                case 4:pgs.searchByProductName(ProtectView.inputProductName());
                    break;

                default:
                    protectMenuView.printDefault();
            }
            choose = protectMenuView.showProtectMenu();
        }
        return true;
    }

}

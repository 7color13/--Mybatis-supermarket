package view;

import org.w3c.dom.ls.LSOutput;
import service.UserService;
import vo.SaleDetail;

import java.util.List;
import java.util.Scanner;

public class QueryView {
    public static String inputDay(){
        Scanner sc = new Scanner (System.in);
        System.out.println("请输入销售日期（yyyy-mm-dd）:");
        String day=sc.next();
        return day;
    }

    public static boolean printDetail(String day, List<SaleDetail> saleDetailList, int countSum, double priceSum) {
        Scanner sc =new Scanner(System.in);
        System.out.println("日期所有的销售信息，输出显示格式如下：");
        System.out.println(day + "销售如下\n" +
                "流水号\t商品名称\t单价\t数量\t金额\t时间\t收银员\n" +
                "=====\t=======\t=\t====\t===\t\t====\t=====  ======\n");
        for (int i = 0; i < saleDetailList.size(); i++) {
            System.out.println(saleDetailList.get(i).getFlowNum() + "\t" + saleDetailList.get(i).getProductName() + "\t" +
                    saleDetailList.get(i).getPrice() + "\t" + saleDetailList.get(i).getSaletime() + "\t" + UserService.user1.getUserName());
        }
        System.out.println("销售总数：" + saleDetailList.size() + " 商品总件：" + countSum + " 销售总金额：" + priceSum + "\t\n" +
                "日期：" + day + "\n" +
                "请按任意键返回主界面\n");
        sc.nextLine();
        return true;
    }
    public static boolean verifyDateFail(){
        System.out.println("你输入的日期格式不正确，请重新输入");
        return false;
    }

}

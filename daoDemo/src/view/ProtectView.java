package view;

import util.Validate;
import vo.Product;

import java.util.List;
import java.util.Scanner;

public class ProtectView {
    public static String inputProductFromKeyboard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("从键盘依次录入商品信息，格式为“商品条形码，商品名称，单价，供应商”");
        String data = sc.nextLine();
        return data;
    }
    public static String inputProductName(){
        Scanner sc =new Scanner(System.in);
        System.out.println("请输入查询的商品名称：");
        String productName=sc.next();
        return productName;
    }

    public static boolean printProductDetail(List<Product> productList) {
        int flag=1;
        System.out.println("满足条件的记录总共"+productList.size()+"条，信息如下：\n" +
                "序号\t条形码\t商品名称\t单价\t供应商\t\n" +
                "===\t\t=====\t=======\t=\t===\t\t\n");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(flag + "\t" + productList.get(i).getBarCode() +
                    productList.get(i).getProductName() + productList.get(i).getPrice() +
                    productList.get(i).getSupply());
            flag++;
        }
        return true;
    }
    public static boolean countInsert(int index){
        System.out.println("成功导入" + index+ "条数据");
        return true;
    }
    public static boolean productPattern(){
        System.out.println("你输入的数据格式不正确，请重新输入");
        return false;
    }
    public static boolean sameProduct(){
        System.out.println("条形码不能重复，请重新输入");
        return false;
    }
}

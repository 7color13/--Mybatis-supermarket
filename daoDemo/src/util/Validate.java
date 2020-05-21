package util;

import java.util.Scanner;

public class Validate {
  public static boolean verifyPassword(String str){   //验证密码函数

      if (str.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")){
          return true;
      }
      else{
          return false;
      }
  }
  public static boolean verifyBarCode(String barCode){   //验证条形码函数
      Scanner sc= new Scanner(System.in);
      while(barCode.length()!=6){
          return false;
      }
      return true;
  }
 public static boolean verifyDate(String day){   //验证日期函数
      if (day.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")){
          return true;
      }

      return false;
 }
 public static boolean verifyProduct(String arr[]){   //验证输入产品信息函数

     if(arr.length!=4){

          return false;
      }
     return true;
 }
}

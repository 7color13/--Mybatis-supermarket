package service;

import dao.IProductDAO;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.ibatis.session.SqlSession;
import resources.FilePath;
import util.MybatisUtils;
import util.Validate;
import view.ProtectView;
import vo.Product;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ProtectGoodService {
    private SqlSession sqlSession = null;
    private IProductDAO productDAO = null;

    public  boolean inputFromExcel() throws Exception {      //从excel导入

        List<Product> productList = new ArrayList<>();
        this.sqlSession = MybatisUtils.getSqlSession();
        this.productDAO = sqlSession.getMapper(IProductDAO.class);
        Product product = new Product();
        productList = productDAO.doSelect(product);
        int index = productList.size();
        File file = new File(FilePath.dataPath + FilePath.productExcelFile);
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet sheet = workbook.getSheet(0);
        Cell cell = null;
        for (int i = 1; i < sheet.getRows(); i++) {   //依次读取导入
            String str = "";
            for (int j = 0; j < sheet.getColumns(); j++) {
                cell = sheet.getCell(j, i);
                str += cell.getContents() + " ";
            }
            String arr[] = str.split("\\s+");
            Product product2 = new Product(arr[0], arr[1], Float.parseFloat(arr[2]), arr[3]);
            productList.add(product2);
        }
        productList=productList=productList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->
                new TreeSet<>(Comparator.comparing(product1->product1.getBarCode()))),ArrayList::new));
        for (int i=index;i<productList.size();i++){
            productDAO.insertProduct(productList.get(i));
        }
        sqlSession.commit();
        return ProtectView.countInsert(productList.size()-index);
    }

    public  boolean inputFromTxt() throws Exception {    //从文本文件导入

        List<Product> productList = new ArrayList<>();
        this.sqlSession=MybatisUtils.getSqlSession();
        this.productDAO = sqlSession.getMapper(IProductDAO.class);
        Product product = new Product();
        productList = productDAO.doSelect(product);
        int index = productList.size();

        InputStreamReader isr = new InputStreamReader(new FileInputStream(FilePath.dataPath + FilePath.productTxtFile),"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String data = "";
        while ((data = br.readLine()) != null) {
            String str[] = data.split("\\s+");
            Product product1 = new Product(str[0], str[1], Float.parseFloat(str[2]), str[3]);
            productList.add(product1);
        }
        System.out.println(productList.toString());
        productList=productList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->
                new TreeSet<>(Comparator.comparing(product2->product2.getBarCode()))),ArrayList::new));
        for (int i=index;i<productList.size();i++){
            productDAO.insertProduct(productList.get(i));
        }
        sqlSession.commit();
        return ProtectView.countInsert(productList.size()-index);
    }
  public  boolean inputFromKeyBoard(String data) throws Exception{    //从键盘导入
        this.sqlSession=MybatisUtils.getSqlSession();
      this.productDAO = sqlSession.getMapper(IProductDAO.class);
      List<Product> productList = new ArrayList<>();
      Product product = new Product();
      productList = productDAO.doSelect(product);
      int index = productList.size();

      String arr[]=data.split(",");
      if (!Validate.verifyProduct(arr)){
          return ProtectView.productPattern();
      }
      Product product2 = new Product(arr[0], arr[1], Float.parseFloat(arr[2]), arr[3]);
      productList.add(product2);
      productList=productList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->
              new TreeSet<>(Comparator.comparing(product1->product1.getBarCode()))),ArrayList::new));
      if (index==productList.size()){
         return ProtectView.sameProduct();
      }
      for (int i=index;i<productList.size();i++){
          productDAO.insertProduct(productList.get(i));
      }
      sqlSession.commit();
      return ProtectView.countInsert(productList.size()-index);
  }

    public  boolean searchByProductName(String productName) throws Exception{   //根据产品名查询
        List<Product> productList = null;
        this.sqlSession=MybatisUtils.getSqlSession();
        this.productDAO = sqlSession.getMapper(IProductDAO.class);
        Product product = new Product();
        product.setProductName(productName);
        productList=productDAO.doSelect(product);
        return ProtectView.printProductDetail(productList);
    }
}

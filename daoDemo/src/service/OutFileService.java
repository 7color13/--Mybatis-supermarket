package service;

import dao.ISaleDetailDAO;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.ibatis.session.SqlSession;
import resources.FilePath;
import util.ExcelStyle;
import util.GetDate;
import util.MybatisUtils;
import view.OutMenuView;
import vo.SaleDetail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class OutFileService {   //文件输出类
     private SqlSession sqlSession =null;
     private ISaleDetailDAO saleDetailDAO =null;
 public  boolean outputToExcel() throws Exception{   //输出至Excel
     List<SaleDetail> saleDetailList = new ArrayList<>();
     this.sqlSession= MybatisUtils.getSqlSession();
     this.saleDetailDAO=sqlSession.getMapper(ISaleDetailDAO.class);
     SaleDetail saleDetail = new SaleDetail();
     saleDetailList = saleDetailDAO.doSelect(saleDetail);
     WritableWorkbook wwb = Workbook.createWorkbook(new File(FilePath.dataPath+
             FilePath.fileBefore+ GetDate.getToday()+FilePath.excelFile));  //获取路径
     WritableSheet sheet = wwb.createSheet("销售明细表",0);
     String[] titles  = {"流水号","条形码","商品名","单价","数量","操纵人员","销售时间"};
     Label label = null;
     for (int i=0;i<titles.length;i++){
         WritableCellFormat wcf = ExcelStyle.setTitleStyle();
         label = new Label(i,0,titles[i],wcf);
         sheet.addCell(label);
     }
     WritableCellFormat wcf = ExcelStyle.setNormalStyle();
     int i;
     for(i=0;i<saleDetailList.size();i++){
         label = new Label(0, i, saleDetailList.get(i).getFlowNum(),wcf);
         sheet.addCell(label);
         label = new Label(1, i, saleDetailList.get(i).getBarCode(),wcf);
         sheet.addCell(label);
         label = new Label(2, i, saleDetailList.get(i).getProductName(),wcf);
         sheet.addCell(label);
         label = new Label(3, i, String.valueOf(saleDetailList.get(i).getPrice()),wcf);
         sheet.addCell(label);
         label = new Label(4, i, String.valueOf(saleDetailList.get(i).getCount()),wcf);
         sheet.addCell(label);
         label = new Label(5, i, saleDetailList.get(i).getOperator(),wcf);
         sheet.addCell(label);
         label = new Label(6, i, saleDetailList.get(i).getSaletime(),wcf);
         sheet.addCell(label);
     }
     wwb.write();
     wwb.close();
     return OutMenuView.successInsert(i);
 }

    public  boolean outputToTxt() throws Exception {   //输出至TXT
        List<SaleDetail> saleDetailList = new ArrayList<>();
        this.sqlSession= MybatisUtils.getSqlSession();
        this.saleDetailDAO=sqlSession.getMapper(ISaleDetailDAO.class);
        SaleDetail saleDetail  =new SaleDetail();
        saleDetailList = saleDetailDAO.doSelect(saleDetail);
        File file = new File(FilePath.dataPath + FilePath.fileBefore + GetDate.getToday() + FilePath.txtFile);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "\t玩具熊超市销售数据\t\n";
        for (SaleDetail sa :
                saleDetailList) {
            str+=sa.toString();
        }
        bw.write(str);
        bw.close();
        fw.close();
        return OutMenuView.successInsert(saleDetailList.size());
    }
}

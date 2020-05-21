package service;

import dao.IProductDAO;
import dao.ISaleDetailDAO;

import org.apache.ibatis.session.SqlSession;
import util.GetDate;
import util.MybatisUtils;
import util.Validate;
import view.QueryView;
import view.SellingView;
import vo.Product;
import vo.SaleDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaleDetailService {
    private ISaleDetailDAO saleDetailDAO=null;
    private IProductDAO productDAO = null;
    private SqlSession sqlSession = null;

    public boolean selling(String barCode) throws Exception {    //收银函数
        this.sqlSession = MybatisUtils.getSqlSession();
        this.productDAO = sqlSession.getMapper(IProductDAO.class);
        this.saleDetailDAO= sqlSession.getMapper(ISaleDetailDAO.class);
        SaleDetail saleDetail;
        List<SaleDetail> saleDetailList = new ArrayList<>();
        if(!Validate.verifyBarCode(barCode)){
            return SellingView.verifyBarCodePattern();
        }
        Product product = new Product();
        product.setBarCode(barCode);
        while (productDAO.doSelect(product).size() == 0) {
            return SellingView.outBarCodeNotExist();
        }
        int count = SellingView.inputCount();
        String todayStr = GetDate.getToday();
        String todayAnotherStr = GetDate.getAnotherToday();
        SaleDetail saleDetail1 = new SaleDetail();
        saleDetail1.setSaletime(todayAnotherStr);
        saleDetailList = saleDetailDAO.doSelect(saleDetail1);
        int flag = saleDetailList.size();
        String flowNum = todayStr + GetDate.getAfterNum(flag);
        float price = productDAO.doSelect(product).get(0).getPrice();
        String productName = productDAO.doSelect(product).get(0).getProductName();
        String operator = UserService.user1.getUserName();
        String saletime = GetDate.getTime();
        saleDetail = new SaleDetail(flowNum, barCode, productName, price, count, operator, saletime);
        saleDetailDAO.doInsert(saleDetail);
        sqlSession.commit();
        return SellingView.sellingSuccess();
    }

    public boolean queryDay(String day) throws Exception {    //根据日期查询
        if (!Validate.verifyDate(day)) {
           return QueryView.verifyDateFail();
        }
        this.sqlSession=MybatisUtils.getSqlSession();
        this.saleDetailDAO = sqlSession.getMapper(ISaleDetailDAO.class);
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSaletime(day);
        List<SaleDetail> saleDetailList = saleDetailDAO.doSelect(saleDetail);
        day = GetDate.replaceTime(day);
        int countSum = saleDetailList.stream().collect(Collectors.summingInt(SaleDetail::getCount));
        double priceSum = saleDetailList.stream().mapToDouble(SaleDetail::getPrice).sum();
        return QueryView.printDetail(day, saleDetailList, countSum, priceSum);
    }
}

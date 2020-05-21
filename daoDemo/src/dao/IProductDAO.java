package dao;

import vo.Product;

import java.util.List;

public interface IProductDAO {   //产品接口
    public boolean insertProduct(Product product) throws Exception;
    public List<Product> doSelect(Product product) throws Exception;
    public int doUpdate(Product product) throws Exception;
    public boolean doDelete(Product product) throws Exception;
}

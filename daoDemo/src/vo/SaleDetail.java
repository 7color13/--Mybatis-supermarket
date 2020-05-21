package vo;

public class SaleDetail {
    private String flowNum;
    private String barCode;
    private String productName;
    private float price;
    private int count;
    private String operator;
    private String saletime;

    public SaleDetail() {
        this.flowNum=null;
        this.barCode=null;
        this.productName=null;
        this.price=-1;
        this.count=-1;
        this.operator=null;
        this.saletime=null;
    }

    public SaleDetail(String flowNum, String barCode, String productName, float price, int count, String operator, String saletime) {
        this.flowNum = flowNum;
        this.barCode = barCode;
        this.productName = productName;
        this.price = price;
        this.count = count;
        this.operator = operator;
        this.saletime = saletime;
    }

    @Override
    public String toString() {
        return flowNum+" "+barCode+" "+productName+" "+
                price+" "+count+" "+operator+" "+saletime+"\n";
    }

    public String getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSaletime() {
        return saletime;
    }

    public void setSaletime(String saletime) {
        this.saletime = saletime;
    }
}

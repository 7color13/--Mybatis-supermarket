package vo;

public class Product {
    private String barCode;
    private String productName;
    private float price;
    private String supply;

    public Product(String barCode, String productName, float price, String supply) {
        this.barCode = barCode;
        this.productName = productName;
        this.price = price;
        this.supply = supply;
    }

    public Product() {
        this.barCode=null;
        this.productName=null;
        this.price=-1;
        this.supply=null;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barCode='" + barCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", supply='" + supply + '\'' +
                '}';
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

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }
}

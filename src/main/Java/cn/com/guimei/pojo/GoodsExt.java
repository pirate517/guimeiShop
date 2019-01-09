package cn.com.guimei.pojo;

/**
 * Created by 张鹏 on 2019/1/7
 */
public class GoodsExt  extends Goods{

    private SmallClass smallClass;
    private Discount discount;
    private Seller seller;

    public SmallClass getSmallClass() {
        return smallClass;
    }

    public void setSmallClass(SmallClass smallClass) {
        this.smallClass = smallClass;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }
}

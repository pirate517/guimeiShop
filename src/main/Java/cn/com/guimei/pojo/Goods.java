package cn.com.guimei.pojo;


public class Goods {

  private Long id;
  private String goodsName;
  private Long goodsSmalId;
  private double goodsMoney;
  private Long goodsNumber;
  private String goodsImage;
  private double goodsCarriage;
  private Long goodsType;
  private Long goodsDiscId;
  private Long goodsSellerId;

  public Long getGoodsSellerId() {
    return goodsSellerId;
  }

  public void setGoodsSellerId(Long goodsSellerId) {
    this.goodsSellerId = goodsSellerId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public Long getGoodsSmalId() {
    return goodsSmalId;
  }

  public void setGoodsSmalId(Long goodsSmalId) {
    this.goodsSmalId = goodsSmalId;
  }


  public double getGoodsMoney() {
    return goodsMoney;
  }

  public void setGoodsMoney(double goodsMoney) {
    this.goodsMoney = goodsMoney;
  }


  public Long getGoodsNumber() {
    return goodsNumber;
  }

  public void setGoodsNumber(Long goodsNumber) {
    this.goodsNumber = goodsNumber;
  }


  public String getGoodsImage() {
    return goodsImage;
  }

  public void setGoodsImage(String goodsImage) {
    this.goodsImage = goodsImage;
  }


  public double getGoodsCarriage() {
    return goodsCarriage;
  }

  public void setGoodsCarriage(double goodsCarriage) {
    this.goodsCarriage = goodsCarriage;
  }


  public Long getGoodsType() {
    return goodsType;
  }

  public void setGoodsType(Long goodsType) {
    this.goodsType = goodsType;
  }


  public Long getGoodsDiscId() {
    return goodsDiscId;
  }

  public void setGoodsDiscId(Long goodsDiscId) {
    this.goodsDiscId = goodsDiscId;
  }

}

package cn.com.guimei.pojo;


public class BigClass {

  private Long id;
  private String bigName;
  private String bigText;

  public BigClass() {
  }

  public BigClass(Long id, String bigName, String bigText) {
    this.id = id;
    this.bigName = bigName;
    this.bigText = bigText;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getBigName() {
    return bigName;
  }

  public void setBigName(String bigName) {
    this.bigName = bigName;
  }


  public String getBigText() {
    return bigText;
  }

  public void setBigText(String bigText) {
    this.bigText = bigText;
  }

}

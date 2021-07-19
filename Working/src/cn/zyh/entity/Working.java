package cn.zyh.entity;


public class Working {

  private int id;
  private String title;
  private String content;
  private String creataDate;
  private int type;

  public Working(){

  }
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getCreataDate() {
    return creataDate;
  }

  public void setCreataDate(String creataDate) {
    this.creataDate = creataDate.substring(0,10);
  }


  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

}

package cn.menglangpoem.mobile.pojo;

public class HotSearch {
    private int id;
    private String content;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public HotSearch() {
    }

    public HotSearch(int id, String content, int num) {
        this.id = id;
        this.content = content;
        this.num = num;
    }
}

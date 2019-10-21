package cn.menglangpoem.mobile.pojo;

public class HotAuthor {
    private int id;
    private String name;
    private int num;

    @Override
    public String toString() {
        return "HotAuthor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public HotAuthor() {
    }

    public HotAuthor(int id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }
}

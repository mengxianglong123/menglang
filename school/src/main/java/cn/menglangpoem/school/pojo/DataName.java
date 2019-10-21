package cn.menglangpoem.school.pojo;

public class DataName {
    private int id;
    private String num;
    private String name;

    @Override
    public String toString() {
        return "DataName{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public DataName() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataName(int id, String num, String name) {
        this.id = id;
        this.num = num;
        this.name = name;
    }
}

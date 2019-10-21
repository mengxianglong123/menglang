package cn.menglangpoem.school.pojo;

public class School {
    private int id;
    private int num;
    private String name;

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School() {
    }

    public School(int id, int num, String name) {
        this.id = id;
        this.num = num;
        this.name = name;
    }
}

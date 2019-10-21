package cn.menglangpoem.school.pojo;

import java.util.Objects;

public class DataType {
    private String name;
    private int num;

    @Override
    public String toString() {
        return "DataType{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
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

    public DataType() {
    }

    public DataType(String name, int num) {
        this.name = name;
        this.num = num;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }
}

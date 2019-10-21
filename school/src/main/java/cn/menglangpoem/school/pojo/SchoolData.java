package cn.menglangpoem.school.pojo;

import java.util.List;

public class SchoolData {
    private String name;
    private List<String> datas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDatas() {
        return datas;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
    }

    public SchoolData() {
    }

    public SchoolData(String name, List<String> datas) {
        this.name = name;
        this.datas = datas;
    }
}

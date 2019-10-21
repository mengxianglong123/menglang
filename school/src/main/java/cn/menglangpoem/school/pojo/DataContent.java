package cn.menglangpoem.school.pojo;

public class DataContent {
    private int id;
    private int schoolNum;
    private String dataNum;
    private String data;

    @Override
    public String toString() {
        return "DataContent{" +
                "id=" + id +
                ", schoolNum=" + schoolNum +
                ", dataNum='" + dataNum + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolNum() {
        return schoolNum;
    }

    public void setSchoolNum(int schoolNum) {
        this.schoolNum = schoolNum;
    }

    public String getDataNum() {
        return dataNum;
    }

    public void setDataNum(String dataNum) {
        this.dataNum = dataNum;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataContent() {
    }

    public DataContent(int id, int schoolNum, String dataNum, String data) {
        this.id = id;
        this.schoolNum = schoolNum;
        this.dataNum = dataNum;
        this.data = data;
    }
}

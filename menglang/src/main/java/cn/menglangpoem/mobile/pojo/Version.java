package cn.menglangpoem.mobile.pojo;

public class Version {
    private int id;
    private String time;
    private String name;
    private String num;
    private String content;

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Version() {
    }

    public Version(int id, String time, String name, String num, String content) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.num = num;
        this.content = content;
    }
}

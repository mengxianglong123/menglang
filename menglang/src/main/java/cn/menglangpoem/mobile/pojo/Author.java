package cn.menglangpoem.mobile.pojo;

public class Author {
    private int id;
    private String name;
    private String time;
    private String label;
    private String tag;
    private String introduction;
    private int total;
    private String img;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", label='" + label + '\'' +
                ", tag='" + tag + '\'' +
                ", introduction='" + introduction + '\'' +
                ", total=" + total +
                ", img='" + img + '\'' +
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Author() {
    }

    public Author(int id, String name, String time, String label, String tag, String introduction, int total, String img) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.label = label;
        this.tag = tag;
        this.introduction = introduction;
        this.total = total;
        this.img = img;
    }
}

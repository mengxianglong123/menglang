package cn.menglangpoem.mobile.pojo;

public class FindBack {
    private int id;
    private String color;
    private String name;
    private String content;
    private String title;

    @Override
    public String toString() {
        return "FindBack{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FindBack() {
    }

    public FindBack(int id, String color, String name, String content, String title) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.content = content;
        this.title = title;
    }
}

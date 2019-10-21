package cn.menglangpoem.mobile.pojo;

public class CreateBook {
    private int id;
    private String name;
    private String author;
    private String intro;

    public CreateBook() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public CreateBook(int id, String name, String author, String intro) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.intro = intro;
    }
}

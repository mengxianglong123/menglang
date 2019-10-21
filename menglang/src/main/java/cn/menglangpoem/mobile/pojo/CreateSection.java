package cn.menglangpoem.mobile.pojo;

public class CreateSection {
    private int id;
    private String name;
    private String content;
    private int bookId;

    @Override
    public String toString() {
        return "CreateSection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", bookId=" + bookId +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public CreateSection() {
    }

    public CreateSection(int id, String name, String content, int bookId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.bookId = bookId;
    }
}

package cn.menglangpoem.mobile.pojo;

public class Poem {
    private int id;
    private String title;
    private String author;
    private String time;
    private String content;
    private String comment;
    private String tag;
    private String excerpt;

    @Override
    public String toString() {
        return "Poem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", comment='" + comment + '\'' +
                ", tag='" + tag + '\'' +
                ", excerpt='" + excerpt + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public Poem() {
    }

    public Poem(int id, String title, String author, String time, String content, String comment, String tag, String excerpt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.time = time;
        this.content = content;
        this.comment = comment;
        this.tag = tag;
        this.excerpt = excerpt;
    }
}

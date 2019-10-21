package cn.menglangpoem.mobile.pojo;

public class Phrase {
    private int id;
    private String content;
    private int poemId;
    private String poemTitle;
    private String poemAuthor;
    private String time;
    private int authorId;
    private String authorImg;

    @Override
    public String toString() {
        return "Phrase{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", poemId=" + poemId +
                ", poemTitle='" + poemTitle + '\'' +
                ", poemAuthor='" + poemAuthor + '\'' +
                ", time='" + time + '\'' +
                ", authorId=" + authorId +
                ", authorImg='" + authorImg + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPoemId() {
        return poemId;
    }

    public void setPoemId(int poemId) {
        this.poemId = poemId;
    }

    public String getPoemTitle() {
        return poemTitle;
    }

    public void setPoemTitle(String poemTitle) {
        this.poemTitle = poemTitle;
    }

    public String getPoemAuthor() {
        return poemAuthor;
    }

    public void setPoemAuthor(String poemAuthor) {
        this.poemAuthor = poemAuthor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    public Phrase() {
    }

    public Phrase(int id, String content, int poemId, String poemTitle, String poemAuthor, String time, int authorId, String authorImg) {
        this.id = id;
        this.content = content;
        this.poemId = poemId;
        this.poemTitle = poemTitle;
        this.poemAuthor = poemAuthor;
        this.time = time;
        this.authorId = authorId;
        this.authorImg = authorImg;
    }
}

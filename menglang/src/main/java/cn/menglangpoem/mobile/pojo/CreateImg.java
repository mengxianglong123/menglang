package cn.menglangpoem.mobile.pojo;

public class CreateImg {
    private int id;
    private String name;
    private String color;
    private int fontsize;
    private int space;
    private int controlNum;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private String type;
    private int dir;

    @Override
    public String toString() {
        return "CreateImg{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", fontsize=" + fontsize +
                ", space=" + space +
                ", controlNum=" + controlNum +
                ", startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                ", type='" + type + '\'' +
                ", dir=" + dir +
                '}';
    }

    public CreateImg() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFontsize() {
        return fontsize;
    }

    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getControlNum() {
        return controlNum;
    }

    public void setControlNum(int controlNum) {
        this.controlNum = controlNum;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public CreateImg(int id, String name, String color, int fontsize, int space, int controlNum, int startX, int startY, int endX, int endY, String type, int dir) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.fontsize = fontsize;
        this.space = space;
        this.controlNum = controlNum;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.type = type;
        this.dir = dir;
    }
}

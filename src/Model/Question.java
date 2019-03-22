package Model;

public class Question {
    private Integer id;
    private String text;
    private Integer postion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostion() {
        return postion;
    }

    public String getText() {
        return text;
    }

    public void setPostion(Integer postion) {
        this.postion = postion;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package Model;

import java.io.Serializable;

public class Answer implements Serializable {
    private Integer id;
    private String text;
    private Integer position;
    private Boolean correction;
    private Constant.STATUS status;
    private Integer question;

    public Answer(){

    }
    public Answer(String text,Integer position,Boolean correction,Integer question){
        this.text=text;
        this.position=position;
        this.correction=correction;
        this.question=question;
    }
    public Answer(Integer id,String text,Integer position,Boolean correction,Constant.STATUS status,Integer question){
        this.id=id;
        this.text=text;
        this.position=position;
        this.correction=correction;
        this.status=status;
        this.question=question;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public Integer getQuestion() {

        return question;
    }

    public String getText() {
        return text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Constant.STATUS getStatus() {
        return status;
    }

    public void setStatus(Constant.STATUS status) {
        this.status = status;
    }

    public Boolean getCorrection() {
        return correction;
    }

    public Integer getPosition() {
        return position;
    }

    public void setCorrection(Boolean correction) {
        this.correction = correction;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}

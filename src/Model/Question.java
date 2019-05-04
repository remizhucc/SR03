package Model;

import java.io.Serializable;

public class Question implements Serializable {
    private Integer id;
    private String text;
    private Integer position;
    private Constant.STATUS status;
    private Integer questionnaire;


    public Question() {

    }
    public Question(String text) {
        this.text = text;
    }

    public Question(Integer id, String text, Integer position, Constant.STATUS status,Integer questionnaire) {
        this.id = id;
        this.text = text;
        this.position = position;
        this.status=status;
        this.questionnaire = questionnaire;
    }

    public Integer getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Integer questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(Constant.STATUS status) {
        this.status = status;
    }

    public Constant.STATUS getStatus() {

        return status;
    }
}

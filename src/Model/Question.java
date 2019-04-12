package Model;

public class Question {
    private Integer id;
    private String text;
    private Integer postion;
    private Integer questionnaire;

    public Question(String text) {
        this.text = text;
    }

    public Question(Integer id, String text, Integer postion, Integer questionnaire) {
        this.id = id;
        this.text = text;
        this.postion = postion;
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

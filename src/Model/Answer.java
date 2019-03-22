package Model;

public class Answer {
    private Integer id;
    private String text;
    private Integer position;
    private Boolean correction;
    private Constant.STATUS status;

    public void setText(String text) {
        this.text = text;
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

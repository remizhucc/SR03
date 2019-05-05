package Model;

import java.io.Serializable;

import static Model.Constant.STATUS.ACTIVE;

public class Questionnaire implements Serializable {
    private Integer id;
    private String subject;
    private Constant.STATUS status;

    public Questionnaire() {

    }

    public Questionnaire(String subject) {
    	this.subject = subject;
    }


    public Questionnaire(int id, String subject, Constant.STATUS status) {
        this.subject = subject;
        this.id = id;
        this.status = status;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setStatus(Constant.STATUS status) {
        this.status = status;
    }

    public Constant.STATUS getStatus() {
        return status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

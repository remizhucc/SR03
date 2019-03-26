package Model;

import static Model.Constant.STATUS.ACTIVE;

public class Questionnaire {
    private Integer id;
    private String subject;
    private Constant.STATUS status;

    /*public void Questionnaire() {
    	this.id = null;
    	this.subject = null;
    	status = ACTIVE;
    }*/
    
    public Questionnaire(String subject) {
    	this.subject = subject;
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

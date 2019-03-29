package Model;

public class Questionnaire {
    private Integer id;
    private String subject;
    private Constant.STATUS status;

    public void Questionnaire() {
    	this.id = null;
    	this.subject = null;
    	status = ACTIVE;
    }
    
    public void Questionnaire(Integer id, String subject, Constant.STATUS status) {
    	this.subject = subject;
    	status = status;
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

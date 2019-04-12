package Model;

import java.util.Date;

public class Result {
    private Integer id;
    private Integer score;
    private Date dateCreation;
    private String trainee;

    public Result(Integer id, Integer score, Date dateCreation, String trainee){
        this.id = id;
        this.score = score;
        this.dateCreation = dateCreation;
        this.trainee = trainee;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTrainee(){ return trainee; }

    public void setTrainee(String trainee){this.trainee = trainee;}
}

package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Result implements Serializable {
    private Integer id;
    private Integer score;
    private Date dateCreation;
    private Integer trainee;
    private String json;

    public Result(){

    }

    //when create
    public Result(Integer score, Integer trainee, String json){
        this.score = score;
        this.trainee = trainee;
        this.json=json;
    }
    //when query
    public Result(Integer id,Integer score, Date dateCreation, Integer trainee, String json){
        this.id = id;
        this.score = score;
        this.dateCreation = dateCreation;
        this.trainee = trainee;
        this.json=json;
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

    public Integer getTrainee(){ return trainee; }

    public void setTrainee(Integer trainee){this.trainee = trainee;}

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}

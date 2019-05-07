package Model;

public class DAOFactory {
    public static DAOUser  getDAOUser(){
        return new DAOUser();
    }
    public static DAOAnswer  getDAOAnswer(){
        return new DAOAnswer();
    }
    public static DAOQuestion  getDAOQuestion(){
        return new DAOQuestion();
    }
    public static DAOQuestionnaire  getDAOQuestionnaire(){
        return new DAOQuestionnaire();
    }
    public static DAOResult  getDAOResult(){
        return new DAOResult();
    }
}

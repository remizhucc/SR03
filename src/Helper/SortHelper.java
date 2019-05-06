package Helper;

import Model.Answer;
import Model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortHelper {
    public static ArrayList<Question> sortQuestion(ArrayList<Question> questions){
        Comparator<Question> comp = (Question a, Question b) -> {
            return a.getPosition()>b.getPosition()?1:-1;
        };
        Collections.sort(questions, comp);
        return questions;
    }
    public static ArrayList<Answer> sortAnswers(ArrayList<Answer> answers){
        Comparator<Answer> comp = (Answer a, Answer b) -> {
            return a.getPosition()>b.getPosition()?1:-1;
        };
        Collections.sort(answers, comp);
        return answers;
    }
}

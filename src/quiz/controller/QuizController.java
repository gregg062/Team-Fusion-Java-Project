package quiz.controller;

import quiz.model.Question;
import quiz.model.util.db.DBConnector;

public class QuizController {
	public static Question getQuestion(int user_id){
		Question question = DBConnector.getRandomQuestion(user_id);
		return question;
	}
	
	public static int getQuestionNumber(int user_id){
		int number = DBConnector.getQuestionNumber(user_id);
		return number;
	}
	
	public static boolean saveAnswer(int user_id, String question_id, String answer)
    {
		boolean registered = DBConnector.saveAnswer(user_id, question_id, answer);
		return registered;
    }
	
	public static int getQuizScore(int user_id){
		int number = DBConnector.getQuizScore(user_id);
		return number;
	}
	
	public static boolean deleteQuestion(String question_id)
    {
		boolean deleted = DBConnector.deleteQuestion(question_id);
		return deleted;
    }
	
	public static boolean addQuestion(String subject, String prompt, String answer_one, String answer_two, String answer_three, String answer_four, String correct)
    {
		boolean added = DBConnector.addQuestionDB(subject, prompt, answer_one, answer_two, answer_three, answer_four, correct);
		return added;
    }
	
	public static boolean deleteUser(String user_id)
    {
		boolean deleted = DBConnector.deleteUserDB(user_id);
		return deleted;
    }
}

package quiz.model;

public class Question {
	
	private int _question_id;
	private String _subject;
	private String _prompt;
	private String _answer_one;
	private String _answer_two;
	private String _answer_three;
	private String _answer_four;
	private String _correct;
	
	
	public Question() {}
	
	public Question(int question_id, String subject, String prompt, String answer_one, String answer_two, String answer_three, String answer_four, String correct){
		_question_id = question_id;
		_subject = subject;
		_prompt = prompt;
		_answer_one = answer_one;
		_answer_two = answer_two;
		_answer_three = answer_three;
		_answer_four = answer_four;
		_correct = correct;
	}
	
	public int getQuestionID(){
		return _question_id;
	}
	public void setQuestionID(int question_id){
		_question_id = question_id;
	}
	
	public String getSubject(){
		return _subject;
	}
	public void setSubject(String subject){
		_subject = subject;
	}
	
	public String getPrompt(){
		return _prompt;
	}
	public void setPrompt(String prompt){
		_prompt = prompt;
	}
	
	public String getAnswerOne(){
		return _answer_one;
	}
	public void setAnswerOne(String answer_one){
		_answer_one = answer_one;
	}
	
	public String getAnswerTwo(){
		return _answer_two;
	}
	public void setAnswerTwo(String answer_two){
		_answer_two = answer_two;
	}
	
	public String getAnswerThree(){
		return _answer_three;
	}
	public void setAnswerThree(String answer_three){
		_answer_three = answer_three;
	}
	
	public String getAnswerFour(){
		return _answer_four;
	}
	public void setAnswerFour(String answer_four){
		_answer_four = answer_four;
	}
	
	public String getCorrect(){
		return _correct;
	}
	public void setCorrect(String correct){
		_correct = correct;
	}
}

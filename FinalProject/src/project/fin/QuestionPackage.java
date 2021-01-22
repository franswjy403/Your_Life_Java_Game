package project.fin;

public class QuestionPackage {
	private String Question;
	private boolean already;
	private answer A;
	private answer B;
	public boolean running;
	
	public QuestionPackage(String Question, String answerA, String answerB, int A1, int indexA1, 
			int A2, int indexA2, int A3, int indexA3, int B1, int indexB1, int B2, int indexB2, int B3, int indexB3){
		this.setQuestion(Question);
		this.setA(new answer(A1, A2, A3, indexA1, indexA2, indexA3, answerA));
		this.setB(new answer(B1, B2, B3, indexB1, indexB2, indexB3, answerB));
		this.already = false;
		this.running = true;
	}
	
	public class AnswerPoint{
		int point;
		int index;
		
		public AnswerPoint(int Point, int Index) {
			this.point=Point;
			this.index=Index;
		}
		public int getIndex() {
			return index;
		}
		public int getPoint() {
			return point;
		}
	}
	
	public class answer {
		private AnswerPoint pointA;
		private AnswerPoint pointB;
		private AnswerPoint pointC;
		private String Answer;
		public answer(int A, int B, int C, int indexA, int indexB, int indexC, String Answer) {
			// TODO Auto-generated constructor stub
			this.setPointA(new AnswerPoint(A, indexA));
			this.setPointB(new AnswerPoint(B, indexB));
			this.setPointC(new AnswerPoint(C, indexC));
			this.setAnswer(Answer);
		}
		public AnswerPoint getPointA() {
			return pointA;
		}
		public void setPointA(AnswerPoint pointA) {
			this.pointA = pointA;
		}
		public AnswerPoint getPointB() {
			return pointB;
		}
		public void setPointB(AnswerPoint pointB) {
			this.pointB = pointB;
		}
		public AnswerPoint getPointC() {
			return pointC;
		}
		public void setPointC(AnswerPoint pointC) {
			this.pointC = pointC;
		}
		public String getAnswer() {
			return Answer;
		}
		public void setAnswer(String answer) {
			Answer = answer;
		}
	}
	public boolean getAlready() {
		return already;
	}
	public void setAlready(boolean already) {
		this.already = already;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public answer getA() {
		return A;
	}
	public void setA(answer a) {
		A = a;
	}
	public answer getB() {
		return B;
	}
	public void setB(answer b) {
		B = b;
	}
	
}



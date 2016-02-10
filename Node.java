package RegisterInfo;

public class Node {
	private String depth;			//학년
	private String classification;	//교과구분
	private String name;			//과목이름
	private String grade;			//학점
	private String time;			//시간
	private String previous;		//선수과목의 이름
									//이 변수 만든 이유는 이름이랑 선수과목 이름이랑 비교해보기 위함 
	private Node prev;				//선수과목 node
	
	
	//constructor
	public Node(){
		depth = null;
		classification = null;
		name = null;
		grade = null;
		time = null;
		previous = null;
			
	}
	
	public Node(String depth, String classification, String name, String grade, String time, String previous){

		this.depth = depth;
		this.classification = classification;
		this.name = name;
		this.grade = grade;
		this.time = time;
		this.previous = previous;
	}
	
	
	//setter
	public void setDepth(String depth){
		this.depth = depth;
	}
	
	public void setClassification(String classification){
		this.classification = classification;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setGrade(String grade){
		this.grade = grade;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	public void setPrevious(String previous){
		this.previous = previous; 
	}
	
	public void setPrev(Node Prev){
		this.prev = prev;
	}
	
	
	//getter
	public String getDepth(){
		return depth;
	}
	
	public String getClassification(){
		return classification;
	}
	
	public String getName(){
		return name;
	}
	
	public String getGrade(){
		return grade;
	}
	
	public String getTime(){
		return time;
	}
	
	public String getPrevious(){
		return previous;
	}
	
	public Node getPrev(){
		return prev;
	}
	
}

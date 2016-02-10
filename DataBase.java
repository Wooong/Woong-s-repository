package RegisterInfo;

import java.util.ArrayList;

public class DataBase {
	
	private ArrayList<Node> subject= new ArrayList<Node>();
	
	public void addNode(Node node){
		subject.add(node);
	}
	
	public int NumberOfNode(){
		return subject.size();
	}

//getter
	//i번째 노드 반환
	public Node getNode(int i){
		return subject.get(i);
	}
	
	
	//i번째 노드의 인자 반환
	public String getName(int i){
		return subject.get(i).getName();
	}
	
	public String getDepth(int i){
		return subject.get(i).getDepth();
	}
	
	public String getClassification(int i){
		return subject.get(i).getClassification();
	}
	
	public String getGrade(int i){
		return subject.get(i).getGrade();
	}
	
	public String getTime(int i){
		return subject.get(i).getTime();
	}
	
	public String getPrevious(int i){
		return subject.get(i).getPrevious();
	}
	
	//선수과목 node 반환
	public Node getPrev(int i){
		return subject.get(i).getPrev();
	}
	
//setter
	//i번째 노드의 prevnode를 prev로 설정
	public void setPrev(int i, Node prev){
		subject.get(i).setPrev(prev);
	}
	//나머지 setter들은 많은 필요 없다고 판단
	//필요하다고 생각된다면 알아서 만들기
	
	
	
	
}

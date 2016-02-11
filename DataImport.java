package RegisterInfo;



import java.io.*;


public class DataImport {
	

	private final int SUBJECT_NUMBER = 66; // 과목의 갯수
	
	private DataBase db = new DataBase();

	
	String num[] = new String[66];
	String div[] = new String[66];
	String sub[] = new String[66];
	String time[] = new String[66];
	String grade[] = new String[66];
	String pre[] = new String[66];
	String arr[] = new String[397];
	
	// constructor
	public DataImport() {

		String fileName = "subject.txt";
		int i = 0;
		try {//파일열기      
         BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"euc-kr"));
         while(true) {
             String line = br.readLine();
             if (line==null) break;
             String[] result = line.split("\t");
             num[i] = result[0];
             div[i] = result[1];
             sub[i] = result[2];
             time[i] = result[3];
             grade[i] = result[4];
             pre[i] = result[5];
             i++;
             
             System.out.println(result[0] + "\t" + result[1] + "\t" + result[2] + " \t" + result[3] + "/" + result[4] + "\t" + result[5]);
         }
         br.close();
         } catch (IOException e) { 
         e.printStackTrace(); 
      }
		Node head = new Node();
		head.setName("소셜미디어전공");

		// 위에 읽어진 정보로 node객체를 만들고 그 객체를 DataBase로 보냄
		for (i = 0; i < SUBJECT_NUMBER; i++) {
			Node node = new Node(num[i], div[i], sub[i], time[i], grade[i], pre[i]);
			db.addNode(node);
		}
		// SUBJECT_NUMBER만큼의 노드가 만들어지고 db의 arraylist에 들어감

		
		// prev node 설정
		// O(n^2)이라서 조금 더 효율적인 방법을 찾을 필요가 있음
		for (i = 0; i < SUBJECT_NUMBER; i++) {
			
			//선수강과목이 없는 경우
			if (db.getPrevious(i) == "None") {
				db.setPrev(i, head);
			} 		
			
			//선수강과목이 있는 경우
			else {
				for (int j = 0; j < SUBJECT_NUMBER; j++) {
					
					//선수강과목이 2개 이상인 경우
					if(db.getPrevious(i).contains("/")){
					
						String[] str = db.getPrevious(i).split("/");		// 문자열을 "/"를 기준으로 앞문자열과 뒷문자열로 나누고
						
						//특정 노드가 앞문자열과 같거나 뒷문자열과 같으면 prevNodeList에 추가
						if (db.getName(j) == str[0] || db.getName(j) == str[1]) {		
							db.setPrev(i, db.getNode(j));
						}
					}
					
					//선수강과목이 1개인 경우
					else{	
						if (db.getName(j) == db.getPrevious(i)) {
							db.setPrev(i, db.getNode(j));
						}
					}
				}

			}
		}

	}

	public DataBase read() {
		return db;
	}
}

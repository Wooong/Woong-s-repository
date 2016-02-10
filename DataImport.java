package RegisterInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DataImport {

	private final int SUBJECT_NUMBER = 66; // 과목의 갯수
	
	private DataBase db = new DataBase();

	// constructor
	public DataImport() {

		String fileName = "subject.txt";
		String num[] = new String[66];
		String div[] = new String[66];
		String sub[] = new String[66];
		String time[] = new String[66];
		String grade[] = new String[66];
		String pre[] = new String[66];
		String arr[] = new String[397];
		int i = 0;
		File file = new File("subject.txt");// read about file
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				System.out.println("2");
				String data = inputStream.next();
				arr[i] = data;
				i++;
				System.out.println("3");
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int k = 0; k < 66; k++) { // 각 줄별로 1차원 열 만듦
			num[k] = arr[6 * k];
			div[k] = arr[6 * k + 1];
			sub[k] = arr[6 * k + 2];
			time[k] = arr[6 * k + 3];
			grade[k] = arr[6 * k + 4];
			pre[k] = arr[6 * k + 5];
		}
		//System.out.println(Arrays.toString(sub));

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
			if (db.getPrevious(i) == "None") {
				db.setPrev(i, null);
			} else {
				for (int j = 0; j < SUBJECT_NUMBER; j++) {
					if (db.getName(j) == db.getPrevious(i)) {
						db.setPrev(i, db.getNode(j));
					} else {
						db.setPrev(i, null);
					}
				}

			}
		}

	}

	public DataBase read() {
		return db;
	}
}
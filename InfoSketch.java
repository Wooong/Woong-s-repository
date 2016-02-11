package RegisterInfo;

import processing.core.PApplet;
import processing.core.PImage;

public class InfoSketch extends PApplet {
	
	private static DataBase registerdb = new DataBase();

	public void settings() {
		size(640,480);
	}

	public void setup() {
		
	}
	float xx = mouseX, yy = mouseY;
	public void draw() {
		background(255);
		//translate(width/2, height/2);
		fill(200,100,100,255);
		ellipse(mouseX,mouseY,50,50);
		
	}

	public static void main(String args[]) {
		DataImport data = new DataImport();
		registerdb = data.read();
		PApplet.main(new String[] { "--bgcolor=#000000", "RegisterInfo.InfoSketch" });
		
		//test -> 1학년인 node만 골라서 만든 arraylist의 사이즈 = 15
		System.out.println(registerdb.getNodelist(1).size());
		
	}

}

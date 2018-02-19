import java.io.*;
import java.util.*;
public class LoadButton {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	 
	private PApplet processing;
	private float[] position;
	private String label;
	 
	public LoadButton(float x, float y, PApplet processing) {
		this.processing = processing;
		position = new float[] {x,y};
		label = "Load Room";
	}
	public float[] getPosition() {
		return position;
	}
	public int getWidth() {
		return WIDTH;
	}
	public int getHeight() {
		return HEIGHT;
	}
	public String getLabel() {
		return label;
	}
	public void update() {
		processing.fill(0);
		processing.text(label, position[0], position[1]);
	}
	
	public void mouseDown(Furniture[] furniture) {
		for (int i = 0; i< furniture.length; i++)
			furniture[1] = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			File inFile = new File("RoomData.ddd");
		    Scanner s = new Scanner(inFile);
		    while(s.hasNextLine()){
		    	  String ss = s.nextLine();
		    	  lines.add(ss);
		    }
		    
		    s.close();
		}catch(FileNotFoundException e) {
			System.out.println("WARNING: Could not load room contents from file RoomData.ddd.");
		}
		for (String line : lines) {
			String original = line;
			String p1 = null;
			float p2, p3;
			int p4;
			 try {
			  	  line = line.replaceAll("\\s+","");
			  	  p1 = line.split(":")[0];
			  	  String[] nums = line.split(":")[1].split(",");
			  	  p2 = Float.parseFloat(nums[0]);
			  	  p3 = Float.parseFloat(nums[1]);
			  	  p4 = Integer.parseInt(nums[2]);
				  
			 }catch(Exception e) {
				 System.out.println("WARNING: Found incorrectly formatted line in file: " + original);
				 continue;
			 }
			 try {
				 File inFile = new File("images/"+p1+".png");
				 if(inFile.isFile() == false) {
					 throw new Exception();
				 }
			 }catch(Exception e) {
				 System.out.println("WARNING: Could not find an image for a furniture object of type: " + p1);
				 continue;	 
			 }
			 try {
				 boolean ifNotFull = false;
				 for(int i = 0; i<furniture.length;i++) {
					 if(furniture[i] == null) {
						 ifNotFull = true;
						 break;
					 }
				 }
				 if(!ifNotFull) {
					 throw new Exception();
				 }
			 }catch(Exception e) {
				 System.out.println("WARNING: Unable to load more furniture.");
			 }
	  		 for (int i = 0; i<furniture.length; i++) {
		  		 if (furniture[i] == null) {
		  			 furniture[i] = new Furniture(p1,p2,p3,p4,processing);
		  			 break;
		  		  }
	  	 	  }
		}
	}	
	public boolean isMouseOver() {
		if(processing.mouseX >= (position[0] - WIDTH/2) && processing.mouseX <= (position[0] + WIDTH/2) && processing.mouseY >= (position[1] - HEIGHT/2) && processing.mouseY <= (position[1] + HEIGHT/2)) {
			return true;
		}else {
			return false;
		}
	}
}

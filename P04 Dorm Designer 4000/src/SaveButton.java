import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class SaveButton {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	 
	private PApplet processing;
	private float[] position;
	private String label;
	 
	public SaveButton(float x, float y, PApplet processing) {
		this.processing = processing;
		position = new float[] {x,y};
		label = "Save Room";
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
	
	public void mouseDown(Furniture[] furniture){
		try {
			File outFile = new File("RoomData.ddd");
			PrintWriter pw = new PrintWriter(outFile);
			for (Furniture f : furniture) {
				if (f != null) {
					pw.println(f.getType() + ":" + f.getPosition()[0] + "," + f.getPosition()[1] + "," + f.getRotations());
				}
			}
			pw.close();			
		} catch (FileNotFoundException e) {
          	System.out.println("WARNING: Could not save room contents to file RoomData.ddd.");
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

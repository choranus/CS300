
public class CreateBedButton {
	private static final int WIDTH = 96;
	private static final int HEIGHT = 32;
	 
	private PApplet processing;
	private float[] position;
	private String label;
	 
	public CreateBedButton(float x, float y, PApplet processing) {
		this.processing = processing;
		position = new float[] {x,y};
		label = "Create Bed";
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
	
	public Furniture mouseDown() {
		return new Furniture("bed",processing);
	}	
	public boolean isMouseOver() {
		if(processing.mouseX >= (position[0] - WIDTH/2) && processing.mouseX <= (position[0] + WIDTH/2) && processing.mouseY >= (position[1] - HEIGHT/2) && processing.mouseY <= (position[1] + HEIGHT/2)) {
			return true;
		}else {
			return false;
		}
	}
}

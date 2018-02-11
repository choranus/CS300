
public class Furniture {
	private PApplet processing;
	private PImage image;
	private float[] position;
	private boolean isDragging;
	private int rotations;
	private String type;
	
	// initializes the fields of a new bed object positioned in the center of the display
	public Furniture(String type,PApplet processing) {
		image = processing.loadImage("images/"+type+".png");
		position = new float[] {processing.width/2,processing.height/2};
		isDragging = false;
		this.processing = processing;
		rotations = 0;
		this.type = type;
	}
	//getters
	public PImage getImage() {
		return image;
	}
	public float[] getPosition() {
		return position;
	}
	public boolean getIsDragging() {
		return isDragging;
	}
	public int getRotations() {
		return rotations;
	}
	// draws this bed at its current position
	public void update() {
		if (isDragging) {
			position[0] = processing.mouseX;
			position[1] = processing.mouseY;
		}
	}
	// used to start dragging the bed, when the mouse is over this bed when it is pressed
	public void mouseDown() {
		if(isMouseOver()) {
			isDragging = true;
		}
	}
	// used to indicate that the bed is no longer being dragged
	public void mouseUp() {
		isDragging = false;
	}
	// helper method to determine whether the mouse is currently over this bed
	public boolean isMouseOver() {
		if (rotations % 2 == 0) {
			if(processing.mouseX >= (position[0] - image.width/2) && processing.mouseX <= (position[0] + image.width/2) && processing.mouseY >= (position[1] - image.height/2) && processing.mouseY <= (position[1] + image.height/2)) {
				return true;
			}
		}else {
			if(processing.mouseX >= (position[0] - image.height/2) && processing.mouseX <= (position[0] + image.height/2) && processing.mouseY >= (position[1] - image.width/2) && processing.mouseY <= (position[1] + image.width/2)) {
				return true;
			}
		}
		return false;
	}
	public void rotate() {
		rotations++;
	}
}

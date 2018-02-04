
public class Main {
	//static PImage bedImage;
	public static void main(String[] args) {
		Utility.startApplication();
	}
	public static void setup(Data data) {
		data.backgroundImage = data.processing.loadImage("images/background.png");
		data.bedImage = data.processing.loadImage("images/bed.png");
		//load image
		data.bedPositions = new float[6][2];
		for (int i = 0; i < data.bedPositions.length; i++) {
			data.bedPositions[i] = null;
		}
		//build bed positions
		data.dragBedIndex = -1;
	}
	public static void update(Data data) {
		data.processing.background(100,150,250);
		data.processing.image(data.backgroundImage, data.processing.width/2, data.processing.height/2);
		if (data.dragBedIndex != -1) {
			data.bedPositions[data.dragBedIndex][0] = data.processing.mouseX;
			data.bedPositions[data.dragBedIndex][1] = data.processing.mouseY;
		}
		for (int i = 0; i < data.bedPositions.length; i++) {
			if (data.bedPositions[i] != null) {
				data.processing.image(data.bedImage, data.bedPositions[i][0], data.bedPositions[i][1]);
			}
		}
		
	}
	public static void mouseDown(Data data) {
		for (int i = 0; i < data.bedPositions.length; i++) {
			if(data.bedPositions[i] != null) {
				if(data.processing.mouseX >= (data.bedPositions[i][0] - data.bedImage.width/2) && data.processing.mouseX <= (data.bedPositions[i][0] + data.bedImage.width/2) && data.processing.mouseY >= (data.bedPositions[i][1] - data.bedImage.height/2) && data.processing.mouseY <= (data.bedPositions[i][1] + data.bedImage.height/2)) {
					data.dragBedIndex = i;
				}
			}
		}
	}
	public static void mouseUp(Data data) {
		data.dragBedIndex = -1;
	}
	public static void keyPressed(Data data) {
		if (data.processing.key == 'b' || data.processing.key == 'B') {
			for (int i = 0; i < data.bedPositions.length; i++) {
				if (data.bedPositions[i] == null) {
					data.bedPositions[i] = new float[] {data.processing.width/2,data.processing.height/2};
					break;
				}
			}
		}
	}
	
}

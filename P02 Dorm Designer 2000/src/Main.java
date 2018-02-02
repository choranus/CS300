
public class Main {

	public static void main(String[] args) {
		Utility.startApplication();
	}
	public static void setup(Data data) {
		data.processing.background(100,150,250);
		PImage backgroundImage = data.processing.loadImage("images/background.png");
		data.processing.image(backgroundImage, data.processing.width/2, data.processing.height/2);
	}
	public static void update(Data data) {
		PImage bedImage = data.processing.loadImage("images/bed.png");
		data.processing.image(bedImage, data.processing.width/2, data.processing.height/2);
	}

}

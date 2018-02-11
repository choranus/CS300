
public class Main {
	private PApplet processing;
	private PImage backgroundImage;
	private Furniture[] furniture;
	private CreateBedButton bedButton;
	private CreateSofaButton sofaButton;
	//static PImage bedImage;
	public static void main(String[] args) {
		Utility.startApplication();
	}
	public Main(PApplet processing) {
		backgroundImage = processing.loadImage("images/background.png");
		this.processing = processing;
		bedButton = new CreateBedButton(50, 24, processing);
		sofaButton = new CreateSofaButton(150, 24, processing);
		furniture = new Furniture [6];
		for (int i = 0; i < furniture.length; i++) {
			furniture[i] = null;
		}
	}
	public void update() {
		processing.background(100,150,250);
		processing.image(backgroundImage, processing.width/2, processing.height/2);
		if(bedButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(bedButton.getPosition()[0] - bedButton.getWidth()/2, bedButton.getPosition()[1] - bedButton.getHeight()/2,bedButton.getPosition()[0] + bedButton.getWidth()/2,bedButton.getPosition()[1] + bedButton.getHeight()/2);
		bedButton.update();
		
		if(sofaButton.isMouseOver()) {
			processing.fill(100);
		}else {
			processing.fill(200);
		}
		processing.rect(sofaButton.getPosition()[0] - sofaButton.getWidth()/2, sofaButton.getPosition()[1] - sofaButton.getHeight()/2,sofaButton.getPosition()[0] + sofaButton.getWidth()/2,sofaButton.getPosition()[1] + sofaButton.getHeight()/2);
		sofaButton.update();
		for (int i = 0; i < furniture.length; i++) {
			if(furniture[i] != null) {
				furniture[i].update();
			}
		}
		for (int i = 0; i < furniture.length; i++) {
			if(furniture[i] != null) {
				processing.image(furniture[i].getImage(), furniture[i].getPosition()[0], furniture[i].getPosition()[1], furniture[i].getRotations()*PApplet.PI/2);
			}
		}
		
	}
	public void mouseDown() {
		for (int i = 0; i <furniture.length; i++) {
			if (furniture[i] == null) {
				if (bedButton.isMouseOver()) {
					furniture[i] = bedButton.mouseDown();
					break;
				}else if(sofaButton.isMouseOver()){
					furniture[i] = sofaButton.mouseDown();
					break;
				}
			}
		}
		for (int i = furniture.length - 1; i >=0; i--) {
			if(furniture[i] != null) {
				furniture[i].mouseDown();
				if (furniture[i].getIsDragging()) {
					break;
				}
			}
		}
	}
	public void mouseUp() {
		for (int i = 0; i < furniture.length; i++) {
			if(furniture[i] != null) {
				furniture[i].mouseUp();
			}
		}
	}
	public void keyPressed() {
		//Remove a bed
		if (processing.key == 'd' || processing.key == 'D') {
			for (int i = furniture.length - 1; i >=0; i--) {
				if(furniture[i] != null) {
					if(furniture[i].isMouseOver()) {
						furniture[i] = null;
						break;
					}
				}
			}
		}
		//Rotate a bed
		if (processing.key == 'r' || processing.key == 'R') {
			for (int i = furniture.length - 1; i >=0; i--) {
				if(furniture[i] != null) {
					if(furniture[i].isMouseOver()) {
						furniture[i].rotate();
						break;
					}
				}
			}
		}		
	}
	
}

package baseball;

public class GameController {
	private final Computer computer;

	public GameController() {
		this.computer = Computer.createAndInit();
	}

	public void run() {
		boolean running = true;
		while (running) {
			String data = Printer.enterNumbers();
		}

	}


}

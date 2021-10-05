package baseball;

public class Application {
	public static void main(String[] args) {
		// TODO 숫자 야구 게임 구현
		boolean gameStart = true;
		while (gameStart) {
			GameController gameController = new GameController();
			gameController.run();
			gameStart = gameController.restartOrEnd();
		}
	}
}

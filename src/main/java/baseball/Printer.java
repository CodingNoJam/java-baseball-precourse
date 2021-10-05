package baseball;

import nextstep.utils.Console;

public class Printer {
	public static String enterNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static String enterRestartOrEnd() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Console.readLine();
	}
}

package baseball;

public class GameMessage {
	public static final String ENTER_NUMBERS = "숫자를 입력해주세요 : ";
	public static final String ENTER_RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static final String ANSWER_NOTHING = "낫싱";
	public static final String ANSWER_BALL = "볼";
	public static final String ANSWER_STRIKE = "스트라이크";
	public static final String ANSWER_THREE_STRIKE = "스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	public static final String ANSWER_END = "끝";
	public static final String ERROR_DATA_LENGTH_DATA_TYPE = "[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다.";
	public static final String ERROR_DUPLICATE_DATA = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";
	public static final String ERROR_RESTART_OR_END_DATA_WRONG_VALUE = "[ERROR] 1 또는 2만 입력 가능합니다.";
}


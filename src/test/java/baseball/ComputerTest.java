package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ComputerTest {
	private Computer computer;

	@BeforeEach
	void beforeEach() {
		computer = Computer.createAndInit();
	}

	@Test
	void 컴퓨터객체_생성_테스트() {
		assertThat(computer).isNotNull();
	}

	@Test
	void 랜덤숫자_자릿수_테스트() {
		List<Integer> numbers = computer.getNumbers();
		assertThat(numbers).hasSize(3);
	}

	@Test
	void 랜덤숫자_범위_테스트() {
		List<Integer> numbers = computer.getNumbers();
		for (Integer number : numbers) {
			assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
		}
	}

	@Test
	void 랜덤숫자_중복여부_테스트() {
		List<Integer> numbers = computer.getNumbers();
		Set<Integer> checkSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for (Integer number : numbers) {
			checkSet.remove(number);
		}
		assertThat(numbers.size()).isEqualTo(9 - checkSet.size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"1234", "우아한테크코스", "1", "39", "car", "000"})
	void 플레이어_입력값_길이_타입_검증_테스트(String input) {
		String[] answer = computer.createAnswer(input);
		assertThat(answer[0]).isEqualTo("3");
		assertThat(answer[1]).isEqualTo("[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"999", "121", "939", "422", "882", "111"})
	void 플레이어_입력값_중복_검증_테스트(String input) {
		String[] answer = computer.createAnswer(input);
		assertThat(answer[0]).isEqualTo("3");
		assertThat(answer[1]).isEqualTo("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
	}
}
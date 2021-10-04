package baseball;

import static org.assertj.core.api.Assertions.*;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	void 컴퓨터객체_생성_테스트() {
		Computer computer = Computer.createAndInit();
		assertThat(computer).isNotNull();
	}

	@Test
	void 랜덤숫자_생성_테스트() {
		Computer computer = Computer.createAndInit();
		Set<Integer> numbers = computer.getNumbers();
		assertThat(numbers).hasSize(3);
		for (Integer number : numbers) {
			System.out.println(number);
			assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
		}
	}
}
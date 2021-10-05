package baseball;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

class GameControllerTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		super.setUp();
	}

	@Test
	void 입력받은값_검증_테스트() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(7, 1, 4);
			run("7134", "1", "000", "555", "122", "714", "3", "2");
			verify("[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다."
				, "[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다."
				, "[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다."
				, "[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다."
				, "[ERROR] 중복된 숫자는 입력할 수 없습니다."
				, "[ERROR] 중복된 숫자는 입력할 수 없습니다."
				, "[ERROR] 1 또는 2만 입력 가능합니다.");
		}
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}

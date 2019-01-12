package product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.format.DateTimeParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import product.domain.DateFormula;

@RunWith(Enclosed.class)
public class CalculationServiceTest {

	public static class 日付計算例外処理 {

		private CalculationService sut;

		@Before
		public void setUp() throws Exception {
			sut = new CalculationService();
		}

		@Test
		public void 計算基準日にNULLを渡すとNullPointerExceptionとなる事() throws Exception {
			assertThatThrownBy(() -> {
				sut.calculate(null, setUpFormula(0, 0, 0));
			}).isInstanceOf(NullPointerException.class);
		}

		@Test
		public void 計算基準日をyyyyMMdd以外の形式で渡すとDateTimeParseExceptionとなる事() throws Exception {
			assertThatThrownBy(() -> {
				sut.calculate("201812", setUpFormula(0, 0, 0));
			}).isInstanceOf(DateTimeParseException.class);
		}

		@Test
		public void 日付計算式にNULLを渡すとNullPointerExceptionとなる事() throws Exception {
			assertThatThrownBy(() -> {
				sut.calculate("20181201", null);
			}).isInstanceOf(NullPointerException.class);
		}

		private DateFormula setUpFormula(int 加減年, int 加減月, int 加減日) {
			DateFormula formula = new DateFormula();
			formula.setAdjustmentYear(加減年);
			formula.setAdjustmentMonth(加減月);
			formula.setAdjustmentDay(加減日);
			return formula;
		}
	}

	@RunWith(Parameterized.class)
	public static class 日付計算 {

		private String 基準日;
		private int 加減年;
		private int 加減月;
		private int 加減日;
		private String 期待値;

		@Parameters(name = "{index} 基準日:{0}, 加減年:{1}, 加減月:{2}, 加減日:{3}, 期待値:{4}")
		public static Object[][] params() {
			return new Object[][] {
				// すべて未指定
				{"20181201", 0, 0, 0, "20181201"},
				// すべて指定
				{"20181201", 1, 1, 1, "20200102"},
				// 月の加算で日数の切り捨て
				{"20181031", 0, 1, 0, "20181130"},
				// 年月またぎ
				{"20181202", 0, 13, 0, "20200102"},
				{"20181202", 0, 0, 365, "20191202"},
				// 翌日
				{"20181201", 0, 0, 1, "20181202"},
				// 前日
				{"20181201", 0, 0, -1, "20181130"},
				// 翌月
				{"20181101", 0, 1, 0, "20181201"},
				// 前月
				{"20181201", 0, -1, 0, "20181101"},
				// 翌年
				{"20181201", 1, 0, 0, "20191201"},
				// 前年
				{"20181201", -1, 0, 0, "20171201"},
			};
		}

		public 日付計算(String 基準日, int 加減年, int 加減月, int 加減日, String 期待値) {
			this.基準日 = 基準日;
			this.加減年 = 加減年;
			this.加減月 = 加減月;
			this.加減日 = 加減日;
			this.期待値 = 期待値;
		}

		@Test
		public void test() throws Exception {
			DateFormula formula = new DateFormula();
			formula.setAdjustmentYear(加減年);
			formula.setAdjustmentMonth(加減月);
			formula.setAdjustmentDay(加減日);

			CalculationService sut = new CalculationService();
			String actual = sut.calculate(基準日, formula);

			assertThat(actual).isEqualTo(期待値);
		}
	}
}

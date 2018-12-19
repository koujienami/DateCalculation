package product.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import product.domain.DateFormula;

@RunWith(Enclosed.class)
public class CalculationServiceTest {

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
			DateFormula formula = setUpFormula(加減年, 加減月, 加減日);

			CalculationService sut = new CalculationService();
			String actual = sut.calculate(基準日, formula);

			assertThat(actual).isEqualTo(期待値);
		}

		/**
		 * 日付計算式の初期設定。
		 * 
		 * @return 設定された日付計算式
		 */
		private DateFormula setUpFormula(int year, int month, int day) {
			DateFormula formula = new DateFormula();
			formula.setAdjustmentYear(year);
			formula.setAdjustmentMonth(month);
			formula.setAdjustmentDay(day);
			return formula;
		}

	}
}

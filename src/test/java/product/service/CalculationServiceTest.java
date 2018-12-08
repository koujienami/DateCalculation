package product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import product.domain.DateFormula;

public class CalculationServiceTest {
	
	private CalculationService sut;
	
	@Before
	public void before() throws Exception {
		sut = new CalculationService();
	}
	
	@Test
	public void 翌日の日付計算式に計算基準日20181208を渡して計算結果が20181209になること() throws Exception {
		DateFormula formula = setUpFormula(0,0,1);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20181209");
	}
	
	@Test
	public void 翌月の日付計算式に計算基準日20181208を渡して計算結果が20190108になること() throws Exception {
		DateFormula formula = setUpFormula(0,1,0);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20190108");
	}
	
	@Test
	public void 翌年の日付計算式に計算基準日20181208を渡して計算結果が20191208になること() throws Exception {
		DateFormula formula = setUpFormula(1,0,0);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20191208");
	}
	
	@Test
	public void 前日の日付計算式に計算基準日20181208を渡して計算結果が20181207になること() throws Exception {
		DateFormula formula = setUpFormula(0,0,-1);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20181207");
	}
	
	@Test
	public void 前月の日付計算式に計算基準日20181208を渡して計算結果が20181108になること() throws Exception {
		DateFormula formula = setUpFormula(0,-1,0);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20181108");
	}
	
	@Test
	public void 前年の日付計算式に計算基準日20181208を渡して計算結果が20171208になること() throws Exception {
		DateFormula formula = setUpFormula(-1,0,0);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20171208");
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

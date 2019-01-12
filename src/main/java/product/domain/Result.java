package product.domain;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 画面用の計算結果オブジェクトです。<br/>
 * 一覧画面の計算結果の行を表現します。
 * 
 * @author koujienami
 */
public class Result {

	/** 日付計算式 */
	private DateFormula formula;
	/** 計算結果 */
	private String calculated;

	/**
	 * コンストラクタ。
	 * 
	 * @param formula 日付計算式
	 */
	public Result(DateFormula formula) {
		this.formula = formula;
	}

	/** {@link DateFormula#getDateId()} */
	public String getDateId() {
		return formula.getDateId();
	}

	/** {@link DateFormula#getDateName()} */
	public String getDateName() {
		return formula.getDateName();
	}

	/**
	 * 日付計算式を取得します。
	 * 
	 * @return 日付計算式
	 */
	public DateFormula getFormula() {
		return formula;
	}

	/**
	 * 計算結果を取得します。
	 * 
	 * @return 計算結果
	 */
	public String getCalculated() {
		return calculated;
	}

	/**
	 * 計算結果を設定します。
	 * 
	 * @param calculated 計算結果
	 */
	public void setCalculated(String calculated) {
		this.calculated = calculated;
	}

	/**
	 * 年月日順に区切られた計算式を取得します。<br/>
	 * 画面用に「 / 」区切りで加減値をそれぞれ年月日順で表示します。
	 * 
	 * @return 年月日順に区切られた計算式
	 */
	public String getYmdFormula() {
		int[] ymdFormula = {formula.getAdjustmentYear(), formula.getAdjustmentMonth(), formula.getAdjustmentDay()};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(ymdFormula).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}
}

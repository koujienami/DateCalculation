package product.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 日付計算処理をシミュレートする画面を表現するフォームビーンです。
 * 
 * @author koujienami
 */
public class SimulationForm {

	/** 計算基準日 */
	private String baseDate;
	/** 計算結果 */
	private List<Result> results;

	/**
	 * デフォルトコンストラクタ。
	 * 
	 * @deprecated Thymeleafによる生成用。それ以外での使用禁止。
	 */
	@Deprecated
	public SimulationForm() {
	}

	/**
	 * コンストラクタ。
	 * 
	 * @param baseDate 計算基準日
	 * @param results 日付計算式一覧
	 */
	public SimulationForm(String baseDate, List<DateFormula> results) {
		this.baseDate = baseDate;
		this.results = new ArrayList<>();
		results.stream().forEach(r -> this.results.add(convertToResult(r)));
	}

	/**
	 * 計算基準日を取得します。
	 * 
	 * @return 計算基準日
	 */
	public String getBaseDate() {
		return baseDate;
	}

	/**
	 * 計算基準日を設定します。
	 * 
	 * @param baseDate 計算基準日
	 */
	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	/**
	 * 計算結果を取得します。
	 * 
	 * @return 計算結果
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * 日付計算式の内容を画面用の計算結果オブジェクトに変換します。
	 * 
	 * @param formula 日付計算式
	 * @return 画面用計算結果オブジェクト
	 */
	public Result convertToResult(DateFormula formula) {
		return new Result(formula);
	}
}

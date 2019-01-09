package product.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 日付計算式を表現するオブジェクトです。
 * 
 * @author koujienami
 */
public class DateFormula {

	/** 日付ID */
	@NotEmpty
	@Size(min = 1, max = 6)
	private String dateId;
	/** 日付名 */
	@NotEmpty
	@Size(min = 1, max = 32)
	private String dateName;
	/** 加減値(年) */
	private int adjustmentYear;
	/** 加減値(月) */
	private int adjustmentMonth;
	/** 加減値(日) */
	private int adjustmentDay;

	/**
	 * 日付IDを取得します。
	 * 
	 * @return 日付ID
	 */
	public String getDateId() {
		return dateId;
	}

	/**
	 * 日付IDを設定します。
	 * 
	 * @param dateId 日付ID
	 */
	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	/**
	 * 日付名を取得します。
	 * 
	 * @return 日付名
	 */
	public String getDateName() {
		return dateName;
	}

	/**
	 * 日付名を設定します。
	 * 
	 * @param dateName 日付名
	 */
	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	/**
	 * 加減値(年)を取得します。
	 * 
	 * @return 加減値(年)
	 */
	public int getAdjustmentYear() {
		return adjustmentYear;
	}

	/**
	 * 加減値(年)を設定します。
	 * 
	 * @param adjustmentYear 加減値(年)
	 */
	public void setAdjustmentYear(int adjustmentYear) {
		this.adjustmentYear = adjustmentYear;
	}

	/**
	 * 加減値(月)を取得します。
	 * 
	 * @return 加減値(月)
	 */
	public int getAdjustmentMonth() {
		return adjustmentMonth;
	}

	/**
	 * 加減値(月)を設定します。
	 * 
	 * @param adjustmentMonth 加減値(月)
	 */
	public void setAdjustmentMonth(int adjustmentMonth) {
		this.adjustmentMonth = adjustmentMonth;
	}

	/**
	 * 加減値(日)を取得します。
	 * 
	 * @return 加減値(日)
	 */
	public int getAdjustmentDay() {
		return adjustmentDay;
	}

	/**
	 * 加減値(日)を設定します。
	 * 
	 * @param adjustmentDay 加減値(日)
	 */
	public void setAdjustmentDay(int adjustmentDay) {
		this.adjustmentDay = adjustmentDay;
	}

}

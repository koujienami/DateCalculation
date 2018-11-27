package product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import product.domain.DateFormula;

/**
 * 日付計算式を扱うリポジトリです。<br/>
 * 実体は{@link DateFormula}とDBテーブル(dateformula)を紐づける為のORMクラスです。
 * 
 * @author koujienami
 */
@Mapper
public interface DateFormulaRepository {

	/**
	 * 日付計算式の一覧を取得します。
	 * 
	 * @return 日付計算式の一覧
	 */
	@Select("SELECT * FROM dateformula ORDER BY dateId ASC")
	List<DateFormula> select();

	/**
	 * 日付計算式を新規登録します。
	 * 
	 * @param dateMaster 登録する日付計算式
	 */
	@Insert("INSERT INTO dateformula VALUES(#{dateId}, #{dateName}, #{adjustmentYear}, #{adjustmentMonth}, #{adjustmentDay})")
	void insert(DateFormula dateMaster);
}

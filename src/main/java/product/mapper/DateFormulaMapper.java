package product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import product.domain.DateFormula;

@Mapper
public interface DateFormulaMapper {

	@Select("SELECT * FROM dateformula ORDER BY dateId ASC")
	List<DateFormula> select();

	@Insert("INSERT INTO dateformula VALUES(#{dateId}, #{dateName}, #{adjustmentYear}, #{adjustmentMonth}, #{adjustmentDay})")
	void insert(DateFormula dateMaster);
}

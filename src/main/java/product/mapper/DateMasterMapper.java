package product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import product.domain.DateMaster;

@Mapper
public interface DateMasterMapper {

	@Select("SELECT * FROM datemaster ORDER BY dateId ASC")
	List<DateMaster> select();

	@Insert("INSERT INTO datemaster VALUES(#{dateId}, #{dateName}, #{adjustmentYear}, #{adjustmentMonth}, #{adjustmentDay})")
	void insert(DateMaster dateMaster);
}

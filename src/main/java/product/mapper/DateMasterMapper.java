package product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import product.domain.DateMaster;

@Mapper
public interface DateMasterMapper {

	List<DateMaster> select();
}

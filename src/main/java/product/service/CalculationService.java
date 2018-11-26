package product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import product.domain.DateMaster;
import product.mapper.DateMasterMapper;

@Service
public class CalculationService {

	@Autowired
	private DateMasterMapper dateMaster;

	public List<DateMaster> search() {
		return dateMaster.select();
	}

	@Transactional
	public void register(DateMaster bean) {
		dateMaster.insert(bean);
	}
}

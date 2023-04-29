package net.softsociety.mra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.mra.dao.MedicineDAO;
import net.softsociety.mra.vo.Medicine;
import net.softsociety.mra.vo.ShowSign;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineDAO dao;
	
	@Override
	public List<Medicine> selectAll() {
		List<Medicine> result = dao.selectAll();
		return result;
	}

	@Override
	public Medicine selectOne(int seq) {
		Medicine medicine = dao.selectOne(seq);
		return medicine;
	}

	@Override
	public boolean insertMedicine(Medicine medicine) {
		boolean result = dao.insertMedicine(medicine);
		return result;
	}

	@Override
	public boolean updateMedicine(Medicine medicine) {
		boolean result = dao.updateMedicine(medicine);
		return result;
	}

	@Override
	public boolean deleteMedicine(int seq) {
		boolean result = dao.deleteMedicine(seq);
		return result;
	}

	@Override
	public List<Medicine> selectAll(Medicine medicine) {
		List<Medicine> result = dao.selectAll2(medicine);
		return result;
	}

	@Override
	public List<Medicine> selectAll(ShowSign showsign) {
		List<Medicine> result = dao.selectAll3(showsign);
		return result;
	}

	
}

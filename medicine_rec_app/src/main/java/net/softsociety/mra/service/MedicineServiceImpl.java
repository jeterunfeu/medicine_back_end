package net.softsociety.mra.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.mra.dao.MedicineDAO;
import net.softsociety.mra.util.PageNavigator;
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
	public List<Medicine> selectAll(PageNavigator page, Medicine medicine) {
		RowBounds rb = new RowBounds(page.getStartRecord(), page.getCountPerPage());
		List<Medicine> result = dao.selectAll2(medicine, rb);
		return result;
	}

	@Override
	public List<Medicine> selectAll(PageNavigator page, ShowSign showsign) {
		List<Medicine> result = dao.selectAll3(showsign);
		return result;
	}

	@Override
	public PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, Medicine medicine) {
		int total = dao.countAll2(medicine);
		PageNavigator result = new PageNavigator(pagePerGroup, countPerPage, page, total);
		return result;
	}

	@Override
	public PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, ShowSign showsign) {
		int total = dao.countAll3(showsign);
		PageNavigator result = new PageNavigator(pagePerGroup, countPerPage, page, total);
		return result;
	}

	
}

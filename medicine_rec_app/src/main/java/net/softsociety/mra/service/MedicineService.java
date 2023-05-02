package net.softsociety.mra.service;

import java.util.List;

import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.Medicine;
import net.softsociety.mra.vo.ShowSign;

public interface MedicineService {

	List<Medicine> selectAll();

	Medicine selectOne(int seq);

	boolean insertMedicine(Medicine medicine);

	boolean updateMedicine(Medicine medicine);

	boolean deleteMedicine(int seq);

	List<Medicine> selectAll(PageNavigator page, Medicine medicine);

	List<Medicine> selectAll(PageNavigator result, ShowSign showsign);
	
	PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, Medicine medicine);

	PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, ShowSign showsign);

}

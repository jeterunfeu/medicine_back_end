package net.softsociety.mra.service;

import java.util.List;


import net.softsociety.mra.vo.Medicine;
import net.softsociety.mra.vo.ShowSign;

public interface MedicineService {

	List<Medicine> selectAll();

	Medicine selectOne(int seq);

	boolean insertMedicine(Medicine medicine);

	boolean updateMedicine(Medicine medicine);

	boolean deleteMedicine(int seq);

	List<Medicine> selectAll(Medicine medicine);

	List<Medicine> selectAll(ShowSign showsign);

	
}

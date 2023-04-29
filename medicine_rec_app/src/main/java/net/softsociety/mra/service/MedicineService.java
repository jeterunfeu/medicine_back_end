package net.softsociety.mra.service;

import java.util.List;


import net.softsociety.mra.vo.Medicine;

public interface MedicineService {

	List<Medicine> selectAll();

	Medicine selectOne(int seq);

	boolean insertMedicine(Medicine medicine);

	boolean updateMedicine(Medicine medicine);

	boolean deleteMedicine(int seq);

	
}

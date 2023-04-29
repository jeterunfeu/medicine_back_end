package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.mra.vo.Medicine;
import net.softsociety.mra.vo.ShowSign;

@Mapper
public interface MedicineDAO {

	List<Medicine> selectAll();

	Medicine selectOne(int seq);

	boolean insertMedicine(Medicine medicine);

	boolean updateMedicine(Medicine medicine);

	boolean deleteMedicine(int seq);

	List<Medicine> selectAll2(Medicine medicine);

	List<Medicine> selectAll3(ShowSign showsign);

}

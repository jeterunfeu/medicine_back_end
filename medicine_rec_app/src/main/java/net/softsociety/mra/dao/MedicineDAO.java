package net.softsociety.mra.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.mra.vo.Medicine;
import net.softsociety.mra.vo.ShowSign;

@Mapper
public interface MedicineDAO {

	List<Medicine> selectAll();

	Medicine selectOne(int seq);

	boolean insertMedicine(Medicine medicine);

	boolean updateMedicine(Medicine medicine);

	boolean deleteMedicine(int seq);

	List<Medicine> selectAll2(Medicine medicine, RowBounds rb);

	List<Medicine> selectAll3(ShowSign showsign);

	int countAll2(Medicine medicine);

	int countAll3(ShowSign showsign);

}

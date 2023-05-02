package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.mra.vo.ShowSign;

@Mapper
public interface ShowSignDAO {

	List<ShowSign> selectAll();

	ShowSign selctOne(int seq);

	boolean insertShowSign(ShowSign showsign);

	boolean updateShowSign(ShowSign showsign);

	boolean deleteShowSign(int seq);

	List<ShowSign> selectAllByGroup(ShowSign showsign, RowBounds rb);

	int countAllByGroup(ShowSign showSign);

}

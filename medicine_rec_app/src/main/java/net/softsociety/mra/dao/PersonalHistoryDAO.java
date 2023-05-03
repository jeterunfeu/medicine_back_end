package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.mra.vo.History;
import net.softsociety.mra.vo.PersonalHistory;

@Mapper
public interface PersonalHistoryDAO {

	List<History> selectAll(History history, RowBounds rb);

	PersonalHistory selectOne(int seq);

	boolean insertPersonalHistory(PersonalHistory personalhistory);

	boolean updatePersonalHistory(PersonalHistory personalhistory);

	boolean deletePersonalHistory(int seq);

	int countAll(History history);

}

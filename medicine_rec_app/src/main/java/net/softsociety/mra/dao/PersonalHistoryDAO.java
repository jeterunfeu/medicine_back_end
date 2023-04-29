package net.softsociety.mra.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.mra.vo.PersonalHistory;

@Mapper
public interface PersonalHistoryDAO {

	List<PersonalHistory> selectAll();

	PersonalHistory selectOne(int seq);

	boolean insertPersonalHistory(PersonalHistory personalhistory);

	boolean updatePersonalHistory(PersonalHistory personalhistory);

	boolean deletePersonalHistory(int seq);

}

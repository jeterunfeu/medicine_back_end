package net.softsociety.mra.dao;

import java.util.List;

import net.softsociety.mra.vo.PersonalHistory;

public interface PersonalHistoryDAO {

	List<PersonalHistory> selectAll();

	PersonalHistory selectOne(int seq);

	boolean insertPersonalHistory(PersonalHistory personalhistory);

	boolean updatePersonalHistory(PersonalHistory personalhistory);

	boolean deletePersonalHistory(int seq);

}

package net.softsociety.mra.service;

import java.util.List;

import net.softsociety.mra.vo.PersonalHistory;

public interface PersonalHistoryService {

	List<PersonalHistory> selectAll();

	PersonalHistory selectOne(int seq);

	boolean insertPersonalHistroy(PersonalHistory personalhistory);

	boolean updatePersonalHistroy(PersonalHistory personalhistory);

	boolean deletePersonalHistory(int seq);

}

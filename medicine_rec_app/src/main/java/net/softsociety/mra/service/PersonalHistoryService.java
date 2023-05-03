package net.softsociety.mra.service;

import java.util.List;

import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.History;
import net.softsociety.mra.vo.PersonalHistory;

public interface PersonalHistoryService {

	List<History> selectAll(PageNavigator result, History history);

	PersonalHistory selectOne(int seq);

	boolean insertPersonalHistroy(PersonalHistory personalhistory);

	boolean updatePersonalHistroy(PersonalHistory personalhistory);

	boolean deletePersonalHistory(int seq);

	PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, History history);

}

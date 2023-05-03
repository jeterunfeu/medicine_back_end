package net.softsociety.mra.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.mra.dao.PersonalHistoryDAO;
import net.softsociety.mra.util.PageNavigator;
import net.softsociety.mra.vo.History;
import net.softsociety.mra.vo.PersonalHistory;

@Service
public class PersonalHistoryServiceImpl implements PersonalHistoryService {

	@Autowired
	PersonalHistoryDAO dao;

	@Override
	public List<History> selectAll(PageNavigator page, History history) {
		RowBounds rb = new RowBounds(page.getStartRecord(), page.getCountPerPage());
		List<History> list = dao.selectAll(history, rb);
		return list;
	}

	@Override
	public PersonalHistory selectOne(int seq) {
		PersonalHistory personalhistory = dao.selectOne(seq);
		return personalhistory;
	}

	@Override
	public boolean insertPersonalHistroy(PersonalHistory personalhistory) {
		boolean result = dao.insertPersonalHistory(personalhistory);
		return result;
	}

	@Override
	public boolean updatePersonalHistroy(PersonalHistory personalhistory) {
		boolean result = dao.updatePersonalHistory(personalhistory);
		return result;
	}

	@Override
	public boolean deletePersonalHistory(int seq) {
		boolean result = dao.deletePersonalHistory(seq);
		return result;
	}

	@Override
	public PageNavigator getPageNavigator(int pagePerGroup, int countPerPage, int page, History history) {
		int total = dao.countAll(history);
		PageNavigator result = new PageNavigator(pagePerGroup, countPerPage, page, total);
		return result;
	}
	
	
	
}

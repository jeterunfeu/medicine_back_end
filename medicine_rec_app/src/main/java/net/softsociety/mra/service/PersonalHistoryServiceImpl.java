package net.softsociety.mra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.mra.dao.PersonalHistoryDAO;
import net.softsociety.mra.vo.PersonalHistory;

@Service
public class PersonalHistoryServiceImpl implements PersonalHistoryService {

	@Autowired
	PersonalHistoryDAO dao;

	@Override
	public List<PersonalHistory> selectAll() {
		List<PersonalHistory> list = dao.selectAll();
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
	
	
	
}
